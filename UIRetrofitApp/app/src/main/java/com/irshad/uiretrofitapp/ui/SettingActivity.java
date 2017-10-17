package com.irshad.uiretrofitapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;


import com.irshad.uiretrofitapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity {
Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        activity=SettingActivity.this;
        ButterKnife.bind(activity);
    }

    @OnClick(R.id.edit_layout)
    void  editProfile(){
        Intent gotoedit=new Intent(activity,EditProfile.class);
        startActivity(gotoedit);
    }
    @OnClick(R.id.changedPwdlay)
    void  changePwd(){
        Intent gotoedit=new Intent(activity,ChangePasswordAct.class);
        startActivity(gotoedit);
    }
}
