package com.example.examapp.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//import com.example.examapp.Controller.AdminController;
//import com.example.examapp.Controller.QuestionController;
//import com.example.examapp.Controller.StudentController;
//import com.example.examapp.Controller.CourseController;
import com.example.examapp.Model.Constant;
import com.example.examapp.Model.Data_Admin;
import com.example.examapp.Model.Data_Question;
import com.example.examapp.Model.Data_Student;
import com.example.examapp.Model.Utils;
import com.example.examapp.R;
import com.example.examapp.helper.DatabaseHelper1;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    View activity;
    DatabaseHelper1 databaseHelper1;
//    theme
    SharedPreferences app_preferences;
    SharedPreferences.Editor editor;

    int appTheme;
    Utils utils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      Start  Set Theme
        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        appTheme = app_preferences.getInt("theme", 0);
        setTheme(appTheme);
        // data
        int x = app_preferences.getInt("data_is_inserted",0);
        if (x==1) {Constant.insertDataToDb=1;} else {Constant.insertDataToDb=0;}
        setContentView(R.layout.activity_main);

        password = findViewById(R.id.password);
        username = findViewById(R.id.username);
        login = findViewById(R.id.OK);
        activity = findViewById(R.id.activity);
        databaseHelper1 = new DatabaseHelper1(this);
        utils = new Utils(this);
        editor = app_preferences.edit();
        // Insert Data to DB
        if(Constant.insertDataToDb == 0) {
            Data_Admin valuesAdm = new Data_Admin();
            valuesAdm.setName("mahmoud");
            valuesAdm.setUsername("admin");
            valuesAdm.setPassword("admin");
            new DatabaseHelper1(this).insertDataToAdmin(valuesAdm);
            Data_Student valuesStd = new Data_Student();
            valuesStd.setName("saleem");
            valuesStd.setUsername("student");
            valuesStd.setPassword("student");
            new DatabaseHelper1(this).insertDataToStudent(valuesStd);
            utils.insertFiveQuestionToCourseOne();
            utils.insertFiveQuestionToCourseTwo();
            utils.insertFiveQuestionToCourseThree();
            utils.insertFiveQuestionToCourseFour();
            editor.putInt("data_is_inserted" , 1);
            editor.commit();
        }



        // Login Sound
        final MediaPlayer enterPageSound = MediaPlayer.create(this,R.raw.enterpage);



        // Login Check
        login.setOnClickListener(v -> {
            if (password.getText().toString().isEmpty() || username.getText().toString().isEmpty()) {
                Snackbar.make(activity, "Username or password not found", Snackbar.LENGTH_LONG).show();
            } else if (username.getText().toString().toLowerCase().equals("admin")) {

                boolean logged = new DatabaseHelper1(MainActivity.this).login_admin(username.getText().toString(),
                        password.getText().toString());
                if (logged) {
                    enterPageSound.start();
                    startActivity(new Intent(getApplicationContext(), ActivityAdminDashboard.class));
                } else {
                    Snackbar.make(activity, "Error in username or password", Snackbar.LENGTH_LONG).show();
                }

            } else if (username.getText().toString().toLowerCase().equals("student")) {

                boolean logged = new DatabaseHelper1(MainActivity.this).login_student(username.getText().toString(),
                        password.getText().toString());
                if (logged) {
                    enterPageSound.start();
                    String selectedStudent = username.getText().toString();
                    Intent i = new Intent(getApplicationContext(), ActivityCourses.class);
                    i.putExtra("Selected_Student_Id", selectedStudent);
                    startActivity(i);
                } else {
                    Snackbar.make(activity, "Error in username or password", Snackbar.LENGTH_LONG).show();
                }

            }else {
                Snackbar.make(activity, "Don't Forget Any Field", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settingMenu)
        {
            startActivity(new Intent(getApplicationContext(), SettingActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
