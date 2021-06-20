package com.example.examapp.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.examapp.Model.Data_Account;
import com.example.examapp.Model.Data_Admin;
import com.example.examapp.Model.Data_Answer;
import com.example.examapp.Model.Data_Course;
import com.example.examapp.Model.Data_Exam;
import com.example.examapp.Model.Data_Question;
import com.example.examapp.Model.Data_Student;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper1 extends SQLiteOpenHelper {
    public static final String DB_NAME = "ExamApp_db";
    public static final int DB_VERSION = 1;
    public static final String ADMIN_TABLE = "admin";
    public static final String ANSWER_TABLE = "answer";
    public static final String QUESTION_TABLE = "question";
    public static final String STUDENT_TABLE = "student";
    public static final String COURSE_TABLE = "course";
    public static final String EXAM_TABLE = "exam";

    public DatabaseHelper1(@Nullable Context context  ) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE  IF NOT EXISTS " + ADMIN_TABLE  +" ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name" + " TEXT,"
                + "username" + " TEXT UNIQUE,"
                + "password" + " TEXT "
                +  " );" );

        db.execSQL("CREATE TABLE  IF NOT EXISTS " + COURSE_TABLE  +" ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "type" + " TEXT"
                + " );" );

        db.execSQL("CREATE TABLE  IF NOT EXISTS " + QUESTION_TABLE  +" ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "text" + " TEXT,"
                + "id_answer" + " INTEGER,"
                + "mark" + " INTEGER,"
                + "id_course" + " INTEGER"
                + " );" );

        db.execSQL("CREATE TABLE  IF NOT EXISTS " + ANSWER_TABLE +" ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "text" + " TEXT,"
                + "status" + " TEXT,"
                + "id_question" + " INTEGER,"
                + " FOREIGN KEY(\"id_question\") REFERENCES \"question\"(\"id\")" + " );" );

        db.execSQL("CREATE TABLE  IF NOT EXISTS " + EXAM_TABLE  +" ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "student_name" + " TEXT, "
                + "exam_mark" + " INTEGER,"
                + "course_name" + " TEXT"
                +  " );" );

        db.execSQL("CREATE TABLE  IF NOT EXISTS " + STUDENT_TABLE +" ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name" + " TEXT,"
                + "username" + " TEXT UNIQUE,"
                + "password" + " TEXT"
                +  " );" );
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ ADMIN_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ COURSE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ QUESTION_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ ANSWER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ EXAM_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ STUDENT_TABLE);
        onCreate(db);
    }

