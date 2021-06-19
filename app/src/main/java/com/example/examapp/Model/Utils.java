package com.example.examapp.Model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.examapp.R;
import com.example.examapp.helper.DatabaseHelper1;

public class Utils {
    private static int sTheme;
    public final static int THEME_DEFAULT = 0;
    public final static int THEME_DARKBLUE = 1;
    public final static int THEME_TEAL = 2;
    private Context context;

    public Utils(Context context) {
        this.context = context;
    }

    public Utils() {

    }

    public void setColorTheme(View v) {
        switch (v.getId()) {
            case R.id.redBtn:
                Constant.theme = R.style.RedTheme;
                break;
            case R.id.darkBlueBtn:
                Constant.theme = R.style.DarkBlueTheme;
                break;
            case R.id.tealBtn:
                Constant.theme = R.style.tealTheme;
                break;
            default:
                Constant.theme = R.style.Theme_ExamApp;
                break;
        }
    }
    public void insertFiveQuestionToCourseOne(){
//Insert question to course1
        Data_Question questionOnwCourseOne = new Data_Question();
        questionOnwCourseOne.setText("Question One");
        questionOnwCourseOne.setId_answer(1);
        questionOnwCourseOne.setMark(20);
        questionOnwCourseOne.setId_course(0);
        new DatabaseHelper1(context).insertDataToQuestion(questionOnwCourseOne);
        Data_Question questionTwoCourseOne = new Data_Question();
        questionTwoCourseOne.setText("Question Two");
        questionTwoCourseOne.setId_answer(1);
        questionTwoCourseOne.setMark(20);
        questionTwoCourseOne.setId_course(0);
        new DatabaseHelper1(context).insertDataToQuestion(questionTwoCourseOne);
        Data_Question questionThreeCourseOne = new Data_Question();
        questionThreeCourseOne.setText("Question Three");
        questionThreeCourseOne.setId_answer(1);
        questionThreeCourseOne.setMark(20);
        questionThreeCourseOne.setId_course(0);
        new DatabaseHelper1(context).insertDataToQuestion(questionThreeCourseOne);
        Data_Question questionFourCourseOne = new Data_Question();
        questionFourCourseOne.setText("Question Four");
        questionFourCourseOne.setId_answer(1);
        questionFourCourseOne.setMark(20);
        questionFourCourseOne.setId_course(0);
        new DatabaseHelper1(context).insertDataToQuestion(questionFourCourseOne);
        Data_Question questionFiveCourseOne = new Data_Question();
        questionFiveCourseOne.setText("Question Five");
        questionFiveCourseOne.setId_answer(1);
        questionFiveCourseOne.setMark(20);
        questionFiveCourseOne.setId_course(0);
        new DatabaseHelper1(context).insertDataToQuestion(questionFiveCourseOne);
    }
    public void insertFiveQuestionToCourseTwo(){
        //Insert question to course2
        Data_Question questionOnwCourseTwo = new Data_Question();
        questionOnwCourseTwo.setText("Question One");
        questionOnwCourseTwo.setId_answer(1);
        questionOnwCourseTwo.setMark(20);
        questionOnwCourseTwo.setId_course(1);
        new DatabaseHelper1(context).insertDataToQuestion(questionOnwCourseTwo);
        Data_Question questionTowCourseTwo = new Data_Question();
        questionTowCourseTwo.setText("Question Two");
        questionTowCourseTwo.setId_answer(1);
        questionTowCourseTwo.setMark(20);
        questionTowCourseTwo.setId_course(1);
        new DatabaseHelper1(context).insertDataToQuestion(questionTowCourseTwo);
        Data_Question questionThreeCourseTwo = new Data_Question();
        questionThreeCourseTwo.setText("Question Three");
        questionThreeCourseTwo.setId_answer(1);
        questionThreeCourseTwo.setMark(20);
        questionThreeCourseTwo.setId_course(1);
        new DatabaseHelper1(context).insertDataToQuestion(questionThreeCourseTwo);
        Data_Question questionFourCourseTwo = new Data_Question();
        questionFourCourseTwo.setText("Question Four");
        questionFourCourseTwo.setId_answer(1);
        questionFourCourseTwo.setMark(20);
        questionFourCourseTwo.setId_course(1);
        new DatabaseHelper1(context).insertDataToQuestion(questionFourCourseTwo);
        Data_Question questionFiveCourseTwo = new Data_Question();
        questionFiveCourseTwo.setText("Question Five");
        questionFiveCourseTwo.setId_answer(1);
        questionFiveCourseTwo.setMark(20);
        questionFiveCourseTwo.setId_course(1);
        new DatabaseHelper1(context).insertDataToQuestion(questionFiveCourseTwo);
    }
    public void insertFiveQuestionToCourseThree(){
        //Insert question to course3
        Data_Question questionOnwCourseThree = new Data_Question();
        questionOnwCourseThree.setText("Question One");
        questionOnwCourseThree.setId_answer(1);
        questionOnwCourseThree.setMark(20);
        questionOnwCourseThree.setId_course(2);
        new DatabaseHelper1(context).insertDataToQuestion(questionOnwCourseThree);
        Data_Question questionTowCourseThree = new Data_Question();
        questionTowCourseThree.setText("Question Two");
        questionTowCourseThree.setId_answer(1);
        questionTowCourseThree.setMark(20);
        questionTowCourseThree.setId_course(2);
        new DatabaseHelper1(context).insertDataToQuestion(questionTowCourseThree);
        Data_Question questionThreeCourseThree = new Data_Question();
        questionThreeCourseThree.setText("Question Three");
        questionThreeCourseThree.setId_answer(1);
        questionThreeCourseThree.setMark(20);
        questionThreeCourseThree.setId_course(2);
        new DatabaseHelper1(context).insertDataToQuestion(questionThreeCourseThree);
        Data_Question questionFourCourseThree = new Data_Question();
        questionFourCourseThree.setText("Question Four");
        questionFourCourseThree.setId_answer(1);
        questionFourCourseThree.setMark(20);
        questionFourCourseThree.setId_course(2);
        new DatabaseHelper1(context).insertDataToQuestion(questionFourCourseThree);
        Data_Question questionFiveCourseThree = new Data_Question();
        questionFiveCourseThree.setText("Question Five");
        questionFiveCourseThree.setId_answer(1);
        questionFiveCourseThree.setMark(20);
        questionFiveCourseThree.setId_course(2);
        new DatabaseHelper1(context).insertDataToQuestion(questionFiveCourseThree);
    }
    public void insertFiveQuestionToCourseFour(){
        //Insert question to course4
        Data_Question questionOnwCourseFour = new Data_Question();
        questionOnwCourseFour.setText("Question One");
        questionOnwCourseFour.setId_answer(1);
        questionOnwCourseFour.setMark(20);
        questionOnwCourseFour.setId_course(3);
        new DatabaseHelper1(context).insertDataToQuestion(questionOnwCourseFour);
        Data_Question questionTowCourseFour = new Data_Question();
        questionTowCourseFour.setText("Question Two");
        questionTowCourseFour.setId_answer(1);
        questionTowCourseFour.setMark(20);
        questionTowCourseFour.setId_course(3);
        new DatabaseHelper1(context).insertDataToQuestion(questionTowCourseFour);
        Data_Question questionThreeCourseFour = new Data_Question();
        questionThreeCourseFour.setText("Question Three");
        questionThreeCourseFour.setId_answer(1);
        questionThreeCourseFour.setMark(20);
        questionThreeCourseFour.setId_course(3);
        new DatabaseHelper1(context).insertDataToQuestion(questionThreeCourseFour);
        Data_Question questionFourCourseFour = new Data_Question();
        questionFourCourseFour.setText("Question Four");
        questionFourCourseFour.setId_answer(1);
        questionFourCourseFour.setMark(20);
        questionFourCourseFour.setId_course(3);
        new DatabaseHelper1(context).insertDataToQuestion(questionFourCourseFour);
        Data_Question questionFiveCourseFour = new Data_Question();
        questionFiveCourseFour.setText("Question Five");
        questionFiveCourseFour.setId_answer(1);
        questionFiveCourseFour.setMark(20);
        questionFiveCourseFour.setId_course(3);
        new DatabaseHelper1(context).insertDataToQuestion(questionFiveCourseFour);
    }

}
