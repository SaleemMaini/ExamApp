package com.example.examapp.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.examapp.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ActivityCourses extends AppCompatActivity {
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
        setContentView(R.layout.activity_courses);

        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        findViewById(R.id.button10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
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