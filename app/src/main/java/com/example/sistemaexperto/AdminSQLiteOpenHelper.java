package com.example.sistemaexperto;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//Clase para crear la base de datos con SQLite
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override //Metodo para crear la tabla donde se almacenan los paises con su capital
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table paises (pais text, capital text)");
    }

    @Override // no le encontre uso, pero era requerido por la clase
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
}
