package com.example.examapp.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examapp.Model.Data_Question;
import com.example.examapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    List<Data_Question> questionList;

    public RecyclerViewAdapter(Context context, List<Data_Question> questionList) {
        this.context = context;
        this.questionList = new ArrayList<Data_Question>(questionList);
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.questionText.setText((questionList.get(position).getText()));
        holder.questionMark.setText((questionList.get(position).getMark() + ""));
    }


    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView questionText,questionAnswerId,questionMark;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            questionText =  (TextView) itemView.findViewById(R.id.questionId);
            questionMark =  (TextView) itemView.findViewById(R.id.questionMark);

        }
    }


}
