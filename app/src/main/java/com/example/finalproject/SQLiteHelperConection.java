package com.example.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.finalproject.utilidades.Utilidades;

public class SQLiteHelperConection extends SQLiteOpenHelper {

    public SQLiteHelperConection(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREATE_USER_TABLE);
        db.execSQL(Utilidades.CREATE_BOOK_TABLE);
        db.execSQL(Utilidades.CREATE_GAME_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Utilidades.DELETE_USER_TABLE);
        db.execSQL(Utilidades.DELETE_BOOK_TABLE);
        db.execSQL(Utilidades.DELETE_GAME_TABLE);
        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }
}
