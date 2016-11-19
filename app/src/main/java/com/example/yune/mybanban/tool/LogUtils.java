package com.example.yune.mybanban.tool;

import android.util.Log;

/**
 * Created by Yune on 2016/11/11.
 */

public class LogUtils {

    private static String TAG = "yujj";
    private static boolean Debug = true;

    public static void yu(String msg) {
        if (Debug)
            Log.d(TAG, msg);
    }
}
