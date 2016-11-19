package com.example.yune.mybanban.fragment;

import android.util.Log;
import android.view.View;

import com.example.yune.mybanban.R;
import com.example.yune.mybanban.base.BaseFragment;
import com.example.yune.mybanban.base.BasePresenter;


/**
 * 作者：Yune
 * 邮箱：yujunjie_qzq@163.com
 * 创建时间 2016/7/8 11:25
 */
public class OfficeFragment extends BaseFragment {
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void initData() {

    }

    @Override
    public void registerListener() {

    }

    @Override
    public void initViews(View view) {

    }

    @Override
    public int getLagoutResId() {
        return R.layout.layout_office;
    }

    @Override
    protected void lazyLoad() {
        Log.d("yujj", "会议懒加载");
    }
}
