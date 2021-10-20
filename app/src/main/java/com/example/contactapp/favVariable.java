package com.example.contactapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class favVariable extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "fav.db";

    public static final String TABLE_NAME = "PEOPLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_FIRST_NAME = "FIRST_NAME";
    public static final String COLUMN_SECOND_NUMBER = "LAST_NAME";

    public favVariable( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create ="create table " + TABLE_NAME + " ( " +
                COLUMN_FIRST_NAME + " VARCHAR Primary key, " + COLUMN_SECOND_NUMBER + " VARCHAR)";
        Log.d("harry","record: "+create);
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertRecord(String name,String number) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FIRST_NAME, name);
        contentValues.put(COLUMN_SECOND_NUMBER, number);
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public ArrayList<dataModelOfContact> getAllRecords() {
        ArrayList<dataModelOfContact> contacts=new ArrayList<>();////modify here
        SQLiteDatabase db=this.getReadableDatabase();
        String sql="SELECT * FROM " +TABLE_NAME;//modify here
        Cursor cursor= db.rawQuery(sql, null);
        if(cursor.moveToFirst())
        {
            do
            {
                String name= cursor.getString(0); //modify here
                String number= cursor.getString(1);//modify here
                contacts.add(new dataModelOfContact(0,name,number));//modify here
            }while(cursor.moveToNext());	//modify here
        }
        return contacts;
        }

    
}
