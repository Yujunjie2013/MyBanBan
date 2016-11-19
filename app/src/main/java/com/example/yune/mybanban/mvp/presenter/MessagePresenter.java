package com.example.yune.mybanban.mvp.presenter;

import com.example.yune.mybanban.adapter.TestAdapter;
import com.example.yune.mybanban.base.BasePresenter;
import com.example.yune.mybanban.mvp.view.MessageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yune on 2016/11/14.
 */

public class MessagePresenter extends BasePresenter<MessageView> {

    private TestAdapter adapter;
    private List<String> datas;

    public MessagePresenter(MessageView mv) {
        addachView(mv);
    }

    public void initData() {
        if (datas == null) {
            datas = new ArrayList<>();
            for (int i = 'a'; i < 'c'; i++) {
                datas.add("当前是:" + i);
            }
        } else {
            for (int i = 'A'; i < 'Z'; i++) {
                datas.add("大写:" + i);
            }
        }
        if (adapter == null) {
            adapter = new TestAdapter(mView.getmContext(), datas);
            mView.getRecyclerView().setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    public void removeData() {
        if (datas != null) {
            datas.clear();
            if (adapter == null) {
                adapter = new TestAdapter(mView.getmContext(), datas);
                mView.getRecyclerView().setAdapter(adapter);
            } else {
                adapter.notifyDataSetChanged();
            }
        }
    }
}

