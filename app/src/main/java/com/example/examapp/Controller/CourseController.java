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
            String create = "CREATE TABLE IF NOT EXISTS course(\"id\"\tINTEGER,\n" +
                    "\t\"type\"\tTEXT,\n" +
                    "\t\"id_question\"\tINTEGER,\n" +
                    "\t\"id_exam\"\tINTEGER,\n" +
                    "\tFOREIGN KEY(\"id_question\") REFERENCES \"question\"(\"id\"),\n" +
                    "\tPRIMARY KEY(\"id\"));";
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