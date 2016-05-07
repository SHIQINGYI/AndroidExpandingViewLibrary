package com.diegodobelo.expandinganimlib;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by diego on 5/5/16.
 */
public class ExpandingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String[] mItems;
    private List<String[]> mSubItems;
    public ExpandingAdapter(String[] items, List<String[]> subItems){
        mItems = items;
        mSubItems = subItems;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ExpandingItem item = (ExpandingItem) inflater.inflate(R.layout.expanding_layout, parent, false);
        RecyclerView.ViewHolder holder = new ExpandingItemViewHolder(item);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ExpandingItemViewHolder)holder).setData(mItems[position], position < mSubItems.size() ? mSubItems.get(position) : null);
    }

    @Override
    public int getItemCount() {
        return mItems.length;
    }
}
