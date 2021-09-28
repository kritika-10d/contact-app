package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class displayContactDetails extends AppCompatActivity {
    TextView name,number;
    Button call,addFav,delete;
    ArrayList<dataModelOfContact> favContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact_details);

        name = findViewById(R.id.nameOfDetailDisplay);
        number = findViewById(R.id.numberOfDetailDisplay);
        String setName = getIntent().getStringExtra("name");
        name.setText(setName);
        String setNumber = getIntent().getStringExtra("number");
        number.setText(setNumber);
        call = findViewById(R.id.callButton);
        addFav = findViewById(R.id.addFavButton);
        delete = findViewById(R.id.deleteButton);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneCall obj=new phoneCall(setNumber,getApplicationContext());
                obj.calling();
            }
        });


    }
}