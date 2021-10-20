package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.media.AudioAttributesCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.provider.SyncStateContract;
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

        addFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                favVariable db = new favVariable(getApplicationContext());
                db.insertRecord(setName,setNumber);
                Toast.makeText(getApplicationContext(),"add in fav ",Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"deleting",Toast.LENGTH_SHORT).show();

                ContentResolver cr = getContentResolver();
                String where = ContactsContract.Data.DISPLAY_NAME + " = ? ";
                String[] params = new String[] {setName};

                ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
                ops.add(ContentProviderOperation.newDelete(ContactsContract.RawContacts.CONTENT_URI)
                        .withSelection(where, params)
                        .build());
                try {
                    cr.applyBatch(ContactsContract.AUTHORITY, ops);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (OperationApplicationException e) {
                    e.printStackTrace();
                }

                finish();

            }
        });


    }
}