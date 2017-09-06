package com.example.data.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.data.db_entity.Country;
import com.example.data.db_entity.User;

import java.util.List;

/**
 * Created by Diana on 06.09.2017.
 */

public class DBManager {
    private static final String TAG = DBManager.class.getSimpleName();
    private DBHelper dbHelper;
    private SQLiteDatabase database;
    private Context context;

    public DBManager(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
    }

    public void openDB(boolean isWritable) {
        database = isWritable
                ? dbHelper.getWritableDatabase()
                : dbHelper.getReadableDatabase();
    }

    public void closeDB() {
        if (database != null) {
            database.close();
        }
    }

    public void insertUser(User user) {
        StringBuilder builder = new StringBuilder("INSERT INTO User('name', 'age', 'countryId' ");
        builder.append("VALUES (");
        builder.append("'");
        builder.append(user.getName());
        builder.append("', ");
        builder.append(user.getAge());
        builder.append(", ");
        builder.append(user.getCountry().getId());
        builder.append(") ");

        Log.d(TAG, builder.toString());
        database.execSQL(builder.toString());
    }

    public void updateUser(User user) {

    }

    public List<User> getUsers() {
        return null;
    }

    public User getUserById(int id) {

        Cursor cursor = database.rawQuery(
                "SELECT * FROM User INNER JOIN Country ON User.countryID = Country.id WHERE id = ?",
                new String[]{String.valueOf(id)});

        // cursor is a result of a query
        // a collection of rows from result table
        // in each row colun detected by index

        if (cursor != null) {
            // cursor is on the end
            cursor.moveToFirst();

            User user = new User();
            user.setId(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setAge(cursor.getInt(2));
            user.setCountry(new Country(cursor.getInt(3), cursor.getString(4)));

            return user;
        } else {
            Log.e(TAG, "getUserById cursor is null");
            return null;
        }
    }
}
