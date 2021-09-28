package com.example.contactapp;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customAdapterOfFavFragment extends RecyclerView.Adapter<customAdapterOfFavFragment.myviewholder>
{

    ArrayList<dataModelOfContact> favList;

    public customAdapterOfFavFragment(ArrayList<dataModelOfContact> favList) {
        this.favList = favList;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_contact,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        //holder.img.setImageResource();
        holder.name.setText(favList.get(position).getName());
        holder.number.setText(favList.get(position).getNumber());

    }

    @Override
    public int getItemCount() {
        return favList.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView name,number;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.contact_name);
            number = itemView.findViewById(R.id.contact_number);
        }
    }


}