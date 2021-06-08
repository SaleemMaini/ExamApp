package com.example.examapp.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.examapp.Controller.AdminController;
import com.example.examapp.Controller.StudentController;
import com.example.examapp.Controller.CourseController;
import com.example.examapp.R;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    EditText username;
    EditText password;
    Button login;
    View activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password = findViewById(R.id.editTextTextPassword2);
        username = findViewById(R.id.editTextTextPersonName2);
        login = findViewById(R.id.log);
        activity = findViewById(R.id.activity);

        try {
            new AdminController(this).create();
            new CourseController(this).create();
            new StudentController(this).create();


            ContentValues values1 = new ContentValues();
            values1.put("username", "admin");
            values1.put("password", "admin");
            new AdminController(this).insert(values1);

            ContentValues values2 = new ContentValues();
            values2.put("username", "student");
            values2.put("password", "student");
            new StudentController(this).insert(values2);
        } catch (Exception e) {
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getText().toString().isEmpty() || username.getText().toString().isEmpty()) {
                    Snackbar.make(activity, "Username or password not found", Snackbar.LENGTH_LONG).show();

                } else if (username.getText().toString().toLowerCase().equals("admin")) {

                    boolean logged = new AdminController(MainActivity.this).login(username.getText().toString(), password.getText().toString());
                    if (logged) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    } else {
                        Snackbar.make(activity, "Error in username or password", Snackbar.LENGTH_LONG).show();
                    }

                } else if (username.getText().toString().toLowerCase().equals("student")) {

                    boolean logged = new StudentController(MainActivity.this).login(username.getText().toString(), password.getText().toString());
                    if (logged) {
                        startActivity(new Intent(getApplicationContext(), activity_courses.class));
                    } else {
                        Snackbar.make(activity, "Error in username or password", Snackbar.LENGTH_LONG).show();
                    }

                }

            }
        });

    }
}