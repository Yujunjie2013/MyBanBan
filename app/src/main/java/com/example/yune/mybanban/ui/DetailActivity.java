package com.example.yune.mybanban.ui;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.yune.mybanban.R;
import com.example.yune.mybanban.base.BaseActivity;
import com.example.yune.mybanban.base.BasePresenter;
import com.example.yune.mybanban.tool.AppConstants;

public class DetailActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private AppBarLayout appbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private FloatingActionButton actionButton;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        actionButton = (FloatingActionButton) findViewById(R.id.actionButton);
        ImageView imageView = (ImageView) findViewById(R.id.back_image);
        initToolBar(toolbar).setDisplayHomeAsUpEnabled(true);
        //过渡动画，这个页面在TestAapter中使用的ActivityOptionCompat开启的一个动画，过渡的控件是这个ImageView
        ViewCompat.setTransitionName(imageView, AppConstants.TRANSITION_PIC);//一定要加这一句，否则没有动画效果
        actionButton.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.actionButton:
                Snackbar.make(actionButton, getString(R.string.msg), Snackbar.LENGTH_SHORT).show();
                break;
        }
    }
}
