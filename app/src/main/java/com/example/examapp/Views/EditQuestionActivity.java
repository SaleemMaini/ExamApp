package com.example.examapp.Views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.examapp.Model.Data_Question;
import com.example.examapp.R;
import com.example.examapp.helper.DatabaseHelper1;

public class EditQuestionActivity extends AppCompatActivity {
    private Button btnEditDialog,btnEditDialog1,btnEditDialog2,btnEditDialog3,btnsv;
    private EditText Qtxt,Mark;
    private RadioButton RR1, RR2, RR3, RR4;
    private Spinner spinnerCourses;
    private DatabaseHelper1 databaseHelper1;
    Data_Question QuestionInfo;
    private EditText questionText,questionMark;
    int position;
    String str_position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_question);
        databaseHelper1 = new DatabaseHelper1(this);

        Qtxt = findViewById(R.id.QuestiontxtEdit);
        Mark = findViewById(R.id.textMarkEdit);
        btnEditDialog = findViewById(R.id.E1Edit);
        btnEditDialog1 = findViewById(R.id.E2Edit);
        btnEditDialog2 = findViewById(R.id.E3Edit);
        btnEditDialog3 = findViewById(R.id.E4Edit);
        RR1 = findViewById(R.id.radioButton1Edit);
        RR2 = findViewById(R.id.radioButton2Edit);
        RR3 = findViewById(R.id.radioButton3Edit);
        RR4 = findViewById(R.id.radioButton4Edit);
        spinnerCourses = findViewById(R.id.spinnerCoursesEdit);
        btnsv = findViewById(R.id.buttonsv);

        Bundle bundle = getIntent().getExtras();
        str_position = bundle.getString("position" ) ;
        position = Integer.parseInt(str_position) ;
        databaseHelper1 = new DatabaseHelper1(this);
        QuestionInfo = databaseHelper1.getData(position) ;

        if(QuestionInfo != null){
            Qtxt.setText(QuestionInfo.getText());
            int id_answer = QuestionInfo.getId_answer();
            if (id_answer == 1) {
                RR1.setChecked(true);
            }
            if (id_answer == 2){
                RR2.setChecked(true);
            }
            if(id_answer == 3){
                RR3.setChecked(true);
            }
            if(id_answer == 4){
                RR4.setChecked(true);
            }
            Mark.setText(Integer.toString(QuestionInfo.getMark()));
            int id_course = QuestionInfo.getId_course();
            if (id_course == 0) {
                spinnerCourses.setSelection(0);
            }
            if (id_course == 1){
                spinnerCourses.setSelection(1);
            }
            if(id_course == 2){
                spinnerCourses.setSelection(2);
            }
            if(id_course == 3){
                spinnerCourses.setSelection(3);
            }
        }


        btnEditDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ViewGroup viewGroup = findViewById(R.id.LinearLayoutEdit);

                EditText editText1;
                Button btn1;

                AlertDialog.Builder builder = new AlertDialog.Builder(EditQuestionActivity.this);
                View view1 = LayoutInflater.from(EditQuestionActivity.this).inflate(R.layout.aleredittxml, viewGroup, false);
                builder.setCancelable(false);
                builder.setView(view1);

                editText1 = view1.findViewById(R.id.txt_edit);
                btn1 = view1.findViewById(R.id.btn_edit);



                AlertDialog alertDialog = builder.create();

                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(EditQuestionActivity.this, "Done", Toast.LENGTH_LONG).show();
                        RR1.setText(editText1.getText());
                        alertDialog.hide();

                    }
                });

                alertDialog.show();
            }
        });

        btnEditDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ViewGroup viewGroup = findViewById(R.id.LinearLayoutEdit);

                EditText editText1;
                Button btn1;

                RadioButton RR2;

                AlertDialog.Builder builder = new AlertDialog.Builder(EditQuestionActivity.this);
                View view1 = LayoutInflater.from(EditQuestionActivity.this).inflate(R.layout.aleredittxml, viewGroup, false);
                builder.setCancelable(false);
                builder.setView(view1);

                editText1 = view1.findViewById(R.id.txt_edit);
                btn1 = view1.findViewById(R.id.btn_edit);

                RR2 = findViewById(R.id.radioButton2);

                AlertDialog alertDialog = builder.create();

                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(EditQuestionActivity.this, "Done", Toast.LENGTH_LONG).show();
                        RR2.setText(editText1.getText());
                        alertDialog.hide();

                    }
                });

                alertDialog.show();
            }
        });

        btnEditDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ViewGroup viewGroup = findViewById(R.id.LinearLayoutEdit);

                EditText editText1;
                Button btn1;

                RadioButton RR3;

                AlertDialog.Builder builder = new AlertDialog.Builder(EditQuestionActivity.this);
                View view1 = LayoutInflater.from(EditQuestionActivity.this).inflate(R.layout.aleredittxml, viewGroup, false);
                builder.setCancelable(false);
                builder.setView(view1);

                editText1 = view1.findViewById(R.id.txt_edit);
                btn1 = view1.findViewById(R.id.btn_edit);

                RR3 = findViewById(R.id.radioButton3);

                AlertDialog alertDialog = builder.create();

                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(EditQuestionActivity.this, "Done", Toast.LENGTH_LONG).show();
                        RR3.setText(editText1.getText());
                        alertDialog.hide();

                    }
                });

                alertDialog.show();
            }
        });

        btnEditDialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ViewGroup viewGroup = findViewById(R.id.LinearLayoutEdit);

                EditText editText1;
                Button btn1;

                RadioButton RR4;

                AlertDialog.Builder builder = new AlertDialog.Builder(EditQuestionActivity.this);
                View view1 = LayoutInflater.from(EditQuestionActivity.this).inflate(R.layout.aleredittxml, viewGroup, false);
                builder.setCancelable(false);
                builder.setView(view1);

                editText1 = view1.findViewById(R.id.txt_edit);
                btn1 = view1.findViewById(R.id.btn_edit);

                RR4 = findViewById(R.id.radioButton4);

                AlertDialog alertDialog = builder.create();

                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(EditQuestionActivity.this, "Done", Toast.LENGTH_LONG).show();
                        RR4.setText(editText1.getText());
                        alertDialog.hide();

                    }
                });

                alertDialog.show();
            }
        });

        btnsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Qtxt = findViewById(R.id.Questiontxt);
