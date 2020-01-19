package com.example.foodapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;
import org.json.JSONObject;

import java.io.Serializable;

public class DatabaseHelper extends SQLiteOpenHelper implements Serializable {

    public static final String DATABASE_NAME = "app.db";
    public static final String USER_TABLE = "user_table";
    public static final String RESTAURANT_TABLE = "restaurant_table";

    // Columns in USER_TABLE
    public static final String UCOL_1 = "ID";
    public static final String UCOL_2 = "NAME";
    public static final String UCOL_3 = "PASSWORD";
    public static final String UCOL_4 = "EMAIL";
    public static final String UCOL_5 = "POINTS";
    public static final String UCOL_6 = "QR";

    // Columns in RESTAURANT_TABLE
    public static final String RCOL_1 = "ID";
    public static final String RCOL_2 = "NAME";
    public static final String RCOL_3 = "PASSWORD";
    public static final String RCOL_4 = "EMAIL";
    public static final String RCOL_5 = "ADDRESS";
    public static final String RCOL_6 = "CONTRIBUTION";
    public static final String RCOL_7 = "TIME";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String userTable = "CREATE TABLE " +
                USER_TABLE +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, " +
                "PASSWORD TEXT, " +
                "EMAIL TEXT, " +
                "POINTS FLOAT, " +
                "QR VARBINARY)";

        String restaurantTable = "CREATE TABLE " +
                RESTAURANT_TABLE +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, " +
                "PASSWORD TEXT, " +
                "EMAIL TEXT, " +
                "ADDRESS TEXT, " +
                "CONTRIBUTION INTEGER, " +
                "PICKUP TEXT)";

        db.execSQL(userTable);
        db.execSQL(restaurantTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropUser = "DROP TABLE IF EXISTS " + USER_TABLE;
        String dropRestaurant = "DROP TABLE IF EXISTS " + RESTAURANT_TABLE;

        db.execSQL(dropUser);
        db.execSQL(dropRestaurant);

        onCreate(db);
    }

}
