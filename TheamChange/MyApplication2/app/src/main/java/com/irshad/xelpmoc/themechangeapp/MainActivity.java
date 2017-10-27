package com.irshad.xelpmoc.themechangeapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Activity activity;
    private ImageView imageView,imageview1;
    Button button1,button2,button3,button4,next;
    TextView textView1;
    RelativeLayout relay;
    LinearLayout lilay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        activity=MainActivity.this;
        button1=(Button) findViewById(R.id.button1);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
        button4=(Button) findViewById(R.id.button4);
        next=(Button) findViewById(R.id.next);
        textView1=(TextView) findViewById(R.id.textView1);
        relay=(RelativeLayout) findViewById(R.id.relay);
        lilay=(LinearLayout) findViewById(R.id.lilay);
        relay.setBackgroundColor(Utils.backgroundcolor);
        lilay.setBackgroundColor(Utils.backgroundcolor);
        button1.setText(getString(R.string.Button_one));
        textView1.setText(getString(R.string.MyName));
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.changeToTheme(MainActivity.this, Utils.THEME_DEFAULT);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.changeToTheme(MainActivity.this, Utils.THEME_WHITE);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.changeToTheme(MainActivity.this, Utils.THEME_ORANGE);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });
    }


}
