package com.example.netweektp.AD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.netweektp.Entidades.Libro;

public class LibroAD {
    public static void InsertarObjetoLibro(Context context, Libro li){
        BD objBD = new BD(context);
        SQLiteDatabase db = objBD.getWritableDatabase();

        db.execSQL("INSERT INTO Libros (Nombre,FechaEdicion,EnStock,Editorial,IDCategLibBD ) VALUES ('" + li.getNombre() +
                "', '" + li.getFechaEdicion() +
                "', '" + li.getEnStock() +
                "', '" + li.getEditorial() +
                "', '" + li.getId_Categoria());
    }
    public static Cursor BuscarTodosLibros(Context context){
        BD objBD = new BD(context);
        SQLiteDatabase db = objBD.getReadableDatabase();
        return db.rawQuery("SELECT * FROM Libros",null);

    }
}
