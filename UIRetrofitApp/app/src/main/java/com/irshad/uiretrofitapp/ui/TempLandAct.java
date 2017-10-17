package com.irshad.uiretrofitapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.irshad.uiretrofitapp.MainActivity;
import com.irshad.uiretrofitapp.R;
import com.irshad.uiretrofitapp.SignInActivity;
import com.irshad.uiretrofitapp.SignUpActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class TempLandAct extends AppCompatActivity {
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_land);
        activity=TempLandAct.this;
        ButterKnife.bind(activity);

    }
    @OnClick(R.id.button0)
    public void firstpage(){
        Intent i1=new Intent(activity,MainActivity.class);
        startActivity(i1);
    }
    @OnClick(R.id.button1)
    public void noti(){
        Intent i1=new Intent(activity,NotificationActivity.class);
        startActivity(i1);
    }
    @OnClick(R.id.button2)
    public void signin(){
        Intent i2=new Intent(activity,SignInActivity.class);
        startActivity(i2);
    }

    @OnClick(R.id.button3)
    public void signup(){
        Intent i2=new Intent(activity,SignUpActivity.class);
        startActivity(i2);
    }

    @OnClick(R.id.button4)
    public void feedpolls(){
        Intent i2=new Intent(activity,FeedPollsAct.class);
        startActivity(i2);
    }
    @OnClick(R.id.button5)
    public void profile(){
        Intent i2=new Intent(activity,ProfileActivity.class);
        startActivity(i2);
    }
}
