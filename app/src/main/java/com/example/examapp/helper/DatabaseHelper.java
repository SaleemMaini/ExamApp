package com.example.examapp.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class DatabaseHelper {

    private final SQLiteDatabase database;
    private AppCompatActivity activity;

    public DatabaseHelper(AppCompatActivity activity) {
        this.activity = activity;

        database = activity.openOrCreateDatabase("ExamApp", Context.MODE_PRIVATE, null);
    }

    public void execSQL(String sql) {
        database.execSQL(sql);
    }

    public Cursor getData(String sql) {
        return database.rawQuery(sql, null);
    }

    public long insertData(String tblName, ContentValues values) {
        return database.insert(tblName, null, values);
    }

    public void setActivity(AppCompatActivity activity) {
        this.activity = activity;
    }

    public AppCompatActivity getActivity() {
        return this.activity;
    }
}