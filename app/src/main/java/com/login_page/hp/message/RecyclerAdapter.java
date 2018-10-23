package com.login_page.hp.message;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.RecyclerViewHolder>{

    ArrayList<Message> m;

    public RecyclerAdapter(ArrayList<Message> m){
        this.m = m;
    }
    @NonNull
    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text,parent,false);

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Message message = m.get(position);
        holder.tv1.setText(message.getAddress());
        holder.tv2.setText(message.getBody());
        holder.tv3.setText(message.getDate());
    }

    @Override
    public int getItemCount() {
        return m.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView tv1,tv2,tv3;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.address);
            tv2 = itemView.findViewById(R.id.body);
            tv3 = itemView.findViewById(R.id.date);
        }
    }
}
