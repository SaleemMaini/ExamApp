package com.example.examapp.Views;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examapp.Model.Data_Exam;
import com.example.examapp.Model.Data_Question;
import com.example.examapp.R;
import com.example.examapp.helper.DatabaseHelper1;
import com.google.android.material.snackbar.Snackbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result_Score extends AppCompatActivity {
    private int mark;
    private  String Student;
    private int idCourse;
    TextView textViewResult;
    Button btnOk;
    private DatabaseHelper1 databaseHelperResult;

    SharedPreferences app_preferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
//        nameStudent = app_preferences.getString("user_Name_Student","");

        setContentView(R.layout.activity_result__score);

        Bundle bundle = getIntent().getExtras();
//        str_position = bundle.getInt("Selected Course Id") ;
        mark = bundle.getInt("Score") ;
        Student = bundle.getString("Id_Student");
        idCourse = bundle.getInt("Course_Id");


        textViewResult = findViewById(R.id.textViewResult);
        textViewResult.setText( Student + " Your mark of exam \n is \n" + mark + "" + idCourse );

        btnOk = findViewById(R.id.OK);
        final MediaPlayer addSound = MediaPlayer.create(this,R.raw.add);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Data_Exam DQ = new Data_Exam();
//                DQ.setStudent_id(idStudent);
//                DQ.setMark(mark);
//                DQ.setCourse_id(idCourse);
//                long inserted = new DatabaseHelper1(getApplicationContext()).insertDataToExam(DQ);
//
//                if (inserted > 0) {
//                    Snackbar.make(findViewById(R.id.ScrollResult), "Doned successfully", Snackbar.LENGTH_LONG).show();
//                    Intent intent = new Intent(Result_Score.this, ActivityCourses.class);
//                    startActivity(intent);
//                    finish();
//                }
                addSound.start();
            }
        });
    }
}