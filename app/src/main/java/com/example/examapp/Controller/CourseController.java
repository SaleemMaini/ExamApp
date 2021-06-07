package com.example.examapp.Controller;

import android.content.ContentValues;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examapp.helper.DatabaseHelper;

public class CourseController extends BaseController {

    public CourseController(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void create() {
        try {
            String create = "CREATE TABLE IF NOT EXISTS course(id INTEGER PRIMARY KEY AUTOINCREMENT, type TEXT, id_question INTEGER, id_exam INTEGER);";
            new DatabaseHelper(getActivity()).execSQL(create);
        } catch (Exception e) {
        }
    }

    @Override
    public boolean login(String username, String password) { return false; }

    @Override
    public long insert(ContentValues values) {
        return new DatabaseHelper(getActivity()).insertData("course", values);
    }
}