package com.example.examapp.Controller;

import android.content.ContentValues;
import android.database.Cursor;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examapp.helper.DatabaseHelper;

public class AdminController extends BaseController {

    public AdminController(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void create() {
        try {
            String create = "CREATE TABLE IF NOT EXISTS admin(\"id\"\tINTEGER,\n" +
                    "\t\"name\"\tTEXT,\n" +
                    "\t\"fname\"\tTEXT,\n" +
                    "\t\"lname\"\tTEXT,\n" +
                    "\t\"username\"\tTEXT  UNIQUE,\n" +
                    "\t\"password\"\tTEXT  UNIQUE,\n" +
                    "\tPRIMARY KEY(\"id\"));";
            new DatabaseHelper(getActivity()).execSQL(create);
        } catch (Exception e) {
        }
    }

    @Override
    public boolean login(String username, String password) {
        Cursor cursor = new DatabaseHelper(getActivity()).getData("SELECT * FROM admin WHERE username='" + username + "' AND password='" + password + "'");
        if (cursor.getCount() == 0) {
            return false;
        }

        if (cursor.moveToFirst()) do {
            int id = cursor.getInt(0);
            if (id > 0) return true;
        } while (cursor.moveToNext());

        return false;
    }

    @Override
    public long insert(ContentValues values) {
        return new DatabaseHelper(getActivity()).insertData("admin", values);
    }
}