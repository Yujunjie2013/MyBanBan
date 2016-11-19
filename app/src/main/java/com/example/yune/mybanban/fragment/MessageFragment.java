package com.example.yune.mybanban.fragment;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.example.yune.mybanban.R;
import com.example.yune.mybanban.base.BaseFragment;
import com.example.yune.mybanban.custom.PullLoadMoreRecyclerView;
import com.example.yune.mybanban.mvp.presenter.MessagePresenter;
import com.example.yune.mybanban.mvp.view.MessageView;
import com.example.yune.mybanban.tool.LogUtils;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者：Yune
 * 邮箱：yujunjie_qzq@163.com
 * 创建时间 2016/7/8 11:22
 */
public class MessageFragment extends BaseFragment<MessagePresenter> implements MessageView, PullLoadMoreRecyclerView.PullLoadMoreListener {

    private PullLoadMoreRecyclerView recyclerView;

    private boolean isInit;


    @Override
    protected MessagePresenter createPresenter() {
        return new MessagePresenter(this);
    }

    @Override
    public void initData() {
        isInit = true;
        Log.d("yujj", "初始化数据");
        Observable.timer(1500, TimeUnit.MILLISECONDS, Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                mPresenter.initData();
                recyclerView.setPullLoadMoreCompleted();
            }
        });

    }

    @Override
    public void registerListener() {

    }

    @Override
    public void initViews(View view) {
        recyclerView = (PullLoadMoreRecyclerView) view.findViewById(R.id.recycler_message);
        //这个默认设置的是锤直的，如果想让其水平滑动，则需要指定方向
//        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setLinearLayout();
//        //下面这个就是指定水平方向
//        //显示下拉刷新
        recyclerView.setRefreshing(true);
//        recyclerView.setEmptyView(View.inflate(mContext, R.layout.empty_view, null));
        recyclerView.setOnPullLoadMoreListener(this);
        //设置刷新监听
//        recyclerView.setOnPullLoadMoreListener(this);
//        设置线性布局
//        mPullLoadMoreRecyclerView.setLinearLayout();
//        设置网格布局
//        recyclerView.setGridLayout(2);//参数为列数
//        设置交错网格布局，即瀑布流效果
//        recyclerView.setStaggeredGridLayout(2);//参数为列数
//        刷新结束
//        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
//        不需要下拉刷新
//        mPullLoadMoreRecyclerView.setPullRefreshEnable(false);
//        不需要上拉刷新
//        mPullLoadMoreRecyclerView.setPushRefreshEnable(false);
//        设置上拉刷新文字
//        mPullLoadMoreRecyclerView.setFooterViewText("loading");
//        设置上拉刷新文字颜色
//        mPullLoadMoreRecyclerView.setFooterViewTextColor(R.color.white);
//        设置加载更多背景色
//        recyclerView.setFooterViewBackgroundColor(R.color.green);
//        设置下拉刷新颜色
//        mPullLoadMoreRecyclerView.setColorSchemeResources(android.R.color.holo_red_dark, android.R.color.holo_blue_dark);
//        快速Top
//        mPullLoadMoreRecyclerView.scrollToTop();

    }

    @Override
    public int getLagoutResId() {
        return R.layout.layout_message;
    }

    @Override
    protected void lazyLoad() {
        //因为懒加载会在OnCreateView方法之前调用的，所以要想进行一个是否已经初始化完成和是否可见的判断
        if (isInit && isVisible) {
            Log.e("yujj", "懒加载喔");
        }
        Log.d("yujj", "消息懒加载");
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public PullLoadMoreRecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    public Activity getmContext() {
        return getActivity();
    }


    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        LogUtils.yu("下拉刷新");
        Observable.timer(1500, TimeUnit.MILLISECONDS, Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                mPresenter.initData();
                recyclerView.setPullLoadMoreCompleted();
            }
        });
    }

    /**
     * 加载更多
     */
    @Override
    public void onLoadMore() {
        LogUtils.yu("加载更多");
        Observable.timer(1500, TimeUnit.MILLISECONDS, Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                mPresenter.removeData();
                recyclerView.showEmptyView();
                recyclerView.setPullLoadMoreCompleted();
            }
        });
    }
}
