package com.example.yune.mybanban.mvp.presenter;

import com.example.yune.mybanban.base.BasePresenter;
import com.example.yune.mybanban.mvp.Login.ILoginModel;
import com.example.yune.mybanban.mvp.Login.ILoginModelImpl;
import com.example.yune.mybanban.mvp.model.BaseModel;
import com.example.yune.mybanban.mvp.model.PostBean;
import com.example.yune.mybanban.mvp.model.bean.LoginJson;
import com.example.yune.mybanban.mvp.view.LoginView;
import com.example.yune.mybanban.retrofit.ApiSubscriber;
import com.example.yune.mybanban.retrofit.HttpApi;

/**
 * Created by Yune on 2016/11/9.
 */

public class LoginPresenter extends BasePresenter<LoginView> {


    ILoginModel model;

    public LoginPresenter(LoginView loginView) {
        addachView(loginView);
        model = new ILoginModelImpl();
    }


    public void login() {
        boolean b = model.setData(mView.getData());
        if (!b)
            return;
        mView.showProgress();
        PostBean pb = new PostBean(setData(mView.getData()), mView.getData());
        addSubscription(mRetrofit.create(HttpApi.class).login(pb), new ApiSubscriber<BaseModel<LoginJson>>() {

            @Override
            public void onSuccess(BaseModel<LoginJson> model) {
                mView.getDataSuccess(model);
            }

            @Override
            public void onFaild(String msg) {
                mView.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                mView.hideProgress();
            }
        });
    }
}
