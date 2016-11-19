package com.example.yune.mybanban.mvp.view;

import com.example.yune.mybanban.base.BaseView;
import com.example.yune.mybanban.mvp.model.BaseModel;
import com.example.yune.mybanban.mvp.model.bean.LoginBean;

/**
 * Created by Yune on 2016/11/9.
 */

public interface LoginView extends BaseView {
    void getDataSuccess(BaseModel data);

    void getDataFail(String msg);

    LoginBean getData();
}
