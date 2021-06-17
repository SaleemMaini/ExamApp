package com.example.examapp.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import com.example.examapp.Model.Constant;
import com.example.examapp.Model.Utils;
import com.example.examapp.R;

public class SettingActivity extends AppCompatActivity {
//    Theme
    SharedPreferences sharedPreferences, app_preferences;
    SharedPreferences.Editor editor;
    Utils utils;
    int appTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      Start  Set Theme
        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        appTheme = app_preferences.getInt("theme", 0);
        setTheme(appTheme);
//        End set Theme
        setContentView(R.layout.activity_setting);
        utils = new Utils();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }
    public void onClick(View v){
        utils.setColorTheme(v);

        editor.putInt("theme",Constant.theme);
        editor.commit();

        Intent intent = new Intent(SettingActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}