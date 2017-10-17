package com.irshad.uiretrofitapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.irshad.uiretrofitapp.R;
import com.irshad.uiretrofitapp.adapter.VotedAdapter;
import com.irshad.uiretrofitapp.model.VotedDataM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irshadvali on 01/01/17.
 */

public class VotedInFrg extends Fragment {
    private RecyclerView recyclerView,recycler_view_two;
    private VotedAdapter mAdapter;
    private List<VotedDataM> fulldatalist = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.votedin_tab, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);


        preparefullData();
        mAdapter = new VotedAdapter(getActivity(),fulldatalist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        return rootView;
    }
    public void preparefullData() {
        VotedDataM fulldata = new VotedDataM("Option A",23,34);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option B",56,80);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option C",40,20);
        fulldatalist.add(fulldata);
        fulldata = new VotedDataM("Option D",14,56);
        fulldatalist.add(fulldata);
//        AIzaSyBnGGYBLCkwB8phFRDieFt49WFZ9kzVv5g           for youtube
    }
}

