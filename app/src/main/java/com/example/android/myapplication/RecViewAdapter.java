package com.example.android.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by schadha on 2/13/17.
 */
class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.RVViewHolder> {

    private List<Integer> listOfValues;
    View itemView;

    public RecViewAdapter(List<Integer> listOfStrings) {
        this.listOfValues = listOfStrings;
    }

    @Override
    public RVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view, parent, false);
        return new RVViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RVViewHolder holder, final int position) {
        final Integer text = listOfValues.get(position);
        holder.mText.setText(text + "");
        holder.mText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * In the absence of onClick listener, the user can't swipe though the recyclerview items
                 */
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfValues.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    protected class RVViewHolder extends RecyclerView.ViewHolder {

        protected TextView mText;

        public RVViewHolder(View itemView) {
            super(itemView);
            mText = (TextView) itemView.findViewById(R.id.text);
        }
    }
}