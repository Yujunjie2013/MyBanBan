package com.example.yune.mybanban.receiver;

import android.content.Context;

import com.yuntongxun.ecsdk.ECMessage;
import com.yuntongxun.ecsdk.booter.ECNotifyReceiver;
import com.yuntongxun.ecsdk.im.group.ECGroupNoticeMessage;

/**
 * Created by Yune on 2016/11/16.
 */

public class ImNotifyReceiver extends ECNotifyReceiver {
    @Override
    public void onReceivedMessage(Context context, ECMessage ecMessage) {

    }

    @Override
    public void onReceiveGroupNoticeMessage(Context context, ECGroupNoticeMessage ecGroupNoticeMessage) {

    }

    @Override
    public void onNotificationClicked(Context context, int i, String s) {

    }
}
