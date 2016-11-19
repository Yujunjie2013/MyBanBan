package com.example.yune.mybanban.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yune.mybanban.R;
import com.example.yune.mybanban.tool.AppConstants;
import com.example.yune.mybanban.ui.DetailActivity;
import com.example.yune.mybanban.ui.VibratorUtil;

import java.util.List;

/**
 * Created by Yune on 2016/11/13.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.MyViewHolder> {

    private final Activity context;
    private List<String> datas;

    public TestAdapter(Activity context, List<String> datas) {
        this.context = context;
        this.datas = datas;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.test_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv.setText(datas.get(position));
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VibratorUtil.cancle();
                Toast.makeText(context, "点击了" + datas.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailActivity.class);
//                ActivityOptionsCompat optionsCompat1 = ActivityOptionsCompat.makeScaleUpAnimation(holder.showImage, 0, 0, holder.showImage.getMeasuredWidth()/2, holder.showImage.getMeasuredHeight()/2);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(context, holder.showImage, AppConstants.TRANSITION_PIC);
                ActivityCompat.startActivity(context, intent, optionsCompat.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv;
        public View view;
        public ImageView showImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tv = (TextView) itemView.findViewById(R.id.test_tv);
            showImage = (ImageView) itemView.findViewById(R.id.showImage);
        }
    }
}
