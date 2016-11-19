package com.example.yune.mybanban.mvp.view;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import com.example.yune.mybanban.base.BaseView;
import com.yuntongxun.ecsdk.ECMessage;

/**
 * Created by Yune on 2016/11/17.
 */

public interface ImChatView extends BaseView {
    Activity getmActivity();

    RecyclerView getmRecyclerView();

    void sendImSuccess(ECMessage ecMessage);

    void sendImFaild(ECMessage ecMessage);
}
