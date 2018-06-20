package com.brillicaservices.gurjas.firebasemoviessample.series;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class SeriesListAdapter extends RecyclerView.Adapter<SeriesListAdapter.SeriesViewHolder> {
    @Override
    public SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(SeriesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SeriesViewHolder extends RecyclerView.ViewHolder {
        public SeriesViewHolder(View itemView) {
            super(itemView);
        }
    }
}
