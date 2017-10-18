package com.example.chetanya.materialtabs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder>{
    Context context;
    ArrayList<String> Name = new ArrayList<>();
    ArrayList<String> Date = new ArrayList<>();
    ArrayList<String> Chats = new ArrayList<>();

    public ChatAdapter(Context context, ArrayList<String> name, ArrayList<String> date, ArrayList<String> chats) {
        this.context = context;
        Name = name;
        Date = date;
        Chats = chats;
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewtype, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(Name.get(position));
        holder.tvDate.setText(Date.get(position));
        holder.tvMessage.setText(Chats.get(position));
        holder.imageView.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return Name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvName;
        TextView tvDate;
        TextView tvMessage;
        TextView tvLine;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.ivImage);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            tvDate = (TextView)itemView.findViewById(R.id.tvDate);
            tvMessage = (TextView)itemView.findViewById(R.id.tvMessage);
            tvLine = (TextView)itemView.findViewById(R.id.tvLine);

        }
    }
}

