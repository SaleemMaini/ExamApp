package com.example.examapp.Controller;

import android.content.ContentValues;
import android.database.Cursor;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examapp.helper.DatabaseHelper;

public class QuestionController extends BaseController {

    public QuestionController(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void create() {
        try {
            String create = "CREATE TABLE IF NOT EXISTS course(id INTEGER PRIMARY KEY AUTOINCREMENT, text TEXT, id_answer INTEGER, mark INTEGER, id_course INTEGER);";
            new DatabaseHelper(getActivity()).execSQL(create);
        } catch (Exception e) {
        }
    }

    @Override
    public boolean login(String username, String password) {
            return false;
        }


    @Override
    public long insert(ContentValues values) {
        return new DatabaseHelper(getActivity()).insertData("course", values);
    }
}