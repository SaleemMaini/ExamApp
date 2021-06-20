package com.example.examapp.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.examapp.Controller.ExamReportAdapter;
import com.example.examapp.Controller.RecyclerViewAdapter;
import com.example.examapp.R;
import com.example.examapp.helper.DatabaseHelper1;

public class ExamReportActivity extends AppCompatActivity {

    RecyclerView examReportRv;
    public static ExamReportAdapter ExamRecyclerViewAdapter;
    DatabaseHelper1 databaseHelper2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_report);
        //Recycler
        examReportRv = findViewById(R.id.examReportRv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        examReportRv.setLayoutManager(llm);
        examReportRv.setItemAnimator(new DefaultItemAnimator());
        examReportRv.setHasFixedSize(true);

        //Adapter
        databaseHelper2 = new DatabaseHelper1(this);
        ExamRecyclerViewAdapter = new ExamReportAdapter(this,databaseHelper2.getAllExamData(),databaseHelper2);
        examReportRv.setAdapter(ExamRecyclerViewAdapter);



    }
}