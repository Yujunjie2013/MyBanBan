package com.example.yune.mybanban.mvp.view;

import android.app.Activity;

import com.example.yune.mybanban.base.BaseView;
import com.example.yune.mybanban.custom.PullLoadMoreRecyclerView;

/**
 * Created by Yune on 2016/11/14.
 */

public interface MessageView extends BaseView {

    PullLoadMoreRecyclerView getRecyclerView();

    Activity getmContext();
}
