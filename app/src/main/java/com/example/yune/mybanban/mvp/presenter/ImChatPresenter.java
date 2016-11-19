package com.example.yune.mybanban.mvp.presenter;

import com.example.yune.mybanban.R;
import com.example.yune.mybanban.base.BasePresenter;
import com.example.yune.mybanban.mvp.view.ImChatView;
import com.example.yune.mybanban.tool.im.ImMsgHelper;
import com.example.yune.mybanban.ui.ToastUtils;
import com.yuntongxun.ecsdk.ECChatManager;
import com.yuntongxun.ecsdk.ECError;
import com.yuntongxun.ecsdk.ECMessage;
import com.yuntongxun.ecsdk.SdkErrorCode;
import com.yuntongxun.ecsdk.im.ECTextMessageBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yune on 2016/11/17.
 */

public class ImChatPresenter extends BasePresenter<ImChatView> {

    private List<ECMessage> datas;

    public ImChatPresenter(ImChatView imChatView) {
        addachView(imChatView);
        datas = new ArrayList<>();
    }

    /**
     * 查询数据
     */
    public List<ECMessage> queryData() {
        if (datas == null) {
            datas = new ArrayList<>();
        }
        return datas;
    }

    public void sendTextMsg(String msg) {
        ECMessage ecMessage = ECMessage.createECMessage(ECMessage.Type.TXT);
        ecMessage.setTo("18888888888");
        ECTextMessageBody messageBody = new ECTextMessageBody(msg);
        ecMessage.setBody(messageBody);
        try {
            ImMsgHelper.getInstance().sendImMessage(ecMessage);
            ImMsgHelper.getInstance().sendImMessage(ecMessage, new ECChatManager.OnSendMessageListener() {
                @Override
                public void onSendMessageComplete(ECError ecError, ECMessage ecMessage) {
                    if (ecError.errorCode == SdkErrorCode.REQUEST_SUCCESS) {
                        //发送成功
                        mView.sendImSuccess(ecMessage);
                    } else {
                        //发送失败
                        mView.sendImFaild(ecMessage);
                    }
                }

                @Override
                public void onProgress(String s, int i, int i1) {

                }
            });
//            ToastUtils.showSuccess(mView.getmActivity(), R.string.success);
//            ToastUtils.show(mView.getmActivity(), "成功了", Toast.LENGTH_SHORT);
        } catch (Exception e) {
            ToastUtils.showFailure(mView.getmActivity(), R.string.failed);
            e.printStackTrace();
        }
    }
}
