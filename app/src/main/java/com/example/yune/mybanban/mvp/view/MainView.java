package com.example.yune.mybanban.mvp.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.example.yune.mybanban.base.BaseView;
import com.example.yune.mybanban.mvp.model.BaseModel;

/**
 * Created by Yune on 2016/11/11.
 */

public interface MainView extends BaseView {
    void getDataSuccess(BaseModel data);

    void getDataFail(String msg);

    ViewPager getViewPager();

    FragmentManager getManager();
}
