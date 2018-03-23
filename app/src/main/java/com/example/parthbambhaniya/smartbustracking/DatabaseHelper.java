package com.example.parthbambhaniya.smartbustracking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by bmpar on 1/10/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    SQLiteDatabase mydb;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "sbtDB";
    private static final String TABLE_BUS_ROUTE = "SBTBusRoute";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_BUS_ROUTE = "CREATE TABLE " +TABLE_BUS_ROUTE+
                " (ROUTE_ID INTEGER PRIMARY KEY ASC AUTOINCREMENT NOT NULL," +
                "ROUTE_NUMBER TEXT(10)," +
                "ROUTE_START_FROM TEXT(20)," +
                "ROUTE_END_TO TEXT(20)," +
                "ROUTE_STATUS BOOLEAN UNIQUE)";
        db.execSQL(CREATE_TABLE_BUS_ROUTE);
        insertIntoTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUS_ROUTE);
        onCreate(db);
    }
    public void insertIntoTable() {
        try {
            mydb.execSQL("INSERT INTO " + TABLE_BUS_ROUTE
                    + "('ROUTE_NUMBER') VALUES('R1')");
            mydb.execSQL("INSERT INTO " + TABLE_BUS_ROUTE
                    + "('ROUTE_NUMBER') VALUES('R2')");
            mydb.execSQL("INSERT INTO " + TABLE_BUS_ROUTE
                    + "('ROUTE_NUMBER') VALUES('R3')");
            mydb.execSQL("INSERT INTO " + TABLE_BUS_ROUTE
                    + "('ROUTE_NUMBER') VALUES('R4')");
            mydb.execSQL("INSERT INTO " + TABLE_BUS_ROUTE
                    + "('ROUTE_NUMBER') VALUES('R5')");
            mydb.execSQL("INSERT INTO " + TABLE_BUS_ROUTE
                    + "('ROUTE_NUMBER') VALUES('R6')");
            mydb.close();
        } catch (Exception ignored) {

        }
    }
}