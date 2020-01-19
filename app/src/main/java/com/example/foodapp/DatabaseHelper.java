package com.example.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "app.db";
    public static final String USER_TABLE = "user_table";
    public static final String RESTAURANT_TABLE = "restaurant_table";

    // Columns in USER_TABLE
    public static final String UCOL_1 = "ID";
    public static final String UCOL_2 = "NAME";
    public static final String UCOL_3 = "PASSWORD";
    public static final String UCOL_4 = "EMAIL";
    public static final String UCOL_5 = "POINTS";
    public static final String UCOL_6 = "VISITS";
    public static final String UCOL_7 = "QR";

    // Columns in RESTAURANT_TABLE
    public static final String RCOL_1 = "ID";
    public static final String RCOL_2 = "NAME";
    public static final String RCOL_3 = "PASSWORD";
    public static final String RCOL_4 = "EMAIL";
    public static final String RCOL_5 = "ADDRESS";
    public static final String RCOL_6 = "CONTRIBUTION";
    public static final String RCOL_7 = "PICKUP";

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
                "POINTS INTEGER, " +
                "VISITS TEXT, " +
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


    //TODO: May need to close db in methods
    /*
    ALL RESTAURANT METHODS
     */
    public boolean restaurantSignup(String name, String password, String email, String address) {
        Random rand = new Random();
        int num = rand.nextInt(100);

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(RCOL_2, name);
        contentValues.put(RCOL_3, password);
        contentValues.put(RCOL_4, email);
        contentValues.put(RCOL_5, address);
        contentValues.put(RCOL_6, num);

        long result = db.insert(RESTAURANT_TABLE, null, contentValues);
        if (result == -1)
            return false;

        return true;
    }

    // returns Map variable to map all user data to their values
    public Map restaurantLogin(String email, String password) {
        Map map = new HashMap();

        String whereClause = "email = ? AND password = ?";
        String[] whereArgs = new String[] {
                email,
                password
        };

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(RESTAURANT_TABLE, null, whereClause, whereArgs, null, null, null);

        if (cursor.getCount() == 0)
            return map;

        while(cursor.moveToNext()) {

            map.put("name", cursor.getString(1));
            map.put("email", cursor.getString(3));
            map.put("address", cursor.getString(4));
            map.put("contribution", cursor.getInt(5));
            // TODO: How do I get a JSONObject from table?
            map.put("pickup", cursor.getString(6));
        }

        cursor.close();
        return map;

    }

    public boolean restaurantUpdate(String email, int contribution, JSONObject pickup){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RCOL_6, contribution);
        contentValues.put(RCOL_7, pickup.toString());

        db.update(RESTAURANT_TABLE, contentValues, "EMAIL = ?", new String[] { email});
        return true;
    }

    public int getContribution(String email) {
        int contribution = 0;

        String whereClause = "email = ?";
        String[] whereArgs = new String[] {
                email,
        };

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(RESTAURANT_TABLE, null, whereClause, whereArgs, null, null, null);

        while(cursor.moveToNext()){
            contribution += cursor.getInt(6);
        }
        return contribution;

    }

    public JSONObject getPickup(String email) throws JSONException {
        StringBuilder result = new StringBuilder();

        String whereClause = "email = ?";
        String[] whereArgs = new String[] {
                email,
        };

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(RESTAURANT_TABLE, null, whereClause, whereArgs, null, null, null);

        while(cursor.moveToNext()) {
            result.append(cursor.getString(6));
        }


        return new JSONObject(result.toString());
    }

    // returns total contribution made by all restaurants
    public int totalContribution(){
        int total = 0;

        String whereClause = "contribution > 0";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(RESTAURANT_TABLE, null, whereClause, null, null, null, null);

        if (cursor.getCount() == 0)
            return 0;

        while (cursor.moveToNext()) {
            total += cursor.getInt(5);
        }

        cursor.close();
        return total;
    }

    public List<Map> leaderboard() {
        // TODO: Do I need to define key/value data types
        List<Map> leaderboard = new ArrayList<>();


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(RESTAURANT_TABLE, null, null, null, null, null, "CONTRIBUTION DESC", "10");

        if (cursor.getCount() == 0)
            return leaderboard;

        Map map = new HashMap();

        while(cursor.moveToNext()) {
            map.put("name", cursor.getString(1));
            map.put("contribution", cursor.getInt(5));
            leaderboard.add(map);
            map = new HashMap();
        }

        cursor.close();
        return leaderboard;

    }



    /*
    ALL USER METHODS
     */
    public boolean userSignup(String name, String password, String email) {
        Random rand = new Random();
        int num = rand.nextInt(100);

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UCOL_2, name);
        contentValues.put(UCOL_3, password);
        contentValues.put(UCOL_4, email);
        contentValues.put(UCOL_5, num);

        long result = db.insert(USER_TABLE, null, contentValues);

        if (result == -1)
            return false;

        return true;
    }


    // returns map with user info. Its empty if user doesnt exist.
    public Map userLogin(String email, String password) {
        Map map = new HashMap();

        String whereClause = "email = ? AND password = ?";
        String[] whereArgs = new String[] {
                email,
                password
        };

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(USER_TABLE, null, whereClause, whereArgs, null, null, null);

        if (cursor.getCount() == 0)
            return map;

        while(cursor.moveToNext()) {
            map.put("name", cursor.getString(1));
            map.put("email", cursor.getString(3));
        }

        cursor.close();
        return map;

    }

    public int getPoints(String email){
        int points = 0;

        String whereClause = "email = ?";
        String[] whereArgs = new String[] {
                email,
        };

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(USER_TABLE, null, whereClause, whereArgs, null, null, null);

        while(cursor.moveToNext()){
            points += cursor.getInt(4);
        }
        cursor.close();
        return points;
    }

    public JSONObject getVisits(String email) throws JSONException {
        StringBuilder temp = new StringBuilder();

        String whereClause = "email = ?";
        String[] whereArgs = new String[] {
                email,
        };

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(USER_TABLE, null, whereClause, whereArgs, null, null, null);

        while(cursor.moveToNext()){
            temp.append(cursor.getString(5));
        }
        JSONObject result = new JSONObject(temp.toString());
        cursor.close();
        return result;
    }

    public boolean updateUser(String email, int points, JSONObject visits){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UCOL_5, points);
        contentValues.put(UCOL_6, visits.toString());

        db.update(USER_TABLE, contentValues, "EMAIL = ?", new String[] { email});
        return true;
    }







}
