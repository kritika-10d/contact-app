package com.example.contactapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customAdapterOfContacts extends RecyclerView.Adapter<customAdapterOfContacts.myViewHolder >{
    ArrayList<dataModelOfContact> datahoder;
    //Context context;
    public customAdapterOfContacts(ArrayList<dataModelOfContact> datahoder) {
        this.datahoder = datahoder;
       // this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_contact,parent,false);
        return  new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        //dataModelOfContact temp = datahoder.get(position);
        //holder.img.setImageResource(datahoder.get(position).getImg());
        holder.name.setText(datahoder.get(position).getName());
        holder.number.setText(datahoder.get(position).getNumber());


    }

    @Override
    public int getItemCount() {
        return datahoder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView name,number;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.contact_name);
            number = itemView.findViewById(R.id.contact_number);
        }
    }

}
