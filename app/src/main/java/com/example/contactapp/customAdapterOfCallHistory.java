package com.example.contactapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customAdapterOfCallHistory extends RecyclerView.Adapter<customAdapterOfCallHistory.myViewHolder> {

    ArrayList<ModelCalls> mListCalls;
    private Context mContext;
    public customAdapterOfCallHistory(ArrayList<ModelCalls> listCalls, Context context){
        mListCalls= listCalls;
        mContext = context;
    }
    public myViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_call,parent,false);
        return  new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder( myViewHolder holder, int position) {

        TextView number,duration,date;
        number= holder.number;
        duration= holder.duration;
        date= holder.date;
        number.setText(mListCalls.get(position).getNumber());
        duration.setText(mListCalls.get(position).getDuration());
        date.setText(mListCalls.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return mListCalls.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView number,duration,date;
        public myViewHolder( View itemView) {
            super(itemView);

            number = itemView.findViewById(R.id.contact_number);
            duration = itemView.findViewById(R.id.call_duration);
            date = itemView.findViewById(R.id.call_date);
        }
    }
}
