package com.irshad.uiretrofitapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.irshad.uiretrofitapp.R;
import com.irshad.uiretrofitapp.ui.FeedPollsAct;
import com.irshad.uiretrofitapp.ui.NotificationActivity;
import com.irshad.uiretrofitapp.ui.ProfileActivity;


/**
 * Created by irshadvali on 23/01/17.
 */


public class BottomBar extends Fragment {
    ImageView homebtn,othersbtn,notificationbtn,profilebtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.bottom_bar, container, false);
        homebtn=(ImageView) rootView.findViewById(R.id.homebtn);
        othersbtn=(ImageView) rootView.findViewById(R.id.othersbtn);
        notificationbtn=(ImageView) rootView.findViewById(R.id.notificationbtn);
        profilebtn=(ImageView) rootView.findViewById(R.id.profilebtn);
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"home", Toast.LENGTH_SHORT).show();
                Intent i2=new Intent(getActivity(),FeedPollsAct.class);
                i2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i2);
            }
        });
        othersbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"other", Toast.LENGTH_SHORT).show();
            }
        });
        notificationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"notification", Toast.LENGTH_SHORT).show();
                Intent gotonoty=new Intent(getActivity(), NotificationActivity.class);
                gotonoty.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(gotonoty);
            }
        });
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"profile", Toast.LENGTH_SHORT).show();
                Intent i2=new Intent(getActivity(),ProfileActivity.class);
                i2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i2);
            }
        });
        return rootView;
    }
}
