package com.example.contactapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class phoneCall {
    String phoneNumber;
    Context context;

    public phoneCall(String phoneNumber, Context context) {
        this.phoneNumber = phoneNumber;
        this.context = context;
    }

    public  void calling(){
        if (phoneNumber.trim().length()>0)
        {
            String dial = "tel:"+phoneNumber;
            Intent phone_intent = new Intent(Intent.ACTION_CALL);
            phone_intent.setData(Uri.parse(dial));
            phone_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(phone_intent);
        }


    }
}
