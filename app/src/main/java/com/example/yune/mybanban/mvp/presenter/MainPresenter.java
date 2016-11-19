package com.example.yune.mybanban.mvp.presenter;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.example.yune.mybanban.adapter.SimpleAdapter;
import com.example.yune.mybanban.base.BaseFragment;
import com.example.yune.mybanban.base.BasePresenter;
import com.example.yune.mybanban.mvp.view.MainView;
import com.example.yune.mybanban.tool.FragmentFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yune on 2016/11/11.
 */

public class MainPresenter extends BasePresenter<MainView> {


    private List<BaseFragment> fragments;
    private List<String> titles;

    public MainPresenter(MainView mainView) {
        addachView(mainView);
    }


    public void createFragment() {
        if (fragments == null || titles == null) {
            fragments = new ArrayList<>();
            titles = new ArrayList<>();
        }
        titles.clear();
        fragments.clear();
        for (int i = 0; i < 5; i++) {
            fragments.add(FragmentFactory.createFragment(i));
        }
        titles.add("消息");
        titles.add("组织");
        titles.add("应用");
        titles.add("考勤");
        titles.add("办公");

    }

    public void setAdapter() {
        FragmentManager manager = mView.getManager();
        ViewPager viewPager = mView.getViewPager();
        SimpleAdapter adapter = new SimpleAdapter(manager, fragments, titles);
        viewPager.setAdapter(adapter);

    }

    public void Vibrator(){

    }


}
