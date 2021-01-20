package com.zhangyf.bottomsheettest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InnerRecyclerViewAdapter extends RecyclerView.Adapter<InnerRecyclerViewAdapter.ViewHoloder> {
    private List<String> list;
    private Context context;


    InnerRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public InnerRecyclerViewAdapter.ViewHoloder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.integral_goods_exchage_grid_item_, parent, false);
        return new ViewHoloder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull InnerRecyclerViewAdapter.ViewHoloder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    class ViewHoloder extends RecyclerView.ViewHolder {


        public ViewHoloder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
