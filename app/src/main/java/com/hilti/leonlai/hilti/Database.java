package com.hilti.leonlai.hilti;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by leonlai on 27-Nov-16.
 */

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME="contacts.db";
    private static final String TABLE_NAME="contacts";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_PASSWORD="password";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null , " +
    "name text not null , password text not null);";

    //consturtor
    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db =db;

    }

    public void insertContact (Contact c){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query ="select * from contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();


        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());           //take the naem that insert
        values.put(COLUMN_PASSWORD, c.getPassword());   // same as above

        db.insert(TABLE_NAME , null , values);  // insert the content to the db
        db.close();
    }


    public String searchPass(String name){
        db = this.getReadableDatabase();
        String query = "select name, password from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query , null);

        String a, b;
        b ="not found";
        if (cursor.moveToFirst())
        {
            do{
                a =cursor.getString(0); //username

                if(a.equals(name)){
                    b=cursor.getString(1); //password
                    break;
                }

            }
            while (cursor.moveToNext());
        }

        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ="Drop Table If EXIST "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
