package com.example.examapp.Controller;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examapp.Model.Data_Question;
import com.example.examapp.Model.Data_Student;
import com.example.examapp.helper.DatabaseHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StudentController extends BaseController {

    public static final String create = "CREATE TABLE IF NOT EXISTS student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, fname TEXT, lname TEXT, username TEXT UNIQUE, password TEXT UNIQUE, id_exam INTEGER)";

    public StudentController(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void create() {
        try {
            new DatabaseHelper(getActivity()).execSQL(create);
        } catch (Exception e) {
        }
    }

    @Override
    public boolean login(String username, String password) {
        Cursor cursor = new DatabaseHelper(getActivity()).getData("SELECT * FROM student WHERE username='" + username + "' AND password='" + password + "'");
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
        return new DatabaseHelper(getActivity()).insertData("student", values);
    }
    public long updateData(String TableName, ContentValues values, String where, String[] whereAr){
        return new DatabaseHelper(getActivity()).updateData("student", values, where, whereAr);

    }

    public List<Data_Student> getAllStudent() {
        Cursor cursor = new DatabaseHelper(getActivity()).getData("SELECT * FROM student;");

        if (cursor.getCount() == 0) return new ArrayList<>();

        List<Data_Student> list = new ArrayList<>();
        if (cursor.moveToFirst()) do {
            Data_Student stu = new Data_Student();
            stu.setName(cursor.getString(cursor.getColumnIndex("name")));
            stu.setFname(cursor.getString(cursor.getColumnIndex("fname")));
            stu.setLname(cursor.getString(cursor.getColumnIndex("lname")));
            stu.setUsername(cursor.getString(cursor.getColumnIndex("username")));
            stu.setPassword(cursor.getString(cursor.getColumnIndex("password")));
            list.add(stu);
        } while (cursor.moveToNext());

        return list;
    }

    public Data_Student getStudentByName(String Name) {
        Cursor cursor = new DatabaseHelper(getActivity()).getData("SELECT * FROM student WHERE name='" + Name + "';");
        Data_Student Data_Student;
        if (cursor.getCount() == 0) return null;
        Data_Student = new Data_Student();
        if (cursor.moveToFirst()) do {
            Data_Student.setName(cursor.getString(cursor.getColumnIndex("name")));
            Data_Student.setFname(cursor.getString(cursor.getColumnIndex("fname")));
            Data_Student.setLname(cursor.getString(cursor.getColumnIndex("lname")));
            Data_Student.setUsername(cursor.getString(cursor.getColumnIndex("username")));
            Data_Student.setPassword(cursor.getString(cursor.getColumnIndex("password")));
        } while (cursor.moveToNext());

        return Data_Student;
    }

}