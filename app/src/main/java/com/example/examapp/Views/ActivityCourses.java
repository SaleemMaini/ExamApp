package com.example.examapp.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.examapp.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ActivityCourses extends AppCompatActivity {
    //    Theme
    SharedPreferences app_preferences;
    int appTheme;

    String nameStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      Start  Set Theme
        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        appTheme = app_preferences.getInt("theme", 0);
        setTheme(appTheme);
//        End set Theme
        setContentView(R.layout.activity_courses);

        Bundle bundle = getIntent().getExtras();
        nameStudent = bundle.getString("Selected_Student_Id") ;

    }

    // Start Setting Icon //
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
    // End Setting Icon //

    // Start Exam //
    public void startExam(View v){
        int selectedCourse = v.getId();
        Intent i = new Intent(ActivityCourses.this,ExamActivity.class);
        i.putExtra("Selected_Course_Id", selectedCourse);
        i.putExtra("Selected_Student", nameStudent);
        startActivity(i);
    }

}