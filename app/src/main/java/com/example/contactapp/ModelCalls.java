package com.example.contactapp;

public class ModelCalls {

    private String number,duration,date;
    public ModelCalls(String number,String duration,String date){
        this.number =number;
        this.duration=duration;
        this.date=date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
