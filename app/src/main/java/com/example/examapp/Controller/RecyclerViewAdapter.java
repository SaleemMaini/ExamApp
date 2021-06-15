package com.example.examapp.Controller;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examapp.Model.Data_Question;
import com.example.examapp.Model.Data_Student;
import com.example.examapp.R;
import com.example.examapp.Views.ActivityQuestionMangment;
import com.example.examapp.Views.Course1;
import com.example.examapp.Views.Course2;
import com.example.examapp.Views.Course3;
import com.example.examapp.Views.Course4;
import com.example.examapp.Views.EditQuestionActivity;
import com.example.examapp.helper.DatabaseHelper1;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context context;
    private List<Data_Question> question_List;
    private DatabaseHelper1 DBH;

    public RecyclerViewAdapter(Context context, List<Data_Question> allData) {
        this.context = context;
        this.question_List = allData;
    }

    public RecyclerViewAdapter(Context context, List<Data_Question> questionList, DatabaseHelper1 DBH) {
        this.context = context;
        question_List = questionList;
        this.DBH = DBH;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final Data_Question data = question_List.get(position);
        holder.questionText.setText(data.getText());
        holder.questionMark.setText("Mark : " + data.getMark());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData(position);
            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,String.valueOf(data.getId()),Toast.LENGTH_LONG).show();

                Intent intent = new Intent(context, EditQuestionActivity.class);
                intent.putExtra("position",String.valueOf(data.getId()));
                context.startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return question_List.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView questionText,questionMark;
        public Button delete, edit;
        public MyViewHolder(@NonNull View v) {
            super(v);
            questionText = v.findViewById(R.id.questionText);
            questionMark = v.findViewById(R.id.questionMark);
            delete = v.findViewById(R.id.questionDeleteBtn);
            edit = v.findViewById(R.id.questionEditBtn);

        }
    }
    public void deleteData(int position){
        DBH.deleteDataFromQuestion(question_List.get(position));
        question_List.remove(position);
//        ActivityQuestionMangment.notifyAdapter();
        Course1.notifyAdapter();
        Course2.notifyAdapter();
        Course3.notifyAdapter();
        Course4.notifyAdapter();
    }
}
