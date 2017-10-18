package com.example.chetanya.materialtabs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class ContctAdapter extends RecyclerView.Adapter<ContctAdapter.ViewHolder> {
    /*ArrayList<String> Names = new ArrayList<>();
    ArrayList<String> Status = new ArrayList<>();*/
    ArrayList<String> Destination = new ArrayList<>();
    String Key[];
    Context context;
    TreeMap<String, String> treeMap = new TreeMap<>();

    public ContctAdapter(Context context, ArrayList<String> destination, TreeMap<String, String> treeMap) {

        Destination = destination;
        this.treeMap = treeMap;
        Key = new String[treeMap.size()];
        getKeys();
    }

    @Override
    public ContctAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewtype, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContctAdapter.ViewHolder holder, int position) {
        holder.imImageView.setImageResource(R.mipmap.ic_launcher);
        holder.tvNames.setText(Key[position]);
        holder.tvStatus.setText(treeMap.get(Key[position]));
        holder.tvDestination.setText("MOBILE"/*Destination.get(position)*/);
    }

    @Override
    public int getItemCount() {
        return treeMap.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNames;
        TextView tvStatus;
        TextView tvDestination;
        ImageView imImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            tvNames = (TextView)itemView.findViewById(R.id.tvName);
            tvStatus = (TextView)itemView.findViewById(R.id.tvMessage);
            tvDestination = (TextView)itemView.findViewById(R.id.tvDate);
            imImageView = (ImageView)itemView.findViewById(R.id.ivImage);
        }
    }

    public void getKeys(){
        Set<String> keys = treeMap.keySet();
        Iterator iter = keys.iterator();
        int count = 0;
        while (iter.hasNext()){
            Key[count++] = (String) iter.next();
        }
    }
}
