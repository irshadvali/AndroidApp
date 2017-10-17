package com.irshad.uiretrofitapp.adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.irshad.uiretrofitapp.R;
import com.irshad.uiretrofitapp.model.NotificationModel;


/**
 * Created by irshadvali on 27/11/16.
 */

public class NotificationAdapter extends RecyclerView.Adapter <NotificationAdapter.MyViewHolder>{
    Activity activity;
    NotificationModel notificationModel;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView username, comments, datetxt,liketext;
        CardView cardview;

        public MyViewHolder(View view) {
            super(view);
            username = (TextView) view.findViewById(R.id.username);
            comments = (TextView) view.findViewById(R.id.comments);
            datetxt = (TextView) view.findViewById(R.id.dt);
            liketext = (TextView) view.findViewById(R.id.textView3);


        }
    }
    public NotificationAdapter(Activity activity, NotificationModel notificationModel) {
        this.activity=activity;
        this.notificationModel=notificationModel;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_items, parent, false);
        return new NotificationAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NotificationModel.Result res=notificationModel.getResults().get(position);
        holder.username.setText(res.getUsername());
        holder.comments.setText(res.getCommenttxt());
        holder.datetxt.setText(res.getUpdate());

    }

    @Override
    public int getItemCount() {
        return notificationModel.getResults().size();
    }
}
