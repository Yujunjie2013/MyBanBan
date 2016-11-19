package com.example.yune.mybanban.retrofit;

import com.example.yune.mybanban.mvp.model.BaseModel;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by Yune on 2016/11/9.
 */

public abstract class ApiSubscriber<M> extends Subscriber<M> {

    public abstract void onSuccess(M model);

    public abstract void onFaild(String msg);

    public abstract void onFinish();

    @Override
    public void onCompleted() {
        onFinish();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            String message = httpException.message();
            if (code == 504) {
                message = "网络不给力";
            } else if (code == 502 || code == 404) {
                message = "服务器异常，请稍后再试";
            }
            onFaild(message);
        } else {
            onFaild(e.getMessage());
        }
        onFinish();
    }

    @Override
    public void onNext(M m) {
        if (m instanceof BaseModel) {
            BaseModel bm = (BaseModel) m;
            if ("0000".equals(bm.getStatus())) {
                onSuccess(m);
            } else {
                onFaild(bm.getMessage());
            }
        } else {
            onFaild("不是BaseModel类型");
        }
    }
}
