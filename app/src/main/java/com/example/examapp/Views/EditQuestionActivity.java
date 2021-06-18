package com.example.examapp.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import com.example.examapp.Model.Data_Answer;
import com.example.examapp.Model.Data_Question;
import com.example.examapp.R;

import com.example.examapp.helper.DatabaseHelper1;

import java.util.List;

public class EditQuestionActivity extends AppCompatActivity {
    private Button btnsv;
    private EditText Qtxt,Mark;
    private RadioButton RR1, RR2, RR3, RR4;
    private DatabaseHelper1 databaseHelper1;
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



        btnsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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