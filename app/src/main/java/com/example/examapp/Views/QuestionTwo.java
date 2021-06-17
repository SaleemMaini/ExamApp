package com.example.examapp.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.example.examapp.R;

public class QuestionTwo extends AppCompatActivity {
    //    Theme
    SharedPreferences app_preferences;
    int appTheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //      Start  Set Theme
        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        appTheme = app_preferences.getInt("theme", 0);
        setTheme(appTheme);
//        End set Theme
        setContentView(R.layout.activity_question_two);
    }
}