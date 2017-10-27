package com.irshad.xelpmoc.themechangeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SecondActivity extends AppCompatActivity {
    LinearLayout layone;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_second);
        layone=(LinearLayout) findViewById(R.id.layone);
        button=(Button) findViewById(R.id.button);
        layone.setBackgroundColor(Utils.backgroundcolor);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SecondActivity.this,SVGColorChangedAct.class);
                startActivity(i);
            }
        });
    }
}
