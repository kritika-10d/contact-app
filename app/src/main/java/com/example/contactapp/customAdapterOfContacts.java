package com.example.contactapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customAdapterOfContacts extends RecyclerView.Adapter<customAdapterOfContacts.myViewHolder> {
    ArrayList<dataModelOfContact> datahoder;
    Context context;
    public customAdapterOfContacts(ArrayList<dataModelOfContact> datahoder,Context context) {
        this.datahoder = datahoder;
        this.context = context;
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

    public  void filterList(ArrayList<dataModelOfContact> filteredList){
        datahoder = filteredList;
        notifyDataSetChanged();
    }

    class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView img;
        TextView name,number;
        Button call;
        EditText editText;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.contact_name);
            number = itemView.findViewById(R.id.contact_number);
            call = itemView.findViewById(R.id.callButton);

            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAbsoluteAdapterPosition();
                   // Toast.makeText(context,"i clicked on position:"+position,Toast.LENGTH_SHORT).show();
                    dataModelOfContact temp = datahoder.get(position);
                    String phone_number = temp.getNumber();
                    phoneCall obj = new phoneCall(phone_number, context);
                    obj.calling();
                }
            });
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAbsoluteAdapterPosition();
            //Toast.makeText(context,"i clicked on position:"+position,Toast.LENGTH_SHORT).show();
            dataModelOfContact temp = datahoder.get(position);
            Intent intent = new Intent(context,displayContactDetails.class);
            intent.putExtra("name",temp.getName());
            intent.putExtra("number",temp.getNumber());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

}
