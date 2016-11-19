package com.example.yune.mybanban.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.yune.mybanban.R;
import com.example.yune.mybanban.base.BaseFragment;
import com.example.yune.mybanban.tool.FragmentFactory;
import com.example.yune.mybanban.tool.LogUtils;

public class BottomNavigationActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar bottom_navigation;
    private BadgeItem numberBadgeItem;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        initView();
        initData();

    }

    private void initData() {
        BaseFragment fragment1 = FragmentFactory.createFragment(1);
        BaseFragment fragment2 = FragmentFactory.createFragment(2);
        BaseFragment fragment3 = FragmentFactory.createFragment(3);
        BaseFragment fragment4 = FragmentFactory.createFragment(4);
//        bottom_navigation.
    }

    private void initView() {
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        numberBadgeItem = new BadgeItem()
                .setBorderWidth(4)
                .setBackgroundColorResource(R.color.red)
                .setText("5")
                .setHideOnSelect(true);
        bottom_navigation = (BottomNavigationBar) findViewById(R.id.bottom_navigation);
        bottom_navigation.setMode(BottomNavigationBar.MODE_FIXED);
        BottomNavigationItem bottomNavigationItem = new BottomNavigationItem(R.mipmap.bottom_app, R.string.bottom_app).setActiveColorResource(R.color.blue).setBadgeItem(numberBadgeItem);//
        bottomNavigationItem.setInactiveIconResource(R.mipmap.bottom_appg);//没有点击的时候图片
        bottomNavigationItem.setInActiveColorResource(R.color.red);//没有点击的时候字体的颜色

        bottom_navigation.addItem(bottomNavigationItem);
        bottom_navigation.addItem(new BottomNavigationItem(R.mipmap.bottom_msg, R.string.bottom_msg).setActiveColorResource(R.color.warn).setInactiveIconResource(R.mipmap.bottom_msgg));
        bottom_navigation.addItem(new BottomNavigationItem(R.mipmap.bottom_news, R.string.bottom_news).setActiveColorResource(R.color.green).setInactiveIconResource(R.mipmap.bottom_newsg));
        bottom_navigation.addItem(new BottomNavigationItem(R.mipmap.bottom_video, R.string.bottom_video).setActiveColorResource(R.color.colorAccent).setInactiveIconResource(R.mipmap.bottom_videog));
        bottom_navigation.initialise();
        bottom_navigation.setTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(int position) {

        if (position == 0) {
//            numberBadgeItem.setText("4");
//            numberBadgeItem.hide(false);
//            numberBadgeItem.setText("");
        } else if (position == 3) {

        }
        LogUtils.yu("onTabSelected" + position);
    }

    @Override
    public void onTabUnselected(int position) {
        numberBadgeItem.setText("");
        numberBadgeItem.hide();
        LogUtils.yu("onTabUnselected" + position);
    }

    @Override
    public void onTabReselected(int position) {
        LogUtils.yu("onTabReselected" + position);
    }
}
