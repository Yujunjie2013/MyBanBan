package com.example.yune.mybanban.adapter.im;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yune.mybanban.R;
import com.example.yune.mybanban.tool.LogUtils;
import com.yuntongxun.ecsdk.ECMessage;
import com.yuntongxun.ecsdk.im.ECTextMessageBody;

import java.util.List;

/**
 * Created by Yune on 2016/11/18.
 */

public class ImChatAdapter extends RecyclerView.Adapter {


    private Activity mActivity;
    private List<ECMessage> mDatas;

    private static final int SEND = 0;
    private static final int RECEIVE = 1;

    public ImChatAdapter(List<ECMessage> mDatas, Activity mActivity) {
        this.mDatas = mDatas;
        this.mActivity = mActivity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder imViewHolder = null;
        switch (viewType) {
            case SEND:
                LogUtils.yu("============" + SEND);
                imViewHolder = new SendViewHolder(mActivity.getLayoutInflater().inflate(R.layout.send_item, parent, false));
                break;
            case RECEIVE:
                LogUtils.yu("============" + RECEIVE);
                imViewHolder = new ReceiveViewHolder(mActivity.getLayoutInflater().inflate(R.layout.receive_item, parent, false));
                break;
        }
        return imViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ECMessage ecMessage = mDatas.get(position);
        if (holder instanceof SendViewHolder) {
            ECTextMessageBody textMessageBody = (ECTextMessageBody) ecMessage.getBody();
            ((SendViewHolder) holder).tv_text.setText(textMessageBody.getMessage());
            LogUtils.yu("发" + ecMessage.getBody().toString());
        } else if (holder instanceof ReceiveViewHolder) {
            ECTextMessageBody textMessageBody = (ECTextMessageBody) ecMessage.getBody();
            ((ReceiveViewHolder) holder).tv_text.setText(textMessageBody.getMessage());
            LogUtils.yu("收" + ecMessage.getBody().toString());
        }
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
        ECMessage ecMessage = mDatas.get(position);
        if (ECMessage.Direction.SEND == ecMessage.getDirection()) {
            //我发送的
            LogUtils.yu("我发送的");
            return SEND;
        } else if (ECMessage.Direction.RECEIVE == ecMessage.getDirection()) {
            //我收到的
            LogUtils.yu("我收到的");
            return RECEIVE;
        } else {
            return super.getItemViewType(position);
        }
    }

    static class SendViewHolder extends RecyclerView.ViewHolder {
        public View item;
        public TextView tv_text;

        public SendViewHolder(View itemView) {
            super(itemView);
            item = itemView;
            tv_text = (TextView) itemView.findViewById(R.id.im_tv_chat_send_item);
        }
    }

    static class ReceiveViewHolder extends RecyclerView.ViewHolder {

        public View item;
        public TextView tv_text;

        public ReceiveViewHolder(View itemView) {
            super(itemView);
            item = itemView;
            tv_text = (TextView) itemView.findViewById(R.id.im_tv_receive_item);
        }
    }
}
