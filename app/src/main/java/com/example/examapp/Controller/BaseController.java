package com.example.examapp.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examapp.Model.Data_Question;

public abstract class BaseController {

    private AppCompatActivity activity;

    public BaseController(AppCompatActivity activity) {
        this.setActivity(activity);
    }

//    public abstract void create();

    public abstract boolean login(String username, String password);

    public abstract long insert(ContentValues values);

    public abstract long updateData(String TableName, ContentValues values, String where, String[] whereAr);


    public AppCompatActivity getActivity() {
        return this.activity;
    }

    private void setActivity(AppCompatActivity activity) {
        this.activity = activity;
    }
}