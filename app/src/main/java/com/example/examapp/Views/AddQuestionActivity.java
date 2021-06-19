package com.example.examapp.Views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
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

//import com.example.examapp.Controller.QuestionController;
import com.example.examapp.Model.Data_Answer;
import com.example.examapp.Model.Data_Question;
import com.example.examapp.R;
import com.example.examapp.helper.DatabaseHelper1;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class AddQuestionActivity extends AppCompatActivity {
    Button btnEditDialog,btnEditDialog1,btnEditDialog2,btnEditDialog3,btnadd;
    EditText Qtxt,Mark;
    RadioButton RR1, RR2, RR3, RR4;
    Spinner spinnerCourses;
    DatabaseHelper1 databaseHelper1;
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
        setContentView(R.layout.activity_add_question);

        databaseHelper1 = new DatabaseHelper1(this);
        Qtxt = findViewById(R.id.Questiontxt);
        Mark = findViewById(R.id.textMark);
        btnEditDialog = findViewById(R.id.E1);
        btnEditDialog1 = findViewById(R.id.E2);
        btnEditDialog2 = findViewById(R.id.E3);
        btnEditDialog3 = findViewById(R.id.E4);
        RR1 = findViewById(R.id.radioButton1);
        RR2 = findViewById(R.id.radioButton2);
        RR3 = findViewById(R.id.radioButton3);
        RR4 = findViewById(R.id.radioButton4);
        spinnerCourses = findViewById(R.id.spinnerCourses);
        btnadd = findViewById(R.id.buttonadd);

        btnEditDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ViewGroup viewGroup = findViewById(R.id.LinearLayoutEdit);

                EditText editText1;
                Button btn1;

                AlertDialog.Builder builder = new AlertDialog.Builder(AddQuestionActivity.this);
                View view1 = LayoutInflater.from(AddQuestionActivity.this).inflate(R.layout.aleredittxml, viewGroup, false);
                builder.setCancelable(false);
                builder.setView(view1);

                editText1 = view1.findViewById(R.id.txt_edit);
                btn1 = view1.findViewById(R.id.btn_edit);



                AlertDialog alertDialog = builder.create();

                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(AddQuestionActivity.this, "Done", Toast.LENGTH_LONG).show();
                        RR1.setText(editText1.getText());
                        alertDialog.cancel();

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

                AlertDialog.Builder builder = new AlertDialog.Builder(AddQuestionActivity.this);
                View view1 = LayoutInflater.from(AddQuestionActivity.this).inflate(R.layout.aleredittxml, viewGroup, false);
                builder.setCancelable(false);
                builder.setView(view1);

                editText1 = view1.findViewById(R.id.txt_edit);
                btn1 = view1.findViewById(R.id.btn_edit);

                RR2 = findViewById(R.id.radioButton2);

                AlertDialog alertDialog2 = builder.create();

                alertDialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(AddQuestionActivity.this, "Done", Toast.LENGTH_LONG).show();
                        RR2.setText(editText1.getText());
                        alertDialog2.cancel();

                    }
                });

                alertDialog2.show();
            }
        });

        btnEditDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ViewGroup viewGroup = findViewById(R.id.LinearLayoutEdit);

                EditText editText1;
                Button btn1;

                RadioButton RR3;

                AlertDialog.Builder builder = new AlertDialog.Builder(AddQuestionActivity.this);
                View view1 = LayoutInflater.from(AddQuestionActivity.this).inflate(R.layout.aleredittxml, viewGroup, false);
                builder.setCancelable(false);
                builder.setView(view1);

                editText1 = view1.findViewById(R.id.txt_edit);
                btn1 = view1.findViewById(R.id.btn_edit);

                RR3 = findViewById(R.id.radioButton3);

                AlertDialog alertDialog3 = builder.create();

                alertDialog3.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(AddQuestionActivity.this, "Done", Toast.LENGTH_LONG).show();
                        RR3.setText(editText1.getText());
                        alertDialog3.cancel();

                    }
                });

                alertDialog3.show();
            }
        });

        btnEditDialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ViewGroup viewGroup = findViewById(R.id.LinearLayoutEdit);

                EditText editText1;
                Button btn1;

                RadioButton RR4;

                AlertDialog.Builder builder = new AlertDialog.Builder(AddQuestionActivity.this);
                View view1 = LayoutInflater.from(AddQuestionActivity.this).inflate(R.layout.aleredittxml, viewGroup, false);
                builder.setCancelable(false);
                builder.setView(view1);

                editText1 = view1.findViewById(R.id.txt_edit);
                btn1 = view1.findViewById(R.id.btn_edit);

                RR4 = findViewById(R.id.radioButton4);

                AlertDialog alertDialog4 = builder.create();

                alertDialog4.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(AddQuestionActivity.this, "Done", Toast.LENGTH_LONG).show();
                        RR4.setText(editText1.getText());
                        alertDialog4.cancel();

                    }
                });

                alertDialog4.show();
            }
        });
        final MediaPlayer addSound = MediaPlayer.create(this,R.raw.add);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data_Answer data_answer1 = new Data_Answer();
                Data_Answer data_answer2 = new Data_Answer();
                Data_Answer data_answer3 = new Data_Answer();
                Data_Answer data_answer4 = new Data_Answer();

                String Qustion = Qtxt.getText().toString();
                int RB = 0;
                if (RR1.isChecked()) {
                    RB = 1;
                    data_answer1.setStatus(1);
                }
                if (RR2.isChecked()) {
                    RB = 2;
                    data_answer2.setStatus(1);
                }
                if (RR3.isChecked()) {
                    RB = 3;
                    data_answer3.setStatus(1);
                }
                if (RR4.isChecked()) {
                    RB = 4;
                    data_answer4.setStatus(1);
                }
                data_answer1.setText(RR1.getText().toString());
                data_answer2.setText(RR2.getText().toString());
                data_answer3.setText(RR3.getText().toString());
                data_answer4.setText(RR4.getText().toString());

                int questionId = databaseHelper1.getLastIdOfQuestion() + 1; // get last id +1 From Question Table
                data_answer1.setId_question(questionId);
                data_answer2.setId_question(questionId);
                data_answer3.setId_question(questionId);
                data_answer4.setId_question(questionId);
                databaseHelper1.insertDataToAnswer(data_answer1);
                databaseHelper1.insertDataToAnswer(data_answer2);
                databaseHelper1.insertDataToAnswer(data_answer3);
                databaseHelper1.insertDataToAnswer(data_answer4);
                String txtMark = Mark.getText().toString();
                int idCourse = spinnerCourses.getSelectedItemPosition();


                Data_Question DQ = new Data_Question();
                DQ.setText(Qustion);
                DQ.setId_answer(RB);
                DQ.setMark(Integer.parseInt(txtMark));
                DQ.setId_course(idCourse);
                long inserted = new DatabaseHelper1(getApplicationContext()).insertDataToQuestion(DQ);


                if (inserted > 0) {
                    Qtxt.setText("");
                    Mark.setText("");
                    RR1.setText("........................");
                    RR2.setText("........................");
                    RR3.setText("........................");
                    RR4.setText("........................");
                    Snackbar.make(findViewById(R.id.ConstraintLayout1), "Added successfully", Snackbar.LENGTH_LONG).show();
                    Intent intent = new Intent(AddQuestionActivity.this, ActivityQuestionMangment.class);
                    startActivity(intent);
                    finish();
                }
                addSound.start();
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
}