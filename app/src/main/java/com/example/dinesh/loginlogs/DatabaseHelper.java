package com.example.dinesh.loginlogs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinesh on 04-07-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "login_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(Login.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Login.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertUser(String username,String password) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Login.UserName, username);
        values.put(Login.PassWord,password);

        // insert row
        long id = db.insert(Login.TABLE_NAME, null, values);
        // close db connection
        db.close();
return id;
        // return newly inserted row id

    }
       public String getAllLogs() {
        // Select All Query
        String selectQuery = "SELECT  * FROM " + Login.TABLE_NAME + " ORDER BY " +
                Login.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        String logs="";
        int count=1;

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
               logs=logs+"\n"+count+"."+"\t"+cursor.getString(cursor.getColumnIndex(Login.UserName))
               +"\t\t"+cursor.getString(cursor.getColumnIndex(Login.COLUMN_TIMESTAMP));
               count++;
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return logs;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + Login.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

}
