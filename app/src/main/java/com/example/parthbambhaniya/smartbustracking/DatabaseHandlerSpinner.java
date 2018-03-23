package com.example.parthbambhaniya.smartbustracking;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandlerSpinner extends SQLiteOpenHelper {
    // Database Version
    SQLiteDatabase mydb;
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "spinnerCity";

    // Labels table name
    private static final String TABLE_CITY = "city";

    // Labels Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "city_name";

    public DatabaseHandlerSpinner(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Category table create query
        String CREATE_CATEGORIES_TABLE = "CREATE TABLE " + TABLE_CITY + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT)";
        db.execSQL(CREATE_CATEGORIES_TABLE);
        insertIntoTable();
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CITY);

        // Create tables again
        onCreate(db);
    }

    /**
     * Inserting new lable into lables table
     * */
    public void insertIntoTable() {
        try {
            mydb.execSQL("INSERT INTO " + TABLE_CITY
                    + "(city_name) VALUES('GREAT INDIA')");
            mydb.execSQL("INSERT INTO " + TABLE_CITY
                    + "(city_name) VALUES('USA')");
            mydb.execSQL("INSERT INTO " + TABLE_CITY
                    + "(city_name) VALUES('JAPAN')");
            mydb.execSQL("INSERT INTO " + TABLE_CITY
                    + "(city_name) VALUES('INDIA')");
            mydb.execSQL("INSERT INTO " + TABLE_CITY
                    + "(city_name) VALUES('INDIA')");
            mydb.execSQL("INSERT INTO " + TABLE_CITY
                    + "(city_name) VALUES('INDIA')");
            mydb.close();
        } catch (Exception e) {

        }
    }
    /**
     * Getting all labels
     * returns list of labels
     * */
    public List<String> getTableValues(){
        List<String> city = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CITY;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                city.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return city;
    }
}