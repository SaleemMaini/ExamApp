package com.example.examapp.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import com.example.examapp.R;

public class ExamActivity extends AppCompatActivity {
    Button nextBtnQuestion1, prvBtnQuestion1;
//    Theme
    SharedPreferences app_preferences;
    int appTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Start  Set Theme
        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        appTheme = app_preferences.getInt("theme", 0);
        setTheme(appTheme);
//        End set Theme
        setContentView(R.layout.activity_exam);

//        Next Btn
        AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);

        nextBtnQuestion1 = findViewById(R.id.nextBtnQuestion1);
        final MediaPlayer nextSound = MediaPlayer.create(this,R.raw.next);

        nextBtnQuestion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextSound.start();
            }
        });

//       Previous Btn
        prvBtnQuestion1 = findViewById(R.id.prvBtnQuestion1);
        final MediaPlayer previousSound = MediaPlayer.create(this,R.raw.previous);
        prvBtnQuestion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousSound.start();


            }
        });


    }
}