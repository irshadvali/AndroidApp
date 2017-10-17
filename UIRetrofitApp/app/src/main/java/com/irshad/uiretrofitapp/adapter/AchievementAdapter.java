package com.irshad.uiretrofitapp.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.irshad.uiretrofitapp.R;
import com.irshad.uiretrofitapp.model.VotedDataM;

import java.util.List;

/**
 * Created by irshadvali on 29/01/17.
 */

public class AchievementAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER=0;
    private static final int TYPE_ITEM=1;
    FragmentActivity activity;
    private List<VotedDataM> fulldatalist;

//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        public TextView badgetext;
//
//        public MyViewHolder(View view) {
//            super(view);
//            badgetext=(TextView) view.findViewById(R.id.badgetext);
//
//        }
//    }
    public AchievementAdapter(FragmentActivity activity, List<VotedDataM> fulldatalist) {
        this.activity = activity;
        this.fulldatalist = fulldatalist;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType==TYPE_HEADER){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.header_lay,parent,false);
            return new HeaderViewHolder(view);
        }else if(viewType==TYPE_ITEM){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.achievents_tab_items,parent,false);
            return new ItemListViewHolder(view);
        }
        return null;
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.achievents_tab_items, parent, false);
//
//        return new AchievementAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        VotedDataM fulldata = fulldatalist.get(position);
//        holder.badgetext.setText("Badge "+ position);

        if(holder instanceof HeaderViewHolder){
            HeaderViewHolder headerViewHolder=(HeaderViewHolder)holder;
//            headerViewHolder.txtHeader.setText("Header-List");
//            headerViewHolder.txtHeader.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(context,"You Clicked header",Toast.LENGTH_SHORT).show();
//                }
//            });
        }
        else if(holder instanceof ItemListViewHolder){
            ItemListViewHolder itemListViewHolder=(ItemListViewHolder)holder;
            VotedDataM fulldata = fulldatalist.get(position);
            itemListViewHolder.badgetext.setText("Badge "+ position);
//            Data currentItem =getItem(position-1);
//            ItemListViewHolder itemListViewHolder=(ItemListViewHolder)holder;
//            itemListViewHolder.txtName.setText(currentItem.getName());
//            itemListViewHolder.txtName.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(context,"Clicked item"+(position-1),Toast.LENGTH_SHORT).show();
//                }
//            });
        }


    }
    @Override
    public  int getItemViewType(int postion){
        if(positionHeader(postion)){
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }
    private boolean positionHeader(int position){
        return position ==0;
    }
    @Override
    public int getItemCount() {
        return fulldatalist.size();
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder{
        TextView txtHeader;
        public HeaderViewHolder (View itemView){
            super(itemView);
            //this.txtHeader=(TextView)itemView.findViewById(R.id.txt_header);
        }
    }
    public class ItemListViewHolder extends RecyclerView.ViewHolder{
        TextView badgetext;
        public ItemListViewHolder(View itemView) {
            super(itemView);
            this.badgetext=(TextView) itemView.findViewById(R.id.badgetext);
        }
    }
}
