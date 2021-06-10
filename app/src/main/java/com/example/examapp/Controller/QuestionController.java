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
            String create = "CREATE TABLE IF NOT EXISTS course(\"id\"\tINTEGER,\n" +
                    "\t\"text\"\tTEXT,\n" +
                    "\t\"id_answer\"\tINTEGER,\n" +
                    "\t\"mark\"\tINTEGER,\n" +
                    "\t\"id_course\"\tINTEGER,\n" +
                    "\tPRIMARY KEY(\"id\"));";
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