package com.irshad.uiretrofitapp.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.irshad.uiretrofitapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotPassword extends AppCompatActivity {

    Activity activity;
    @Bind(R.id.emailEt)
    EditText emailBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
        activity = ForgotPassword.this;
    }

    @OnClick(R.id.sendPassBtn)
    void sendPwdValidate(){
        if (emailBox.getText().toString().trim().length() > 0){
            openDialog();
        }
        else {
            emailBox.setError("Please enter valid email!");
        }
    }

    public void openDialog(){
        // custom dialog
        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.forgot_pass_dialog);
        dialog.setTitle("");

        // set the custom dialog components - text, image and button
        TextView submitBtn = (TextView) dialog.findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @OnClick(R.id.forgotBackBtn)
    public void onBackButtonPressed(){
        finish();
    }
}
