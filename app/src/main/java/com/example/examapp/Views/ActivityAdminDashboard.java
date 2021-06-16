package com.example.examapp.Views;

import androidx.appcompat.app.AppCompatActivity;
import com.example.examapp.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityAdminDashboard extends AppCompatActivity {
    Button questionManagementBtn,viewStudentMarksBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        questionManagementBtn = findViewById(R.id.questionManagementBtn);
        viewStudentMarksBtn = findViewById(R.id.viewStudentMarksBtn);

        questionManagementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ActivityQuestionMangment.class));
            }
        });
        viewStudentMarksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddQuestionActivity.class));
            }
        });
    }
}