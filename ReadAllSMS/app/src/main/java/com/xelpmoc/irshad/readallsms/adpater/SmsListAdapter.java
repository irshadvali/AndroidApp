package com.xelpmoc.irshad.readallsms.adpater;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.xelpmoc.irshad.readallsms.MainActivity;
import com.xelpmoc.irshad.readallsms.R;
import com.xelpmoc.irshad.readallsms.Sms;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Irshad on 21/06/17.
 */

public class SmsListAdapter extends RecyclerView.Adapter<SmsListAdapter.MyViewHolder> {
    Activity activity;
    List<Sms> lstSms;

    public SmsListAdapter(MainActivity mainActivity, List<Sms> lstSms) {
        this.activity = mainActivity;
        this.lstSms = lstSms;

    }

    @Override
    public SmsListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sms_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SmsListAdapter.MyViewHolder holder, int position) {

        holder.textbody.setText(lstSms.get(position).getMsg());

//        String longV = "1343805819061";
        long millisecond = Long.parseLong(lstSms.get(position).getTime());
        // or you already have long value of date, use this instead of milliseconds variable.
        String dateString = DateFormat.format("dd/MM/yyyy hh:mm:ss", new Date(millisecond)).toString();
        holder.datetxt.setText(""+dateString);
        holder.address.setText(""+lstSms.get(position).getAddress());
        System.out.println("Sms test Read State"+lstSms.get(position).getReadState());
        System.out.println("Sms test Read Address"+lstSms.get(position).getAddress());
        System.out.println("Sms test Read folder"+lstSms.get(position).getFolderName());
    }

    @Override
    public int getItemCount() {
        return lstSms.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textbody,datetxt,address;

        public MyViewHolder(View view) {
            super(view);
            textbody = (TextView) view.findViewById(R.id.textbody);
            datetxt = (TextView) view.findViewById(R.id.datetxt);
            address = (TextView) view.findViewById(R.id.address);

        }
    }
}
