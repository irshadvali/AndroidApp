package com.xelpmoc.irshad.readallsms;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class FirstPage extends AppCompatActivity {
    RelativeLayout smslay,urllay,contactlay;
    public static final int RequestPermissionCode_READ_CONTACTS = 3;
    public static final int RequestPermissionCode_READ_SMS = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        smslay=(RelativeLayout) findViewById(R.id.smslay);
        urllay=(RelativeLayout) findViewById(R.id.urllay);
        contactlay=(RelativeLayout) findViewById(R.id.contactlay);
        smslay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(FirstPage.this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
                    String[] permissions = {"android.permission.READ_SMS"};
                    ActivityCompat.requestPermissions(FirstPage.this, permissions, RequestPermissionCode_READ_SMS);

                } else {
                    Intent i=new Intent(FirstPage.this, MainActivity.class);
                    startActivity(i);
                }

            }
        });
        urllay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FirstPage.this, BrowserHistory.class);
                startActivity(i);
            }
        });

        contactlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(FirstPage.this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                    String[] permissions = {"android.permission.READ_CONTACTS"};
                    ActivityCompat.requestPermissions(FirstPage.this, permissions, RequestPermissionCode_READ_CONTACTS);

                } else {
                    Intent i=new Intent(FirstPage.this, ContactList.class);
                    startActivity(i);
                }

            }
        });
    }





}