//                textMark = findViewById(R.id.textMark);
//                String Qustion = Qtxt.getText().toString();
//                int RB = 0;
//                int mark =  Integer.parseInt(String.valueOf(textMark.getText()));
//                int id_course = spinnerCourses.getSelectedItemPosition();
//
//                RadioButton RR1,RR2,RR3,RR4;
//                RR1 = findViewById(R.id.radioButton1);
//                RR2 = findViewById(R.id.radioButton3);
//                RR3 = findViewById(R.id.radioButton2);
//                RR4 = findViewById(R.id.radioButton4);
//                if(RR1.isChecked()){ RB = 1; }
//                if(RR2.isChecked()){ RB = 2; }
//                if(RR3.isChecked()){ RB = 3; }
//                if(RR4.isChecked()){ RB = 4; }
////                if(RR3.isChecked()){ RB = RR4.getText().toString(); }
//
//                Data_Question DQ = new Data_Question();
//
//                ContentValues values = new ContentValues();
//                values.put("text", Qustion);
////                values.put("id_answer", RB);
//                values.put("mark", mark);
//                values.put("id_course", mark);
//                String whereArgs[] = {"" + DQ.getId()};
//                long updeted = new QuestionController(ActivityQuestionAddOrModify.this).updateData("question",values,Qustion,whereArgs);
//                if (updeted > 0) {
//                    Qtxt.setText("");
//                    textMark.setText("");
//                    RR1.setText("........................");
//                    RR2.setText("........................");
//                    RR3.setText("........................");
//                    RR4.setText("........................");
//                    Snackbar.make(findViewById(R.id.ConstraintLayout1), "Added successfully", Snackbar.LENGTH_LONG).show();
//                    Intent intent = new Intent(ActivityQuestionAddOrModify.this,ActivityQuestionMangment.class);
//                    startActivity(intent);
//                    finish();}

//                questionText = findViewById(R.id.Questiontxt);
//                String qt = questionText.getText().toString();
//                questionMark = findViewById(R.id.textMark);
                int RBEdit = 0;
                if (RR1.isChecked()) {
                    RBEdit = 1;
                }
                if (RR2.isChecked()) {
                    RBEdit = 2;
                }
                if (RR3.isChecked()) {
                    RBEdit = 3;
                }
                if (RR4.isChecked()) {
                    RBEdit = 4;
                }
                int new_id_course = spinnerCourses.getSelectedItemPosition();
                QuestionInfo.setText(Qtxt.getText().toString());
                QuestionInfo.setId_answer(RBEdit);
                QuestionInfo.setMark(Integer.parseInt(questionMark.getText().toString()));
                QuestionInfo.setId_course(new_id_course);

                databaseHelper1.updateDataToQuestion(QuestionInfo);
                Course1.notifyAdapter();
//                Course2.notifyAdapter();
//                Course3.notifyAdapter();
//                Course4.notifyAdapter();

                Intent intent = new Intent(EditQuestionActivity.this,ActivityQuestionMangment.class);
                startActivity(intent);
                finish();
            }
        });




        // Spinner Courses
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,R.array.courses, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCourses.setAdapter(spinnerAdapter);

        spinnerCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnerCourses.setSelection(0);
            }
        });

    }
    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("text")
            && getIntent().hasExtra("id_answer") && getIntent().hasExtra("mark")
            && getIntent().hasExtra("id_course")){

        }
    }
}