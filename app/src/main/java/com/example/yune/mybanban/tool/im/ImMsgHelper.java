package com.example.yune.mybanban.tool.im;

import android.util.Log;

import com.example.yune.mybanban.tool.LogUtils;
import com.yuntongxun.ecsdk.ECChatManager;
import com.yuntongxun.ecsdk.ECDevice;
import com.yuntongxun.ecsdk.ECError;
import com.yuntongxun.ecsdk.ECMessage;
import com.yuntongxun.ecsdk.OnChatReceiveListener;
import com.yuntongxun.ecsdk.SdkErrorCode;
import com.yuntongxun.ecsdk.im.ECMessageNotify;
import com.yuntongxun.ecsdk.im.ECTextMessageBody;
import com.yuntongxun.ecsdk.im.group.ECGroupNoticeMessage;

import java.util.List;

/**
 * Created by Yune on 2016/11/17.
 */

public class ImMsgHelper implements ECChatManager.OnSendMessageListener, OnChatReceiveListener {
    private static ImMsgHelper msgHelper;
    private ECChatManager ecChatManager;

    private ImMsgHelper() {
        if (ecChatManager == null) {
            ecChatManager = ECDevice.getECChatManager();//IM聊天API接口
        }
    }

    public synchronized static ImMsgHelper getInstance() {
        if (msgHelper == null) {
            msgHelper = new ImMsgHelper();
        }
        return msgHelper;
    }

    public void sendImMessage(ECMessage message) throws Exception {
        if (message != null) {
            message.setMsgTime(System.currentTimeMillis());
            message.setDirection(ECMessage.Direction.SEND);//设置消息类型是发送还是接受，还是草稿
            message.setAnonymity(false);//设置是否是匿名聊天消息
            if (ecChatManager == null) {
                ecChatManager = ECDevice.getECChatManager();
            }
            ecChatManager.sendMessage(message, this);

        }
    }

    /**
     * 发送Im消息
     *
     * @param message
     * @param listener
     * @throws Exception
     */
    public void sendImMessage(ECMessage message, ECChatManager.OnSendMessageListener listener) throws Exception {
        if (message != null) {
            message.setMsgTime(System.currentTimeMillis());
            message.setDirection(ECMessage.Direction.SEND);//设置消息类型是发送还是接受，还是草稿
            message.setAnonymity(false);//设置是否是匿名聊天消息
            if (ecChatManager == null) {
                ecChatManager = ECDevice.getECChatManager();
            }
            ecChatManager.sendMessage(message, listener);

        }
    }

    public void sendVoiceMessage(ECMessage ecMessage) throws Exception {
        if (ecMessage != null) {
            ecMessage.setMsgTime(System.currentTimeMillis());
            ecMessage.setDirection(ECMessage.Direction.SEND);//设置消息类型是发送还是接受，还是草稿
            ecMessage.setAnonymity(false);//设置是否是匿名聊天消息
            ecChatManager.startVoiceRecording(ecMessage, new ECChatManager.OnRecordTimeoutListener() {
                @Override
                public void onRecordingTimeOut(long l) {
//                    ，SDK会根据当前录制的文件是否超过60s最大长度，超过则会回调该接口通知APP
                }

                @Override
                public void onRecordingAmplitude(double v) {
//                    当使用SDK录制IM语音消息接口时，SDK会通过该接口回调通知App 当前音量的振幅.
                }
            });

            ecChatManager.stopVoiceRecording(new ECChatManager.OnStopVoiceRecordingListener() {
                @Override
                public void onRecordingComplete() {

                }
            });
        }

    }


    @Override
    public void onSendMessageComplete(ECError ecError, ECMessage ecMessage) {
        if (ecError.errorCode == SdkErrorCode.REQUEST_SUCCESS && ecMessage != null) {
            //消息发送成功
            LogUtils.yu("消息应该成功了" + ecMessage.getMsgStatus().name());
        } else {
            LogUtils.yu("消息发送失败了：" + ecError.errorMsg);
        }
    }

    @Override
    public void onProgress(String s, int i, int i1) {

    }


    @Override
    public void OnReceivedMessage(ECMessage ecMessage) {
        //收到新消息
        Log.e("yujj", "ImMsgHelper收到新消息");
        if (ecMessage != null) {
            if (listener != null) {
                listener.onReceiveMsg(ecMessage);
            } else {
                ECMessage.Type type = ecMessage.getType();
                if (type == ECMessage.Type.TXT) {
                    //文字消息
                    ECTextMessageBody body = (ECTextMessageBody) ecMessage.getBody();
                    String message = body.getMessage();
                    LogUtils.yu("文字消息:" + message + "SessionId" + ecMessage.getSessionId() + "Form:" + ecMessage.getForm() + "TO:" + ecMessage.getTo() + "Status:" + ecMessage.getMsgStatus());
                }
            }
        }
    }

    @Override
    public void onReceiveMessageNotify(ECMessageNotify ecMessageNotify) {
        LogUtils.yu("收到新的消息命令通知" + ecMessageNotify.getNotifyType());
    }

    @Override
    public void OnReceiveGroupNoticeMessage(ECGroupNoticeMessage ecGroupNoticeMessage) {
        //收到群组通知消息,可以根据ECGroupNoticeMessage.ECGroupMessageType类型区分不同消息类型
        LogUtils.yu("SDK群组消息，=收到群组通知消息（有人加入、退出...）" + ecGroupNoticeMessage.getType());
    }

    @Override
    public void onOfflineMessageCount(int i) {
// 登陆成功之后SDK回调该接口通知帐号离线消息数
        LogUtils.yu("离线消息数" + i);
    }

    @Override
    public int onGetOfflineMessage() {
        return 0;
    }

    @Override
    public void onReceiveOfflineMessage(List<ECMessage> list) {
// SDK根据应用设置的离线消息拉取规则通知应用离线消息
        LogUtils.yu("离线消息集合大小:" + list.size());
    }

    @Override
    public void onReceiveOfflineMessageCompletion() {
        // SDK通知应用离线消息拉取完成
        LogUtils.yu("离线消息拉去完成");
    }

    @Override
    public void onServicePersonVersion(int i) {
        // SDK通知应用当前帐号的个人信息版本号
        LogUtils.yu("个人信息版本" + i);
    }

    @Override
    public void onReceiveDeskMessage(ECMessage ecMessage) {
        LogUtils.yu("客服消息" + ecMessage.getSessionId());
    }

    @Override
    public void onSoftVersion(String s, int i) {

    }

    public interface ReceiveMsgListener {
        void onReceiveMsg(ECMessage ecMessage);
    }

    private ReceiveMsgListener listener;

    public void setReceiveMsgListener(ReceiveMsgListener listener) {
        this.listener = listener;
    }

    /**
     * 移除所有监听
     */
    public void removeAllListener() {
        this.listener = null;
    }

}
