package com.example.yune.mybanban.mvp.model;

/**
 * Created by Yune on 2016/11/9.
 */

public class PostBean {
    private CommonParam commonParam;
    private Object object;

    public PostBean(CommonParam mCommonParam, Object mObject) {
        this.commonParam = mCommonParam;
        this.object = mObject;
    }
}
