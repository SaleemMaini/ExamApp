package com.example.examapp.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examapp.Model.Data_Answer;
import com.example.examapp.Model.Data_Question;
import com.example.examapp.R;
import com.example.examapp.helper.DatabaseHelper1;
import com.google.android.material.snackbar.Snackbar;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ExamActivity extends AppCompatActivity {
    Button nextBtnQuestion1, prvBtnQuestion1;

    private TextView Qtxt,Mark;
    private RadioButton RR1, RR2, RR3, RR4;
    private RadioGroup rbGroup;
    private DatabaseHelper1 databaseHelper1;
    Data_Question currentQuestion;
    private EditText questionText,questionMark;

    private List<Data_Question> questionList;
    private int questionCounter;
    private int questionCountTotal;

    private int score;
    private boolean answered;
    int coursePositionId;
    String studentPosition;
    String coursePositionName;

//    Theme
    SharedPreferences app_preferences;
    int appTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Start  Set Theme
        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        appTheme = app_preferences.getInt("theme", 0);
        setTheme(appTheme);
//        End set Theme
        setContentView(R.layout.activity_exam);

        Qtxt = findViewById(R.id.questionOneText);
//        Mark = findViewById(R.id.textMarkEdit);
        rbGroup = findViewById(R.id.RadioGroupExam);
        RR1 = findViewById(R.id.radioButtonAnswer1);
        RR2 = findViewById(R.id.radioButtonAnswer2);
        RR3 = findViewById(R.id.radioButtonAnswer3);
        RR4 = findViewById(R.id.radioButtonAnswer4);
        nextBtnQuestion1 = findViewById(R.id.nextBtnQuestion1);

        Bundle bundle = getIntent().getExtras();
//        str_position = bundle.getInt("Selected Course Id");
        coursePositionId = bundle.getInt("Selected_Course_Id");
        studentPosition = bundle.getString("Selected_Student");
        databaseHelper1 = new DatabaseHelper1(this);
        currentQuestion = new Data_Question();

        if(coursePositionId == R.id.courseOneBtn){ questionList = databaseHelper1.getCourse1Questions();  coursePositionName = "HTML";}
        if(coursePositionId == R.id.courseTwoBtn){ questionList = databaseHelper1.getCourse2Questions(); coursePositionName = "Javascript";}
        if(coursePositionId == R.id.courseThreeBtn){ questionList = databaseHelper1.getCourse3Questions(); coursePositionName = "CSS";}
        if(coursePositionId == R.id.courseFourBtn){ questionList = databaseHelper1.getCourse4Questions(); coursePositionName = "SQL";}
        questionCountTotal = 5;
//        Collections.shuffle(questionList);
        showNextQuestion();



//        Next Btn

        nextBtnQuestion1 = findViewById(R.id.nextBtnQuestion1);
        final MediaPlayer nextSound = MediaPlayer.create(this,R.raw.next);

        nextBtnQuestion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextSound.start();
                if (!answered) {
                    if (RR1.isChecked() || RR2.isChecked() || RR3.isChecked() || RR4.isChecked()) {
                        checkAnswer();
                        Toast.makeText(ExamActivity.this, "Done", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ExamActivity.this, "Please select an answer", Toast.LENGTH_LONG).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });

//       Previous Btn
        prvBtnQuestion1 = findViewById(R.id.prvBtnQuestion1);
        final MediaPlayer previousSound = MediaPlayer.create(this,R.raw.previous);
        prvBtnQuestion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousSound.start();
                showPreviousQuestion();
            }
        });


    }

    private void showNextQuestion(){
        rbGroup.clearCheck();
        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);
            Qtxt.setText(currentQuestion.getText());
            List<Data_Answer> dataA = databaseHelper1.getAllDataAnswerForQuestion(currentQuestion.getId());
            for(Data_Answer data : dataA) {
                RR1.setText(dataA.get(0).getText());
                RR2.setText(dataA.get(1).getText());
                RR3.setText(dataA.get(2).getText());
                RR4.setText(dataA.get(3).getText());
            }
            questionCounter++;
            answered  = false;
            nextBtnQuestion1.setText("confirm");
        } else {
            finishQuiz();
        }
    }
    private void showPreviousQuestion(){
        rbGroup.clearCheck();
        if (questionCounter == 0 ) {
            Snackbar.make(findViewById(R.id.LinearLayoutExamActivity), "No previous question", Snackbar.LENGTH_LONG).show();
        } else {
            currentQuestion = questionList.get(questionCounter - 1);
            Qtxt.setText(currentQuestion.getText());
            List<Data_Answer> dataA = databaseHelper1.getAllDataAnswerForQuestion(currentQuestion.getId());
            for(Data_Answer data : dataA) {
                RR1.setText(dataA.get(0).getText());
                RR2.setText(dataA.get(1).getText());
                RR3.setText(dataA.get(2).getText());
                RR4.setText(dataA.get(3).getText());
            }
            questionCounter--;
            answered  = false;
            nextBtnQuestion1.setText("confirm");
        }
    }
    private void finishQuiz() {

        finish();
    }
    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;
        if (answerNr == currentQuestion.getId_answer()) {
            score += currentQuestion.getMark();
//            textViewScore.setText("Score: " + score);
        }
        switchNextToFinish();
    }
    private void switchNextToFinish() {

        if (questionCounter < questionCountTotal) {
            nextBtnQuestion1.setText("Next");

        } else {
            nextBtnQuestion1.setText("Finish");
            int fScore = score;
            Intent i = new Intent(ExamActivity.this,Result_Score.class);
            i.putExtra("Score", fScore);
            i.putExtra("Name_Student",studentPosition);
            i.putExtra("Course_Name",coursePositionName);
            startActivity(i);

        }
    }
}