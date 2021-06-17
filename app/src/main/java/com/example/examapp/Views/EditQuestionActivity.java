package com.example.examapp.Views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

import java.util.List;

public class EditQuestionActivity extends AppCompatActivity {
    private Button btnEditDialog,btnEditDialog1,btnEditDialog2,btnEditDialog3,btnsv;
    private EditText Qtxt,Mark;
    private RadioButton RR1, RR2, RR3, RR4;
    private DatabaseHelper1 databaseHelper1;
//    private QuestionController questionController;
    Data_Question QuestionInfo;
    private EditText questionText,questionMark;
    int position;
    String str_position;
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
        setContentView(R.layout.activity_edit_question);

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
        btnsv = findViewById(R.id.buttonsv);

        Bundle bundle = getIntent().getExtras();
        str_position = bundle.getString("position" ) ;
        position = Integer.parseInt(str_position) ;
        databaseHelper1 = new DatabaseHelper1(this);
        QuestionInfo = databaseHelper1.getQuestionId(position) ;


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
            Mark.setText(String.valueOf(QuestionInfo.getMark()));
            List<Data_Answer> dataA = databaseHelper1.getAllDataAnswerForQuestion(QuestionInfo.id);
            for(Data_Answer data : dataA) {
                RR1.setText(dataA.get(0).getText());
                RR2.setText(dataA.get(1).getText());
                RR3.setText(dataA.get(2).getText());
                RR4.setText(dataA.get(3).getText());
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
                QuestionInfo.setText(Qtxt.getText().toString());
                QuestionInfo.setId_answer(RBEdit);
                QuestionInfo.setMark(Integer.parseInt(Mark.getText().toString()));

                databaseHelper1.updateDataToQuestion(QuestionInfo);

                Course1.notifyAdapter();
                Course2.notifyAdapter();
                Course3.notifyAdapter();
                Course4.notifyAdapter();

                Intent intent = new Intent(EditQuestionActivity.this,ActivityQuestionMangment.class);
                startActivity(intent);
                finish();
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