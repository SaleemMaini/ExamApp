package com.example.examapp.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examapp.Model.Constant;
import com.example.examapp.Model.Utils;
import com.example.examapp.R;

public class SettingActivity extends AppCompatActivity {
//    Theme
    SharedPreferences sharedPreferences, app_preferences;
    SharedPreferences.Editor editor;
    Utils utils;
    int appTheme;

    Switch switchMute;
    TextView tv;
    int switchStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //      Start  Set Theme
        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        appTheme = app_preferences.getInt("theme", 0);
        setTheme(appTheme);

        //        End set Theme

        // Mute Status
        switchStatus = app_preferences.getInt("muteSwitch",0);
        setContentView(R.layout.activity_setting);
        switchMute = findViewById(R.id.switchMute);
        if (switchStatus == 1) {
            switchMute.setChecked(true);
        }




        utils = new Utils();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();




//        Mute Sound
        switchMute.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                    amanager.setStreamMute(AudioManager.STREAM_MUSIC, true);
                    editor.putInt("muteSwitch", 1);
                    editor.commit();
                }
                else {
                    AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                    amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);
                    editor.putInt("muteSwitch", 0);
                    editor.commit();
                }
            }
        });
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