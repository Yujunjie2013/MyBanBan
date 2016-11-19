package com.example.yune.mybanban.retrofit;

import com.example.yune.mybanban.mvp.model.BaseModel;
import com.example.yune.mybanban.mvp.model.PostBean;
import com.example.yune.mybanban.mvp.model.bean.LoginJson;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Yune on 2016/11/9.
 */

public interface HttpApi {

    /**
     * 登录接口
     *
     * @param postBean
     * @return
     */
    @POST("ofclogin/login")
    Observable<BaseModel<LoginJson>> login(@Body PostBean postBean);
}
