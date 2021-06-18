package com.example.examapp.Views;

import androidx.appcompat.app.AppCompatActivity;
import com.example.examapp.R;
import com.example.examapp.helper.DatabaseHelper1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result_Score extends AppCompatActivity {
    private int mark;
    private  String nameStudent;
    TextView textViewResult;
    Button btnOk;
    private DatabaseHelper1 databaseHelperResult;

    SharedPreferences app_preferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        nameStudent = app_preferences.getString("user_Name_Student","");

        setContentView(R.layout.activity_result__score);

        Bundle bundle = getIntent().getExtras();
//        str_position = bundle.getInt("Selected Course Id") ;
        mark = bundle.getInt("Score") ;
        nameStudent = bundle.getString("Name_Student");


        textViewResult = findViewById(R.id.textViewResult);
        textViewResult.setText( nameStudent + " Your mark of exam \n is \n" + mark  );

        btnOk = findViewById(R.id.OK);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}