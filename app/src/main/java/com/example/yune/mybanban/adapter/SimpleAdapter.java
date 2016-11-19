package com.example.yune.mybanban.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Yune on 2016/11/13.
 */

public class SimpleAdapter<T> extends FragmentPagerAdapter {

    private List<String> titles;
    private List<T> data;

    public SimpleAdapter(FragmentManager fm, List<T> data, List<String> titles) {
        super(fm);
        this.data = data;
        this.titles = titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return (Fragment) data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
