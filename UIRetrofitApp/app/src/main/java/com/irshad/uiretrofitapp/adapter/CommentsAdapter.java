package com.irshad.uiretrofitapp.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.irshad.uiretrofitapp.R;
import com.irshad.uiretrofitapp.model.VotedDataM;

import java.util.List;

/**
 * Created by irshadvali on 26/01/17.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.MyViewHolder> {
    FragmentActivity activity;
    private List<VotedDataM> fulldatalist;

    public class MyViewHolder extends RecyclerView.ViewHolder {
//        public TextView opttxt, perctxt;
//        public ProgressBar pb_drawable;

        public MyViewHolder(View view) {
            super(view);
//            opttxt = (TextView) view.findViewById(R.id.opt);
//            perctxt = (TextView) view.findViewById(R.id.per);
//            pb_drawable = (ProgressBar) view.findViewById(R.id.pb_drawable);
        }
    }
    public CommentsAdapter(FragmentActivity activity, List<VotedDataM> fulldatalist) {
        this.activity = activity;
        this.fulldatalist = fulldatalist;
    }
    @Override
    public CommentsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comments_tab_item, parent, false);

        return new CommentsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentsAdapter.MyViewHolder holder, int position) {
        VotedDataM fulldata = fulldatalist.get(position);
//        holder.opttxt.setText(fulldata.getOption());
//        holder.perctxt.setText("" + fulldata.getPerc()+ "%");
//        holder.pb_drawable.setProgress(fulldata.getPerc());
//        if (position == 0) {
//            Drawable d = activity.getResources().getDrawable(R.drawable.pb_st_a);
//            holder.pb_drawable.setProgressDrawable(d);
//        } else if (position == 1) {
//            Drawable d = activity.getResources().getDrawable(R.drawable.pb_st_b);
//            holder.pb_drawable.setProgressDrawable(d);
//        } else if (position == 2) {
//            Drawable d = activity.getResources().getDrawable(R.drawable.pb_st_c);
//            holder.pb_drawable.setProgressDrawable(d);
//        } else {
//            Drawable d = activity.getResources().getDrawable(R.drawable.pb_st_d);
//            holder.pb_drawable.setProgressDrawable(d);
//
//        }

    }

    @Override
    public int getItemCount() {
        return fulldatalist.size();
    }
}
