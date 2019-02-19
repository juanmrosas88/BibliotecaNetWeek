package com.example.netweektp.AD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BD extends SQLiteOpenHelper {

    public BD(Context context) {
        super(context, "BiblioNetWeek.db", null, 0);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE Categoria (" +
                "IDCategoriaBD INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Nombre TEXT, " +
                "Habilitada INTEGER)";
        db.execSQL(sql);

        String sql1 = "CREATE TABLE Libro (" +
                "IDLibroBD INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Nombre TEXT, " +
                "FechaEdicion TEXT, " +
                "EnStock INTEGER," +
                "Editorial TEXT , " +
                "IDCategLibBD TEXT ) ";
        db.execSQL(sql1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE If EXISTS Categoria");
        db.execSQL("DROP TABLE If EXISTS Libro");
        onCreate(db);
    }
}
