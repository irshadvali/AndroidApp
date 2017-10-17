package com.irshad.uiretrofitapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.irshad.uiretrofitapp.PrintO;
import com.irshad.uiretrofitapp.R;
import com.irshad.uiretrofitapp.adapter.NotificationAdapter;
import com.irshad.uiretrofitapp.apiservices.HttpRef;
import com.irshad.uiretrofitapp.fragments.BottomBar;
import com.irshad.uiretrofitapp.model.NotificationModel;


import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationActivity extends AppCompatActivity implements Callback<NotificationModel> {
    Activity activity;
    @Bind(R.id.rv_notification)
    RecyclerView rv_notification;
    RecyclerView.LayoutManager mLayoutManager;
    NotificationAdapter notificationAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        activity=NotificationActivity.this;
        ButterKnife.bind(activity);
        FacebookSdk.sdkInitialize(activity);
        callApi();
        mLayoutManager = new LinearLayoutManager(activity);
        rv_notification.setLayoutManager(mLayoutManager);
        setBottom();
    }
public void callApi(){
    Call<NotificationModel> call= HttpRef.createService().getNotification();
    call.enqueue(this);
}
    @Override
    public void onResponse(Call<NotificationModel> call, Response<NotificationModel> response) {
        try {
            if (response.body().getError().getErrCode() == 0) {
                PrintO.log("Notify Contact" + response.body().getResults().get(0).getCommenttxt());
                notificationAdapter = new NotificationAdapter(activity,response.body());
                rv_notification.setAdapter(notificationAdapter);


            } else {
                Toast.makeText(activity, response.body().getError().getErrMsg(), Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            System.out.println("Exception:===="+e.getLocalizedMessage());
            e.getLocalizedMessage();
        }

    }

    @Override
    public void onFailure(Call<NotificationModel> call, Throwable t) {
        System.out.println("Fail"+t.getLocalizedMessage());

    }
    public void setBottom(){
        BottomBar bottomBar = new BottomBar();
        getSupportFragmentManager().beginTransaction().add(R.id.bottombar, bottomBar).commit();
    }
//    https://api.myjson.com/bins/vr5b
}
