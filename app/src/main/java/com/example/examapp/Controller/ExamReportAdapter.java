package com.example.examapp.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examapp.Model.Data_Exam;
import com.example.examapp.Model.Data_Question;
import com.example.examapp.R;
import com.example.examapp.helper.DatabaseHelper1;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ExamReportAdapter extends RecyclerView.Adapter<ExamReportAdapter.ExamViewHolder> {

    private Context context;
    private List<Data_Exam> exam_List;
    private DatabaseHelper1 DBH;


    public ExamReportAdapter(Context context, List<Data_Exam> examList, DatabaseHelper1 DBH) {
        this.context = context;
        exam_List = examList;
        this.DBH = DBH;
    }

    @NonNull
    @NotNull
    @Override
    public ExamReportAdapter.ExamViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exam_item,parent,false);
        return new ExamViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ExamViewHolder holder, int position) {
        final Data_Exam data = exam_List.get(position);
        holder.nameStudent.setText(data.getNamestudent());
        holder.courseName.setText(data.getNamecourse());
        holder.examMark.setText("Mark: " + data.getMark());
    }

    @Override
    public int getItemCount() {
        return exam_List.size();
    }

    public class ExamViewHolder extends RecyclerView.ViewHolder {
        public TextView nameStudent,courseName,examMark;
        public ExamViewHolder(@NonNull View v) {
            super(v);
            nameStudent = v.findViewById(R.id.studentName);
            courseName = v.findViewById(R.id.courseName);
            examMark = v.findViewById(R.id.examMark);
        }
    }
}
