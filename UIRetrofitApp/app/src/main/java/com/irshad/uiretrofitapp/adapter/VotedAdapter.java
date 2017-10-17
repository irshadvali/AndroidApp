package com.irshad.uiretrofitapp.adapter;

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.irshad.uiretrofitapp.R;
import com.irshad.uiretrofitapp.model.VotedDataM;

import java.util.List;

/**
 * Created by irshadvali on 14/01/17.
 */

public class VotedAdapter extends RecyclerView.Adapter<VotedAdapter.MyViewHolder> {
    FragmentActivity activity;
    private List<VotedDataM> fulldatalist;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar pb_drawable_a, pb_drawable_b, pb_drawable_c, pb_drawable_d;
        public TextView per_a, per_b, per_c, per_d;

        public MyViewHolder(View view) {
            super(view);
            pb_drawable_a = (ProgressBar) view.findViewById(R.id.pb_drawable_a);
            pb_drawable_b = (ProgressBar) view.findViewById(R.id.pb_drawable_b);
            pb_drawable_c = (ProgressBar) view.findViewById(R.id.pb_drawable_c);
            pb_drawable_d = (ProgressBar) view.findViewById(R.id.pb_drawable_d);
            per_a = (TextView) view.findViewById(R.id.per_a);
            per_b = (TextView) view.findViewById(R.id.per_b);
            per_c = (TextView) view.findViewById(R.id.per_c);
            per_d = (TextView) view.findViewById(R.id.per_d);
        }
    }

    public VotedAdapter(FragmentActivity activity, List<VotedDataM> fulldatalist) {
        this.activity = activity;
        this.fulldatalist = fulldatalist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.voted_tab_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        VotedDataM fulldata = fulldatalist.get(position);
      /*
      For Option A
       */
        holder.per_a.setText("" + 23 + "%");
        holder.pb_drawable_a.setProgress(23);
        Drawable d_a = activity.getResources().getDrawable(R.drawable.pb_st_a);
        holder.pb_drawable_a.setProgressDrawable(d_a);

        /*
        For Option b
       */

        holder.per_b.setText("" + 83 + "%");
        holder.pb_drawable_b.setProgress(83);
        Drawable d_b = activity.getResources().getDrawable(R.drawable.pb_st_b);
        holder.pb_drawable_b.setProgressDrawable(d_b);


        /*
        For Option c
       */

        holder.per_c.setText("" + 53 + "%");
        holder.pb_drawable_c.setProgress(53);
        Drawable d_c = activity.getResources().getDrawable(R.drawable.pb_st_c);
        holder.pb_drawable_c.setProgressDrawable(d_c);
    /*
        For Option d
       */

        holder.per_d.setText("" + 70 + "%");
        holder.pb_drawable_d.setProgress(70);
        Drawable d_d = activity.getResources().getDrawable(R.drawable.pb_st_d);
        holder.pb_drawable_d.setProgressDrawable(d_d);
    }

    @Override
    public int getItemCount() {
        return fulldatalist.size();
    }
}
