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
import com.example.examapp.Views.ActivityQuestionAddOrModify;
import com.example.examapp.Views.ActivityQuestionMangment;
import com.example.examapp.Views.Course1;
import com.example.examapp.Views.Course2;
import com.example.examapp.Views.Course3;
import com.example.examapp.Views.Course4;
import com.example.examapp.helper.DatabaseHelper;
import com.example.examapp.helper.DatabaseHelper1;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Button btnEdit;
    Context context;
    List<Data_Question> questionList;
    DatabaseHelper1 DBH;

    public RecyclerViewAdapter(Context context, List<Data_Question> allData) {
        this.context = context;
//        this.questionList = new ArrayList<Data_Question>(questionList);
        this.questionList = allData;
    }

    public RecyclerViewAdapter(Context context, List<Data_Question> questionList, DatabaseHelper1 DBH) {
        this.context = context;
        this.questionList = questionList;
        this.DBH = DBH;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Data_Question data = questionList.get(position);
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
                //Toast.makeText(context,String.valueOf(questionList.g),Toast.LENGTH_LONG).show();
//                btnEdit.findViewById(R.id.questionEditBtn);
                Intent intent = new Intent(context, ActivityQuestionAddOrModify.class);
                intent.putExtra("position",String.valueOf(position));
                context.startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView questionText,questionAnswerId,questionMark;
        public Button delete, edit;
        public MyViewHolder(@NonNull View v) {
            super(v);
            questionText =  (TextView) v.findViewById(R.id.questionText);
            questionMark =  (TextView) v.findViewById(R.id.questionMark);
            delete = v.findViewById(R.id.questionDeleteBtn);
            edit = v.findViewById(R.id.questionEditBtn);

        }
    }
    public void deleteData(int position){
        DBH.deleteDataFromQuestion(questionList.get(position));
        questionList.remove(position);
        Course1.notifyAdapter();
        Course2.notifyAdapter();
        Course3.notifyAdapter();
        Course4.notifyAdapter();
    }


}
