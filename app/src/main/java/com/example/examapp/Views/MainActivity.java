package com.example.examapp.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.examapp.Controller.AdminController;
import com.example.examapp.Controller.QuestionController;
import com.example.examapp.Controller.StudentController;
import com.example.examapp.Controller.CourseController;
import com.example.examapp.R;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    //SQLiteDatabase db;
    EditText username;
    EditText password;
    Button login;
    View activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password = findViewById(R.id.password);
        username = findViewById(R.id.username);
        login = findViewById(R.id.login);
        activity = findViewById(R.id.activity);



        try {
            new AdminController(this).create();
            new StudentController(this).create();
            new CourseController(this).create();
            new QuestionController(this).create();

        } catch (Exception e) {
        }

        ContentValues q1 = new ContentValues();
        q1.put("text","question for course 1");
        q1.put("id_answer",2);
        q1.put("mark",4);
        q1.put("id_course",0);
        new QuestionController(this).insert(q1);
        ContentValues q2 = new ContentValues();
        q2.put("text","question for course 2");
        q2.put("id_answer",2);
        q2.put("mark",4);
        q2.put("id_course",1);
        new QuestionController(this).insert(q2);
        ContentValues q3 = new ContentValues();
        q3.put("text","question for course 3");
        q3.put("id_answer",2);
        q3.put("mark",4);
        q3.put("id_course",2);
        new QuestionController(this).insert(q3);
        ContentValues q4 = new ContentValues();
        q4.put("text","question for course 4");
        q4.put("id_answer",2);
        q4.put("mark",4);
        q4.put("id_course",3);
        new QuestionController(this).insert(q4);


        ContentValues values1 = new ContentValues();
        values1.put("username","admin");
        values1.put("password","admin");
        new AdminController(this).insert(values1);

        ContentValues values2 = new ContentValues();
        values2.put("username","student");
        values2.put("password","student");
        new StudentController(this).insert(values2);


        login.setOnClickListener(v -> {
            if (password.getText().toString().isEmpty() || username.getText().toString().isEmpty()) {
                Snackbar.make(activity, "Username or password not found", Snackbar.LENGTH_LONG).show();

            } else if (username.getText().toString().toLowerCase().equals("admin")) {

                boolean logged = new AdminController(MainActivity.this).login(username.getText().toString(), password.getText().toString());
                if (logged) {
                    startActivity(new Intent(getApplicationContext(), ActivityAdminDashboard.class));
                } else {
                    Snackbar.make(activity, "Error in username or password", Snackbar.LENGTH_LONG).show();
                }

            } else if (username.getText().toString().toLowerCase().equals("student")) {

                boolean logged = new StudentController(MainActivity.this).login(username.getText().toString(), password.getText().toString());
                if (logged) {
                    startActivity(new Intent(getApplicationContext(), ActivityCourses.class));
                } else {
                    Snackbar.make(activity, "Error in username or password", Snackbar.LENGTH_LONG).show();
                }

            }else {
                Snackbar.make(activity, "Don't Forget Any Field", Snackbar.LENGTH_LONG).show();
            }

        });

    }
}