// insert part //

    // insert data to admin table
    public  long insertDataToAdmin(Data_Admin data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name" , data.getName());
        cv.put("username", data.getUsername());
        cv.put("password", data.getUsername());
        long id = db.insert(ADMIN_TABLE , null , cv);
        db.close();
        return  id;
    }
    // insert data to student table
    public  long insertDataToStudent(Data_Student data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name" , data.getName());
        cv.put("username", data.getUsername());
        cv.put("password", data.getUsername());
        long id = db.insert(STUDENT_TABLE , null , cv);
        db.close();
        return  id;
    }
    // insert data to question table
    public  long insertDataToQuestion(Data_Question data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("text" , data.getText());
        cv.put("id_answer" , data.getId_answer());
        cv.put("mark", data.getMark());
        cv.put("id_course", data.getId_course());
        long id = db.insert(QUESTION_TABLE , null , cv);
        db.close();
        return  id;
    }
    // insert data to answer table
    public  long insertDataToAnswer(Data_Answer data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("text" , data.getText());
        cv.put("status" , data.getStatus());
        cv.put("id_question", data.getId_question());
        long id = db.insert(ANSWER_TABLE , null , cv);
        db.close();
        return  id;
    }
    // insert data to course table
    public  long insertDataToCourse(Data_Course data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("type" , data.getType());
        long id = db.insert(COURSE_TABLE , null , cv);
        db.close();
        return  id;
    }
    // insert data to exam table
    public  long insertDataToExam(Data_Exam data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("student_name" , data.getNamestudent());
        cv.put("exam_mark" , data.getMark());
        cv.put("course_name", data.getNamecourse());
        long id = db.insert(EXAM_TABLE , null , cv);
        db.close();
        return  id;
    }

    // Update Part //
    // update data for question table
    public int updateDataToQuestion(Data_Question data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("text" , data.getText());
        cv.put("id_answer" , data.getId_answer());
        cv.put("mark", data.getMark());
        String whereClause = "id =?";
        String whereArgs[] = {String.valueOf(data.getId())};
        return  db.update(QUESTION_TABLE, cv, whereClause, whereArgs);
    }
    // Delete Part //
    // delete data from question table
    public  void deleteDataFromQuestion(Data_Question data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(QUESTION_TABLE,  "id" + " =?",
                new String[]{String.valueOf(data.getId())});
        db.close();
    }
    // get all answer data
        public List<Data_Answer> getAllDataAnswer() {
        List<Data_Answer> allData = new ArrayList<>();
        String query = "SELECT * FROM " + ANSWER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( query ,null);
        if(cursor.moveToFirst())
            do{
                Data_Answer data1 = new Data_Answer();
                data1.setId(cursor.getInt(cursor.getColumnIndex("id")));
                data1.setText( cursor.getString(cursor.getColumnIndex("text")));
                data1.setStatus(cursor.getInt(cursor.getColumnIndex("status")));
                data1.setId_question(cursor.getInt(cursor.getColumnIndex("id_question")));
                allData.add(data1);
            }while (cursor.moveToNext());
        db.close();
        return allData;
    }
    // getAllDataAnswerForQuestion
    public List<Data_Answer> getAllDataAnswerForQuestion(int id) {
        List<Data_Answer> allData = new ArrayList<>();
        String query = "SELECT * FROM "+ QUESTION_TABLE + " , " + ANSWER_TABLE + " WHERE " + ANSWER_TABLE + ".id_question = " + QUESTION_TABLE + ".id"
               + " AND " + ANSWER_TABLE + ".id_question = " + id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( query ,null);
        if(cursor.moveToFirst())
            do{
                Data_Answer data1 = new Data_Answer();
                data1.setId(cursor.getInt(cursor.getColumnIndex("id")));
                data1.setText( cursor.getString(cursor.getColumnIndex("text")));
                data1.setStatus(cursor.getInt(cursor.getColumnIndex("status")));
                data1.setId_question(cursor.getInt(cursor.getColumnIndex("id_question")));
                allData.add(data1);
            }while (cursor.moveToNext());
        db.close();
        return allData;
    }
    // getCourse1Questions
    public List<Data_Question> getCourse1Questions() {
        List<Data_Question> allData = new ArrayList<>();
        String query = "SELECT * FROM " + QUESTION_TABLE + " WHERE id_course = " + 0
                + " ORDER BY " + "id" + " DESC"; //  query must be completed
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( query ,null);
        if(cursor.moveToFirst())
            do{
                Data_Question data1 = new Data_Question();
                data1.setId(cursor.getInt(cursor.getColumnIndex("id")));
                data1.setText( cursor.getString(cursor.getColumnIndex("text")));
                data1.setId_answer(cursor.getInt(cursor.getColumnIndex("id_answer")));
                data1.setMark(cursor.getInt(cursor.getColumnIndex("mark")));
                data1.setId_course(cursor.getInt(cursor.getColumnIndex("id_course")));
                allData.add(data1);

            }while (cursor.moveToNext());
        db.close();
        return allData;
    }
    // getCourse2Questions
    public List<Data_Question> getCourse2Questions() {
        List<Data_Question> allData = new ArrayList<>();
        String query = "SELECT * FROM " + QUESTION_TABLE + " WHERE id_course = " + 1
                + " ORDER BY " + "id" + " DESC"; //  query must be completed
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( query ,null);
        if(cursor.moveToFirst())
            do{
                Data_Question data1 = new Data_Question();
                data1.setId(cursor.getInt(cursor.getColumnIndex("id")));
                data1.setText( cursor.getString(cursor.getColumnIndex("text")));
                data1.setId_answer(cursor.getInt(cursor.getColumnIndex("id_answer")));
                data1.setMark(cursor.getInt(cursor.getColumnIndex("mark")));
                data1.setId_course(cursor.getInt(cursor.getColumnIndex("id_course")));
                allData.add(data1);

            }while (cursor.moveToNext());
        db.close();
        return allData;
    }
    // getCourse3Questions
    public List<Data_Question> getCourse3Questions() {
        List<Data_Question> allData = new ArrayList<>();
        String query = "SELECT * FROM " + QUESTION_TABLE + " WHERE id_course = " + 2
                + " ORDER BY " + "id" + " DESC"; //  query must be completed
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( query ,null);
        if(cursor.moveToFirst())
            do{
                Data_Question data1 = new Data_Question();
                data1.setId(cursor.getInt(cursor.getColumnIndex("id")));
                data1.setText( cursor.getString(cursor.getColumnIndex("text")));
                data1.setId_answer(cursor.getInt(cursor.getColumnIndex("id_answer")));
                data1.setMark(cursor.getInt(cursor.getColumnIndex("mark")));
                data1.setId_course(cursor.getInt(cursor.getColumnIndex("id_course")));
                allData.add(data1);

            }while (cursor.moveToNext());
        db.close();
        return allData;
    }
    // getCourse4Questions
    public List<Data_Question> getCourse4Questions() {
        List<Data_Question> allData = new ArrayList<>();
        String query = "SELECT * FROM " + QUESTION_TABLE + " WHERE id_course = " + 3
                + " ORDER BY " + "id" + " DESC"; //  query must be completed
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( query ,null);
        if(cursor.moveToFirst())
            do{
                Data_Question data1 = new Data_Question();
                data1.setId(cursor.getInt(cursor.getColumnIndex("id")));
                data1.setText( cursor.getString(cursor.getColumnIndex("text")));
                data1.setId_answer(cursor.getInt(cursor.getColumnIndex("id_answer")));
                data1.setMark(cursor.getInt(cursor.getColumnIndex("mark")));
                data1.setId_course(cursor.getInt(cursor.getColumnIndex("id_course")));
                allData.add(data1);

            }while (cursor.moveToNext());
        db.close();
        return allData;
    }
    // get All Exam Data
    public List<Data_Exam> getAllExamData() {
        List<Data_Exam> allData = new ArrayList<>();
        String query = "SELECT * FROM " + EXAM_TABLE  + " ORDER BY " + "id" + " DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( query ,null);
        if(cursor.moveToFirst())
            do{
                Data_Exam data1 = new Data_Exam();
                data1.setId(cursor.getInt(cursor.getColumnIndex("id")));
                data1.setNamestudent( cursor.getString(cursor.getColumnIndex("student_name")));
                data1.setMark(cursor.getInt(cursor.getColumnIndex("exam_mark")));
                data1.setNamecourse(cursor.getString(cursor.getColumnIndex("course_name")));
                allData.add(data1);
            }while (cursor.moveToNext());
        db.close();
        return allData;
    }
    // getData_Admin
    public Data_Admin getData_Admin(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("admin",
                new String[]{"id",
                        "name",
                        "username",
                        "password",},
                "id=?", new String[]{String.valueOf(id)},
                null,null,null,null);

        if(cursor != null  && cursor.getCount()>0)
            cursor.moveToFirst();
        Data_Admin data = new Data_Admin(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1) ,
                cursor.getString(2) ,
                cursor.getString(3)
        );
        cursor.close();
        return data;
    }
    // login admin
    public boolean login_admin(String username, String password) {
        String query = "SELECT * FROM admin WHERE username='" + username + "' AND password='" + password + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( query ,null);
        if (cursor.getCount() == 0) {
            return false;
        }
        if (cursor.moveToFirst()) do {
            int id = cursor.getInt(0);
            if (id > 0) return true;
        } while (cursor.moveToNext());

        return false;
    }
    // login student
    public boolean login_student(String username, String password) {
        String query = "SELECT * FROM student WHERE username='" + username + "' AND password='" + password + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( query ,null);
        if (cursor.getCount() == 0) {
            return false;
        }
        if (cursor.moveToFirst()) do {
            int id = cursor.getInt(0);
            if (id > 0) return true;
        } while (cursor.moveToNext());

        return false;
    }
    // getLastIdOfQuestion
    public int getLastIdOfQuestion() {
        String query = "SELECT * FROM question ORDER BY id  DESC LIMIT " + 1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( query ,null);
        if (cursor.getCount() == 0) {
            return 0;
        }
        if (cursor.moveToFirst()) do {
            int id = cursor.getInt(0);
            if (id > 0) return id;
        } while (cursor.moveToNext());

        return 0;
    }
    // getQuestionId
    public Data_Question getQuestionId(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("question",
                new String[]{"id",
                        "text",
                        "id_answer",
                        "mark",
                        "id_course"},
                "id =?", new String[]{String.valueOf(id)},
                null,null,null,null);
        if (cursor!= null )
         cursor.moveToFirst();
        Data_Question data_question= new Data_Question(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1) ,
                Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)),
                Integer.parseInt(cursor.getString(4))
        );
        return data_question;
    }
}
//
//    public  int getDataCount(){
//        String query = "SELECT * FROM "+ Utils.TABLE_NAME ;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery( query ,null);
//        int count = cursor.getCount();
//        cursor.close();
//        return count;
//    }
//}
