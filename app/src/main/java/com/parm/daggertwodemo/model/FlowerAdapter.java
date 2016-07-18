package com.parm.daggertwodemo.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parm.daggertwodemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PARAM on 7/18/2016.
 */
public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.Holder> {


    private final LayoutInflater mLayoutInflater;
    private List<FlowerResponse> mFlowerResponseList;
    public FlowerAdapter(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(mLayoutInflater.inflate(R.layout.item_flowers, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mFlowerResponseList.size();
    }

    public void addFlowers(List<FlowerResponse> flowerResponses) {
        mFlowerResponseList.addAll(flowerResponses);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder{

        public Holder(View itemView) {
            super(itemView);
        }
    }
}
