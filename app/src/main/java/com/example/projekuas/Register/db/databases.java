package com.example.projekuas.Register.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.projekuas.Register.model.Akun;
import java.util.ArrayList;

public class databases extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "akun";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_AKN = "akun";
    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_FULLNAME = "fullname";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";


    // SQL statement to create the students table
    private static final String CREATE_TABLE_STUDENTS =
            "CREATE TABLE " + TABLE_AKN + "(" +
                    KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_USERNAME + " TEXT, " +
                    KEY_FULLNAME + " TEXT, " +
                    KEY_EMAIL + " TEXT, " +
                    KEY_PASSWORD + " TEXT); ";


    public databases(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AKN);
        onCreate(db);
    }

    public long addUserDetail(String username, String fullname, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, username);
        values.put(KEY_FULLNAME, fullname);
        values.put(KEY_EMAIL, email);
        values.put(KEY_PASSWORD, password);
        return db.insert(TABLE_AKN, null, values);
    }

    public void deleteUser(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_AKN, KEY_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public int updateUser(int id, String username, String fullname, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, username);
        values.put(KEY_FULLNAME, fullname);
        values.put(KEY_EMAIL, email);
        values.put(KEY_PASSWORD, password);
        return db.update(TABLE_AKN, values, KEY_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public boolean checkLogin(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        // Define the columns you want to retrieve
        String[] columns = {KEY_ID};

        // Define the selection criteria
        String selection = KEY_USERNAME + " = ? AND " + KEY_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};

        // Query the database
        Cursor cursor = db.query(TABLE_AKN, columns, selection, selectionArgs, null, null, null);

        // Check if a row with the provided username and password exists
        boolean result = cursor.moveToFirst();

        // Close the cursor and return the result
        cursor.close();
        return result;
    }
}
