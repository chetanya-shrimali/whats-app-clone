package com.example.chetanya.materialtabs;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.ViewHolder> {
    TreeMap<String, String> treeMap = new TreeMap<>();
    ArrayList<String> Names = new ArrayList<>();
    ArrayList<String> Status = new ArrayList<>();
    String Key[];

    public CallAdapter( ArrayList<String> names, ArrayList<String> status) {
        Status = status;
        Names = names;
    }

    @Override
    public CallAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewtypecall, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CallAdapter.ViewHolder holder, int position) {
        holder.Name.setText(Names.get(position));
        holder.Number.setText(Status.get(position));
        holder.imageView.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return Names.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView Name;
        TextView Number;
        ImageView Date;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.ivImage);
            Name = (TextView)itemView.findViewById(R.id.tvName);
            Number = (TextView)itemView.findViewById(R.id.tvMessage);
            Date = (ImageView)itemView.findViewById(R.id.ivImageCall);
        }
    }

    private void getKeys() {
        Set<String> keys = treeMap.keySet();
        Iterator iterator = keys.iterator();
        int count=0;
        while (iterator.hasNext()){
            Key[count++] =(String) iterator.next();
        }
    }
}
