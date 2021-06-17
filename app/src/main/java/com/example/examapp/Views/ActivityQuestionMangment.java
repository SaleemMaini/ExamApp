package com.example.examapp.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.examapp.Controller.PagerAdapter;
import com.example.examapp.Controller.RecyclerViewAdapter;
import com.example.examapp.R;

import com.example.examapp.helper.DatabaseHelper1;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class ActivityQuestionMangment extends AppCompatActivity {
    FloatingActionButton addQuestionFab;
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
        setContentView(R.layout.activity_question_mangment);




        TabLayout tabLayout = findViewById(R.id.tabBar);
        TabItem Course1 = findViewById(R.id.Course1);
        TabItem Course2 = findViewById(R.id.Course2);
        TabItem Course3 = findViewById(R.id.Course3);
        TabItem Course4 = findViewById(R.id.Course4);
        PagerAdapter pagerAdapter;
        ViewPager2 viewPager = findViewById(R.id.viewPager);
        pagerAdapter = new com.example.examapp.Controller.PagerAdapter(getSupportFragmentManager(),
                getLifecycle());

        viewPager.setAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));}
        });

        //      addQuestionFab
        addQuestionFab =findViewById(R.id.addQuestionFab);
        addQuestionFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityQuestionMangment.this, AddQuestionActivity.class);
//                intent.putExtra("position",String.valueOf(data.getId()));
                startActivity(intent);
                finish();
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