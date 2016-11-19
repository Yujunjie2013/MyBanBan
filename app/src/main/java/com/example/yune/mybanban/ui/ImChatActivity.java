package com.example.yune.mybanban.ui;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yune.mybanban.R;
import com.example.yune.mybanban.adapter.im.ImChatAdapter;
import com.example.yune.mybanban.base.BaseActivity;
import com.example.yune.mybanban.mvp.presenter.ImChatPresenter;
import com.example.yune.mybanban.mvp.view.ImChatView;
import com.example.yune.mybanban.tool.im.ImMsgHelper;
import com.yuntongxun.ecsdk.ECMessage;

import java.util.ArrayList;
import java.util.List;

public class ImChatActivity extends BaseActivity<ImChatPresenter> implements ImChatView, View.OnClickListener, ImMsgHelper.ReceiveMsgListener {

    private EditText im_chat_et_input;
    private ImageView im_chat_iv_emojion;
    private TextView im_chat_tv_send;
    private LinearLayout im_chat_bottom;
    private RecyclerView imchat_pull_recycler_view;
    private RelativeLayout activity_im_chat;
    private ImChatAdapter adapter;
    private List<ECMessage> mDatas;

    @Override
    protected ImChatPresenter createPresenter() {
        return new ImChatPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_im_chat;
    }

    @Override
    protected void initView() {
        im_chat_et_input = (EditText) findViewById(R.id.im_chat_et_input);
        im_chat_iv_emojion = (ImageView) findViewById(R.id.im_chat_iv_emojion);
        im_chat_tv_send = (TextView) findViewById(R.id.im_chat_tv_send);
        im_chat_bottom = (LinearLayout) findViewById(R.id.im_chat_bottom);
        imchat_pull_recycler_view = (RecyclerView) findViewById(R.id.imchat_pull_recycler_view);
        activity_im_chat = (RelativeLayout) findViewById(R.id.activity_im_chat);
        im_chat_tv_send.setOnClickListener(this);
        im_chat_iv_emojion.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        imchat_pull_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        mDatas = new ArrayList<>();
        ImMsgHelper.getInstance().setReceiveMsgListener(this);
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
            case R.id.im_chat_tv_send:
                //发送消息
                String msg = im_chat_et_input.getText().toString().trim();
                mPresenter.sendTextMsg(msg);
                break;
            case R.id.im_chat_iv_emojion:
                //表情
                break;

        }
    }

    @Override
    public Activity getmActivity() {
        return this;
    }

    @Override
    public RecyclerView getmRecyclerView() {
        return imchat_pull_recycler_view;
    }

    @Override
    public void sendImSuccess(ECMessage ecMessage) {
        mDatas.add(ecMessage);
        refresh();
    }

    private void refresh() {
        if (adapter == null) {
            adapter = new ImChatAdapter(mDatas, this);
            imchat_pull_recycler_view.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void sendImFaild(ECMessage ecMessage) {

    }

    @Override
    public void onReceiveMsg(ECMessage ecMessage) {
        //接收到消息
        mDatas.add(ecMessage);
        refresh();
    }
}
