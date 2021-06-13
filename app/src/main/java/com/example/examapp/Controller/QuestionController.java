package com.example.examapp.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examapp.Model.Data_Question;
import com.example.examapp.Model.Data_Student;
import com.example.examapp.helper.DatabaseHelper;

import java.util.ArrayList;

public class QuestionController extends BaseController {

    public QuestionController(AppCompatActivity activity) {
        super(activity);
    }


    @Override
    public void create() {
        try {
            String create = "CREATE TABLE IF NOT EXISTS question(\"id\"\tINTEGER,\n" +
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
        return new DatabaseHelper(getActivity()).insertData("question", values);
    }
    public long updateData(String TableName, ContentValues values, String where, String[] whereAr){
        return new DatabaseHelper(getActivity()).updateData("question", values, where, whereAr);
    }

    public Data_Question getQuestionId_course(int id_course) {

        Cursor cursor = new DatabaseHelper(getActivity()).getData("SELECT * FROM question WHERE id_course='" + id_course + "';");
        Data_Question Data_Question;
        if (cursor.getCount() == 0) return null;
        Data_Question = new Data_Question();
        if (cursor.moveToFirst()) do {
            Data_Question.setText(cursor.getString(cursor.getColumnIndex("text")));
////            Data_Question.setId_answer(cursor.getInt(cursor.getColumnIndex("id_answer")));
//            Data_Question.setMark(cursor.getInt(cursor.getColumnIndex("mark")));
////            Data_Question.setId_answer(cursor.getInt(cursor.getColumnIndex("id_course")));
        } while (cursor.moveToNext());

        return Data_Question;
    }
}