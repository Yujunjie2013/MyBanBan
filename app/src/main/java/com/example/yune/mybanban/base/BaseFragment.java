package com.example.yune.mybanban.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * fragment框架的基类
 *
 * @author Yune
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    protected Context mContext;

    protected abstract P createPresenter();

    public P mPresenter;

    /**
     * 当前页面是否可见
     */
    protected boolean isVisible;

    private View mFragmentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mPresenter = createPresenter();
        mContext = getContext();
        //加这个判断可以有效防止每次都走initViews和InitData方法，
        if (mFragmentView == null) {
            mFragmentView = inflater.inflate(getLagoutResId(), container, false);
            // 初始化布局界面
            initViews(mFragmentView);
            // 初始化数据
            initData();
            // 注册监听
            registerListener();
        }
        return mFragmentView;
    }

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 注册监听
     */
    public abstract void registerListener();

    /**
     * 初始化布局界面
     *
     * @param view fragment关联的布局文件
     */
    public abstract void initViews(View view);

    /**
     * 要关联的布局文件
     *
     * @return
     */
    public abstract int getLagoutResId();


    //    setUserVisibleHint是在onCreateView之前调用的，那么在视图未初始化的时候，
    // 在lazyLoad当中就使用的话，就会有空指针的异常,所以子类应该加一个标志，如果已经初始化完成，且isVisible为true
    //则手动调用lazyLoad()方法
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible() {
        lazyLoad();
    }

    /**
     * 懒加载，可见时加载数据
     */
    protected abstract void lazyLoad();

    protected void onInvisible() {
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }
}
