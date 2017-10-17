package com.irshad.uiretrofitapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.irshad.uiretrofitapp.R;
import com.irshad.uiretrofitapp.adapter.AchievementAdapter;
import com.irshad.uiretrofitapp.model.VotedDataM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irshadvali on 01/01/17.
 */

public class AchievementFrg extends Fragment {
    private RecyclerView recyclerView, recycler_view_two;
    private AchievementAdapter mAdapter;
    private List<VotedDataM> fulldatalist = new ArrayList<>();
    //ProgressBar pb_drawable_d;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.achievement_tab, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recycler_view_two = (RecyclerView) rootView.findViewById(R.id.recycler_view2);

        preparefullData();
        mAdapter = new AchievementAdapter(getActivity(), fulldatalist);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(),2);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 ? 2 : 1;
            }
        });
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        GridLayoutManager mLayoutManager2 = new GridLayoutManager(getActivity(),2);
        mLayoutManager2.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 ? 2 : 1;
            }
        });

        recycler_view_two.setLayoutManager(mLayoutManager2);
        recycler_view_two.setAdapter(mAdapter);

        return rootView;
    }

    public void preparefullData() {

        VotedDataM fulldata = new VotedDataM("Option A", 23, 34);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option B", 56, 80);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option C", 40, 20);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option D", 14, 56);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option D", 14, 56);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option D", 14, 56);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option D", 14, 56);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option D", 14, 56);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option D", 14, 56);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option D", 14, 56);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option D", 14, 56);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option D", 14, 56);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option D", 14, 56);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option D", 14, 56);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option D", 14, 56);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option D", 14, 56);
        fulldatalist.add(fulldata);  fulldata = new VotedDataM("Option D", 14, 56);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option D", 14, 56);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option D", 14, 56);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option D", 14, 56);
        fulldatalist.add(fulldata);


//        AIzaSyBnGGYBLCkwB8phFRDieFt49WFZ9kzVv5g           for youtube
    }
}