package com.irshad.uiretrofitapp.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;


import com.irshad.uiretrofitapp.R;
import com.irshad.uiretrofitapp.SignInActivity;
import com.irshad.uiretrofitapp.SignUpActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LandingPageActivity extends AppCompatActivity {

    private Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_screen);
        activity = LandingPageActivity.this;
        ButterKnife.bind(activity);
    }

    @OnClick(R.id.loginSignUpBtn)
    public void singUpFunc(){
        startActivity(new Intent(activity, SignUpActivity.class));
    }

    @OnClick(R.id.loginSignInBtn)
    public void singInFunc(){
        startActivity(new Intent(activity, SignInActivity.class));
    }

    @OnClick(R.id.loginGoogleSingInBtn)
    public void googleSignInBtnClick(){
        startActivity(new Intent(activity, SignUpActivity.class));
    }

    @OnClick(R.id.loginFacebookSingInBtn)
    public void facebookSignInBtnClick(){
        startActivity(new Intent(activity, SignUpActivity.class));
    }
}
