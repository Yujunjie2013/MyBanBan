package com.example.yune.mybanban.tool.im;

import android.util.Log;

import com.example.yune.mybanban.App;
import com.example.yune.mybanban.R;
import com.example.yune.mybanban.tool.LogUtils;
import com.yuntongxun.ecsdk.ECDevice;
import com.yuntongxun.ecsdk.ECError;
import com.yuntongxun.ecsdk.ECInitParams;
import com.yuntongxun.ecsdk.ECNotifyOptions;
import com.yuntongxun.ecsdk.SdkErrorCode;

/**
 * Created by Yune on 2016/11/16.
 */

public class SDKHelper implements ECDevice.OnECDeviceConnectListener, ECDevice.InitListener, ECDevice.OnLogoutListener {
    private static SDKHelper mHelper;
    private ECNotifyOptions mOptions;
    private String userId;

    private SDKHelper() {
        initNotifyOptions();
    }

    public static synchronized SDKHelper getInstall() {
        if (mHelper == null) {
            synchronized (SDKHelper.class) {
                mHelper = new SDKHelper();
            }
        }
        return mHelper;
    }

    /**
     * SDK进行初始化
     */
    public void init(String userId) {
        this.userId = userId;
        //判断SDK是否已经初始化
        if (!ECDevice.isInitialized()) {
            /*  initial: ECSDK 初始化接口
            * 参数：
            *     inContext - Android应用上下文对象
            *     inListener - SDK初始化结果回调接口，ECDevice.InitListener
            *
            * 说明：示例在应用程序创建时初始化 SDK引用的是Application的上下文，
            *       开发者可根据开发需要调整。
            */
            ECDevice.initial(App.getInstance(), getInstall());
        } else {
            // 已经初始化成功，后续开发业务代码。
            LogUtils.yu("初始化SDK及登陆代码完成");
            // 已经初始化成功，直接进行注册
            getInstall().onInitialized();
        }
    }

    public void login(String userId) {
        ECInitParams params = ECInitParams.createParams();
        params.setUserid(userId);
        params.setAppKey("8aaf07085610bc7f01561c59c892069d");
        params.setToken("db931028d7fc22371d8067191fab927a");
        //设置登陆验证模式：自定义登录方式
        params.setAuthType(ECInitParams.LoginAuthType.NORMAL_AUTH);
        //LoginMode（强制上线：FORCE_LOGIN  默认登录：AUTO。使用方式详见注意事项）
        params.setMode(ECInitParams.LoginMode.FORCE_LOGIN);
        if (!params.validate()) {
            return;
        }

        ECDevice.login(params);
    }

    private void initNotifyOptions() {
        if (mOptions == null) {
            mOptions = new ECNotifyOptions();
        }
        // 设置新消息是否提醒
        mOptions.setNewMsgNotify(true);
        // 设置状态栏通知图标
        mOptions.setIcon(R.mipmap.ic_launcher);
        // 设置是否启用勿扰模式（不会声音/震动提醒）
        mOptions.setSilenceEnable(false);
        // 设置勿扰模式时间段（开始小时/开始分钟-结束小时/结束分钟）
        // 小时采用24小时制
        // 如果设置勿扰模式不启用，则设置勿扰时间段无效
        // 当前设置晚上11点到第二天早上8点之间不提醒
//        mOptions.setSilenceTime(23, 0, 8, 0);
        // 设置是否震动提醒(如果处于免打扰模式则设置无效，没有震动)
        mOptions.enableShake(true);
        // 设置是否声音提醒(如果处于免打扰模式则设置无效，没有声音)
        mOptions.enableSound(true);
    }

    @Override
    public void onConnect() {

    }

    @Override
    public void onDisconnect(ECError ecError) {

    }

    @Override
    public void onConnectState(ECDevice.ECConnectState state, ECError error) {
        if (state == ECDevice.ECConnectState.CONNECT_FAILED) {
            if (error.errorCode == SdkErrorCode.SDK_KICKED_OFF) {
                LogUtils.yu("==帐号异地登陆");
            } else {
                LogUtils.yu("==其他登录失败,错误码：" + error.errorCode);
            }
            return;
        } else if (state == ECDevice.ECConnectState.CONNECT_SUCCESS) {
            LogUtils.yu("==登陆成功");
        }
    }

    @Override
    public void onInitialized() {
        // SDK已经初始化成功
        LogUtils.yu("初始化SDK成功");
        //设置登录参数，可分为自定义方式和通讯账号验密方式，详情点此查看>>
        //设置通知回调监听包含登录状态监听，接收消息监听，呼叫事件回调监听和
        //设置接收来电事件通知Intent等，详情点此查看>>
        //验证参数是否正确，登陆SDK，详情点此查看>>
        ECDevice.setNotifyOptions(mOptions);

        //IM接收消息监听，使用IM功能的开发者需要设置。
        ECDevice.setOnChatReceiveListener(ImMsgHelper.getInstance());
        // 当网络断开导致SDK断开连接或者重连成功也会通过该设置回调
        ECDevice.setOnDeviceConnectListener(SDKHelper.getInstall());
        login(userId);
    }

    @Override
    public void onError(Exception e) {
        //在初始化错误的方法中打印错误原因
        LogUtils.yu("初始化SDK失败" + e.getMessage());
    }

    /**
     * 登出
     *
     * @param isNotice 传true则表示登出后接受通知，否则表示不接受
     */
    public static void logout(boolean isNotice) {
        //退出登录后是否接受消息提醒
        // IN_NOTIFY  SDK退出登录接受消息提醒
        // NOT_NOTIFY SDK退出登录不接受消息提醒
        ECDevice.NotifyMode notifyMode = (isNotice) ? ECDevice.NotifyMode.IN_NOTIFY : ECDevice.NotifyMode.NOT_NOTIFY;
        ECDevice.logout(notifyMode, getInstall());
    }

    @Override
    public void onLogout() {
        //通知sdK处于离线状态
        Log.e("yujj", "SDK处于离线状态");
    }
}
