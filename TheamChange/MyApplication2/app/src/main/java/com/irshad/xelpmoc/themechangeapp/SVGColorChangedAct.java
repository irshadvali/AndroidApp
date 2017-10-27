package com.irshad.xelpmoc.themechangeapp;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.StyleRes;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;

public class SVGColorChangedAct extends AppCompatActivity {
    private ImageView imageView,imageview1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_svgcolor_changed);

        final View button = findViewById(R.id.button);
        final View button2 = findViewById(R.id.button2);


        imageView = (ImageView) findViewById(R.id.imageview);
        imageview1 = (ImageView) findViewById(R.id.imageview1);

        final ContextThemeWrapper wrapper = new ContextThemeWrapper(this, R.style.DefaultScene);
        changeTheme(wrapper.getTheme());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changecolorOne();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changecolorTwo();
            }
        });
    }

    private void changeTheme(@StyleRes final Resources.Theme theme) {
        final Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.christmas, theme);
        imageView.setImageDrawable(drawable);

        final Drawable drawable1 = ResourcesCompat.getDrawable(getResources(), R.drawable.eight_seven, theme);
        imageview1.setImageDrawable(drawable1);


    }


    public void changecolorOne(){
        final Resources.Theme theme = getResources().newTheme();
        theme.applyStyle(R.style.BaubleRound, false);
        theme.applyStyle(R.style.BaubleSmall, false);
        theme.applyStyle(R.style.BaubleSmall, false);
        changeTheme(theme);
    }


    public void changecolorTwo(){
        final Resources.Theme theme = getResources().newTheme();
        theme.applyStyle(R.style.BaubleRoundtwo, false);
        theme.applyStyle(R.style.BaubleSmall, false);
        theme.applyStyle(R.style.BaubleSmall, false);
        changeTheme(theme);
    }
}
