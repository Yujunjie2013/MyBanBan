package com.example.yune.mybanban;

import android.app.Application;

/**
 * Created by Yune on 2016/11/10.
 */

public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }
    //TODO
    public static App getInstance() {
        return instance;
    }

}
