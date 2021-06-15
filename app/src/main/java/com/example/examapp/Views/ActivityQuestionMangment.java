package com.example.examapp.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.examapp.Controller.PagerAdapter;
import com.example.examapp.Controller.RecyclerViewAdapter;
import com.example.examapp.R;
import com.example.examapp.helper.DatabaseHelper;
import com.example.examapp.helper.DatabaseHelper1;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class ActivityQuestionMangment extends AppCompatActivity {
    FloatingActionButton addQuestionFab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                startActivity(intent);
                finish();
            }
        });

    }

}