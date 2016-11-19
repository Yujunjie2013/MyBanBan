package com.example.yune.mybanban.fragment;

import android.util.Log;
import android.view.View;

import com.example.yune.mybanban.R;
import com.example.yune.mybanban.base.BaseFragment;
import com.example.yune.mybanban.base.BasePresenter;

//import com.xys.libzxing.zxing.activity.CaptureActivity;

/**
 * 作者：Yune
 * 邮箱：yujunjie_qzq@163.com
 * 创建时间 2016/7/8 11:25
 */
public class AppFragment extends BaseFragment {
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
        return R.layout.layout_app;
    }

    @Override
    protected void lazyLoad() {
        Log.d("yujj", "应用懒加载");
    }
}
