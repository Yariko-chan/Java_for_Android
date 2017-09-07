package com.gmail.ganeeva.d.homework.lesson14.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Diana on 06.09.2017.
 */

class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "db_name";
    public static final int DB_VERSION = 1;
    private static final String TAG = DBHelper.class.getSimpleName();
    private static final String CREATE_USER_TABLE = "CREATE TABLE User" +
            "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' TEXT, 'age' INTEGER, 'countryId' INTEGER)";
    private static final String CREATE_COUNTRY_TABLE = "CREATE TABLE Country" +
            "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' TEXT)";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate");
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_COUNTRY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade");

    }
}
