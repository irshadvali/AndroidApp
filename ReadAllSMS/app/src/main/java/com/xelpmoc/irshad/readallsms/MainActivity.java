package com.xelpmoc.irshad.readallsms;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xelpmoc.irshad.readallsms.adpater.SmsListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Activity mActivity;
    RecyclerView recyclerview;
    List<Sms> lstSms = new ArrayList<Sms>();
    SmsListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity=MainActivity.this;
        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        getAllSms("inbox"); // Get all sms from inbox
//        System.out.println("Total number of message"+lstSms.get(0).getMsg());

        if(lstSms.size()>0) {
            adapter = new SmsListAdapter(MainActivity.this, lstSms);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerview.setLayoutManager(mLayoutManager);
            recyclerview.setAdapter(adapter);
        }
    }


    public List<Sms> getAllSms(String folderName) {

        Sms objSms = new Sms();
        Uri message = Uri.parse("content://sms/"+folderName);
        ContentResolver cr = mActivity.getContentResolver();

        Cursor c = cr.query(message, null, null, null, null);
        mActivity.startManagingCursor(c);
       // mActivity.startManagingCursor(c);
        int totalSMS = c.getCount();

        try {
            if (c.moveToFirst()) {
                for (int i = 0; i < totalSMS; i++) {

                    objSms = new Sms();
                    objSms.setId(c.getString(c.getColumnIndexOrThrow("_id")));
                    objSms.setAddress(c.getString(c
                            .getColumnIndexOrThrow("address")));
                    objSms.setMsg(c.getString(c.getColumnIndexOrThrow("body")));
                    objSms.setReadState(c.getString(c.getColumnIndex("read")));
                    objSms.setTime(c.getString(c.getColumnIndexOrThrow("date")));
                    lstSms.add(objSms);

                    c.moveToNext();
                }
            } else {
                return lstSms;
            }
            c.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return lstSms;
    }
}
