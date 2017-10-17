package com.irshad.uiretrofitapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


import com.irshad.uiretrofitapp.R;
import com.irshad.uiretrofitapp.adapter.ViewPagerAdapter;
import com.irshad.uiretrofitapp.fragments.BottomBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener,ViewPager.OnPageChangeListener{
    Activity activity;

    @Bind(R.id.htab_tabs)TabLayout tabs;
    @Bind(R.id.htab_viewpager)ViewPager htab_viewpager;
    @Bind(R.id.name_txt)TextView name_txt;
    @Bind(R.id.usernameToolbarTxt)TextView toolbar_usrname;
    @Bind(R.id.settings_icon1)ImageView settings_icon1;
    ViewPagerAdapter adapter;
    AppBarLayout appbar;
    CollapsingToolbarLayout collapsing_toolbar;
    Animation bottomIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//remove status bar
        setContentView(R.layout.activity_profile);
        activity=ProfileActivity.this;
        ButterKnife.bind(this);
        bottomIn = AnimationUtils.loadAnimation(activity,R.anim.bottom_up);
        appbar=(AppBarLayout)findViewById(R.id.appbar);
        collapsing_toolbar=(CollapsingToolbarLayout)findViewById(R.id.collapse_toolbar);
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);
        adapter=new ViewPagerAdapter(getSupportFragmentManager());//setting adapter for viewpager
        htab_viewpager.setAdapter(adapter);
        tabs.setTabTextColors(
                ContextCompat.getColor(activity, R.color.black),//setting color for selected tab tab txt and unselected tab txt
                ContextCompat.getColor(activity, R.color.blue_color)
        );
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabs.setSelectedTabIndicatorColor(Color.parseColor("#32C5B6"));//setting color for selected tab indicator
        tabs.setupWithViewPager(htab_viewpager);
        htab_viewpager.setCurrentItem(1);
        tabs.setOnTabSelectedListener(this);
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                System.out.println("__V Offset : "+verticalOffset);
                int offsetValue=0;
                // "-388" for 720*1280 & "-1242" for 1080*1920 & "-679" for 1440*2560

                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
//                PrintO.log("Mobile Screen Density : "+metrics.densityDpi);
                int height = metrics.heightPixels;
                int width = metrics.widthPixels;


                if (width == 720){
                    System.out.println("__V Offset 2: "+verticalOffset);
                    offsetValue = -388;
                }
                else if (width == 1080){
                    offsetValue = -582;
                }
                else if (width == 1440){
                    offsetValue = -679;
                }


                if(verticalOffset>=-600){
                    name_txt.setVisibility(View.VISIBLE);
                    name_txt.setText("IRSHAD VALI");
                    //toolbar_usrname.setText("@username");
                    name_txt.startAnimation(bottomIn);
                    name_txt.setTextColor(getResources().getColor(R.color.black));
                    toolbar_usrname.setTextColor(getResources().getColor(R.color.black));
                    toolbar_usrname.startAnimation(bottomIn);
                }else{
                    // name_txt.setVisibility(View.GONE);
                }
                // PrintO.log("Mobile Resolution : "+width+" * "+height);

               /* if (verticalOffset <= offsetValue)
                {
                    //toolbar.setVisibility(View.VISIBLE);

                }
                else {
                    name_txt.setVisibility(View.GONE);
//                   toolbar.setBackgroundColor(Color.TRANSPARENT);

                }*/
            }
        });

        setBottom();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        htab_viewpager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void setBottom(){
        BottomBar bottomBar = new BottomBar();
        getSupportFragmentManager().beginTransaction().add(R.id.bottombar, bottomBar).commit();
    }


    @OnClick(R.id.settings_icon1)
    void setting(){
        Intent i=new Intent(activity,SettingActivity.class);
        startActivity(i);
    }
}
