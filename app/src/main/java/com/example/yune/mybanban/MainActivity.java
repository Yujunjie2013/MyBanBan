package com.example.yune.mybanban;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.yune.mybanban.base.BaseActivity;
import com.example.yune.mybanban.mvp.model.BaseModel;
import com.example.yune.mybanban.mvp.presenter.MainPresenter;
import com.example.yune.mybanban.mvp.view.MainView;
import com.example.yune.mybanban.tool.LogUtils;
import com.example.yune.mybanban.tool.im.SDKHelper;
import com.example.yune.mybanban.ui.BottomNavigationActivity;
import com.example.yune.mybanban.ui.ImChatActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView, View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private TabLayout tab_layout;
    private ViewPager view_pager;
    private FloatingActionButton floating_button;
    private AppBarLayout appBarLayout;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private NavigationView navigationView1;


    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_drawlayout;
    }

    @Override
    protected void initView() {
        navigationView1 = (NavigationView) findViewById(R.id.navigation_view);
        appBarLayout = (AppBarLayout) findViewById(R.id.Appbar_layout);
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        floating_button = (FloatingActionButton) findViewById(R.id.floating_button);
        tab_layout.setupWithViewPager(view_pager);
        tab_layout.setTabMode(TabLayout.MODE_FIXED);
        initDrawerLayout();
        Toolbar viewById = (Toolbar) findViewById(R.id.toolbar);
        viewById.setTitle(getString(R.string.main_title));
        floating_button.setOnClickListener(this);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView1.setNavigationItemSelectedListener(this);

    }

    @Override
    protected void initData() {
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.title));
        mPresenter.createFragment();
        mPresenter.setAdapter();
    }

    @Override
    public void getDataSuccess(BaseModel data) {
        LogUtils.yu(data.getMessage());
    }

    @Override
    public void getDataFail(String msg) {
        LogUtils.yu(msg);
    }

    @Override
    public ViewPager getViewPager() {
        return view_pager;
    }


    @Override
    public FragmentManager getManager() {
        return getSupportFragmentManager();
    }


    @Override
    public void showProgress() {
        showProgressDialog();
    }

    @Override
    public void hideProgress() {
        hideProgressDialog();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.floating_button:
                SDKHelper.getInstall().init("13526880238");
                //震动
//                VibratorUtil.Vibrate(this, new long[]{800, 300, 800, 400, 800, 400, 800, 800, 800, 800, 800, 800}, true);
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawers();
        switch (item.getItemId()) {
            case R.id.nav_news:
                startActivity(new Intent(this, ImChatActivity.class));
                break;
            case R.id.nav_photo:
                startActivity(new Intent(this,BottomNavigationActivity.class));
                break;
            case R.id.nav_video:

                break;
            case R.id.nav_night_mode:

                break;
        }
        return false;
    }
}
