package com.irshad.uiretrofitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.irshad.uiretrofitapp.ui.FeedPollsAct;
import com.irshad.uiretrofitapp.ui.ForgotPassword;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends AppCompatActivity {
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_new);
        ButterKnife.bind(this);
        activity = SignInActivity.this;

    }

    @OnClick(R.id.singInRegBtn)
    public void signInRegsiterClick(){
        startActivity(new Intent(activity,FeedPollsAct.class));
    }

    @OnClick(R.id.signInFbBtn)
    public void signInFbClick(){
        startActivity(new Intent(activity,FeedPollsAct.class));
    }

    @OnClick(R.id.signInGoBtn)
    public void signInGoogleClick(){
        startActivity(new Intent(activity,FeedPollsAct.class));
    }

    @OnClick(R.id.signInForgotBtn)
    public void forgotPasswordClick(){
        startActivity(new Intent(activity,ForgotPassword.class));
    }

    @OnClick(R.id.signInBackBtn)
    public void backButtonClick(){
        finish();
    }
}
