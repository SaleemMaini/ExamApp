package com.example.examapp.Controller;

import android.content.ContentValues;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseController {

    private AppCompatActivity activity;

    public BaseController(AppCompatActivity activity) {
        this.setActivity(activity);
    }

    public abstract void create();

    public abstract boolean login(String username, String password);

    public abstract long insert(ContentValues values);

    public AppCompatActivity getActivity() {
        return this.activity;
    }

    private void setActivity(AppCompatActivity activity) {
        this.activity = activity;
    }
}