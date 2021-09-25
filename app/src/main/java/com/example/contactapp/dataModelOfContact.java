package com.example.contactapp;

import android.widget.ImageView;

public class dataModelOfContact {
    int img;
    String name;
    String number;

    public dataModelOfContact(int img, String name, String number) {
        this.img = img;
        this.name = name;
        this.number = number;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
