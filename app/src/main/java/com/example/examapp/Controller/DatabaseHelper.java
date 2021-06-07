package com.example.examapp.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.examapp.Model.Data_Account;
import com.example.examapp.Model.Data_Admin;
import com.example.examapp.Model.Data_Answer;
import com.example.examapp.Model.Data_Course;
import com.example.examapp.Model.Data_Exam;
import com.example.examapp.Model.Data_Question;
import com.example.examapp.Model.Data_Student;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "ExamApp";
    public static final int DB_VERSION = 1;
    public static final String TABLE1_NAME = "account";
    public static final String TABLE2_NAME = "admin";
    public static final String TABLE3_NAME = "student";
    public static final String TABLE4_NAME = "question";
    public static final String TABLE5_NAME = "answer";
    public static final String TABLE6_NAME = "course";
    public static final String TABLE7_NAME = "exam";

    public DatabaseHelper(@Nullable Context context  ) {
        super(context, DB_NAME,null, Integer.parseInt(DB_NAME));
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE \"account\" (\n" +
                "\t\"userName\"\tTEXT UNIQUE,\n" +
                "\t\"password\"\tTEXT,\n" +
                "\t\"type\"\tINTEGER,\n" +
                "\tPRIMARY KEY(\"userName\")\n" +
                ")" );
        db.execSQL("CREATE TABLE \"admin\" (\n" +
                "\t\"id\"\tINTEGER,\n" +
                "\t\"name\"\tTEXT,\n" +
                "\t\"fname\"\tTEXT,\n" +
                "\t\"lname\"\tTEXT,\n" +
                "\t\"username\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"id\")\n" +
                ");" );
        db.execSQL("CREATE TABLE \"student\" (\n" +
                "\t\"id\"\tINTEGER,\n" +
                "\t\"name\"\tTEXT,\n" +
                "\t\"fname\"\tTEXT,\n" +
                "\t\"lname\"\tTEXT,\n" +
                "\t\"username\"\tTEXT,\n" +
                "\t\"id_exam\"\tINTEGER,\n" +
                "\tPRIMARY KEY(\"id\")\n" +
                ");" );
        db.execSQL("CREATE TABLE \"question\" (\n" +
                "\t\"id\"\tINTEGER,\n" +
                "\t\"text\"\tTEXT,\n" +
                "\t\"id_answer\"\tINTEGER,\n" +
                "\t\"mark\"\tINTEGER,\n" +
                "\tPRIMARY KEY(\"id\")\n" +
                ");" );
        db.execSQL("CREATE TABLE \"answer\" (\n" +
                "\t\"id\"\tINTEGER,\n" +
                "\t\"text\"\tTEXT,\n" +
                "\t\"status\"\tINTEGER COLLATE BINARY,\n" +
                "\t\"id_question\"\tINTEGER,\n" +
                "\tFOREIGN KEY(\"id_question\") REFERENCES \"question\"(\"id\")\n" +
                ");" );
        db.execSQL("CREATE TABLE \"course\" (\n" +
                "\t\"id\"\tINTEGER,\n" +
                "\t\"type\"\tTEXT,\n" +
                "\t\"id_question\"\tINTEGER,\n" +
                "\t\"id_exam\"\tINTEGER,\n" +
                "\tFOREIGN KEY(\"id_question\") REFERENCES \"question\"(\"id\"),\n" +
                "\tPRIMARY KEY(\"id\")\n" +
                ");" );
        db.execSQL("CREATE TABLE \"exam\" (\n" +
                "\t\"id_course\"\tINTEGER,\n" +
                "\t\"id_student\"\tINTEGER,\n" +
                "\t\"mark\"\tINTEGER,\n" +
                "\tFOREIGN KEY(\"id_student\") REFERENCES \"student\"(\"id\"),\n" +
                "\tPRIMARY KEY(\"id_course\")\n" +
                ");" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE1_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE2_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE3_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE4_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE5_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE6_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE7_NAME);
        onCreate(db);
    }

// insert part //

    // insert data to account table
    public  long insertDataToAccount(Data_Account data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("userName", data.getUserName());
        cv.put("password" , data.getPassword());
        cv.put("type" , data.getType());
        long id = db.insert(TABLE1_NAME , null , cv);
        db.close();
        return  id;
    }
    // insert data to admin table
    public  long insertDataToAdmin(Data_Admin data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", data.getId());
        cv.put("name" , data.getName());
        cv.put("fname" , data.getFname());
        cv.put("lname", data.getLname());
        cv.put("username", data.getUsername());
        long id = db.insert(TABLE2_NAME , null , cv);
        db.close();
        return  id;
    }
    // insert data to student table
    public  long insertDataToStudent(Data_Student data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", data.getId());
        cv.put("name" , data.getName());
        cv.put("fname" , data.getFname());
        cv.put("lname", data.getLname());
        cv.put("username", data.getUsername());
        cv.put("id_exam", data.getId_exam());
        long id = db.insert(TABLE3_NAME , null , cv);
        db.close();
        return  id;
    }
    // insert data to question table
    public  long insertDataToQuestion(Data_Question data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", data.getId());
        cv.put("text" , data.getText());
        cv.put("id_answer" , data.getId_answer());
        cv.put("mark", data.getMark());
        long id = db.insert(TABLE4_NAME , null , cv);
        db.close();
        return  id;
    }
    // insert data to answer table
    public  long insertDataToAnswer(Data_Answer data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", data.getId());
        cv.put("text" , data.getText());
        cv.put("status" , data.getStatus());
        cv.put("id_question", data.getId_question());
        long id = db.insert(TABLE5_NAME , null , cv);
        db.close();
        return  id;
    }
    // insert data to course table
    public  long insertDataToCourse(Data_Course data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", data.getId());
        cv.put("type" , data.getType());
        cv.put("id_question" , data.getId_question());
        cv.put("id_exam", data.getId_exam());
        long id = db.insert(TABLE6_NAME , null , cv);
        db.close();
        return  id;
    }
    // insert data to exam table
    public  long insertDataToExam(Data_Exam data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id_course", data.getId_course());
        cv.put("id_student" , data.getId_student());
        cv.put("mark" , data.getMark());
        long id = db.insert(TABLE7_NAME , null , cv);
        db.close();
        return  id;
    }

// Update Part //

    // update data for question table
    public  int updateDataToQuestion(Data_Question data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", data.getId());
        cv.put("text" , data.getText());
        cv.put("id_answer" , data.getId_answer());
        cv.put("mark", data.getMark());
        return db.update(TABLE4_NAME, cv , "id" + " =?",
                new String[]{String.valueOf(data.getId())});
    }
    // update data for answer table
    public  int updateDataToAnswer(Data_Answer data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", data.getId());
        cv.put("text" , data.getText());
        cv.put("status" , data.getStatus());
        cv.put("id_question", data.getId_question());
        return db.update(TABLE5_NAME, cv , "id" + " =?",
                new String[]{String.valueOf(data.getId())});
    }
    // update data for student table
    public  int updateDataToStudent(Data_Student data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", data.getId());
        cv.put("name" , data.getName());
        cv.put("fname" , data.getFname());
        cv.put("lname", data.getLname());
        cv.put("username", data.getUsername());
        cv.put("id_exam", data.getId_exam());
        return db.update(TABLE3_NAME, cv , "id" + " =?",
                new String[]{String.valueOf(data.getId())});
    }

// Delete Part //
    // delete data from question table
    public  void deleteDataFromQuestion(Data_Question data){
        SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE4_NAME ,  data.getId() + " =?",
                new String[]{String.valueOf(data.getId())});
            db.close();
    }
    // delete data from answer table
    public  void deleteDataFromAnswer(Data_Answer data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE5_NAME ,  data.getId() + " =?",
                new String[]{String.valueOf(data.getId())});
        db.close();
    }

// Get Part //
    // update from question table
    public  Data_Question getDataFromQuestion(int id) {
        Data_Question data = new Data_Question();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE4_NAME,
                new String[]{ data.getText() },
                data.getId() + "=?", new String[]{String.valueOf(id)},
                null,null,null,null);
        if(cursor != null)
            cursor.moveToFirst();
   //     Data data = new Data(
//                cursor.getInt(cursor.getColumnIndex(Utils.COLOUMN_ID)),
//                cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_NAME)),
//                cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_LNAME)),
//                cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_DESCRIPTION)),
//                cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_AGE)),
//                cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_TIME_STAMP))  );
        Data_Question data1 = new Data_Question((cursor.getString(1)));
        return data1;
    }

    // update from answer table
    public  Data_Answer getDataFromAnswer(int id) {
        Data_Answer data = new Data_Answer();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE5_NAME,
                new String[]{ data.getText(), String.valueOf(data.getStatus()), String.valueOf(data.getId_question())},
                data.getId() + "=?", new String[]{String.valueOf(id)},
                null,null,null,null);
        if(cursor != null)
            cursor.moveToFirst();
        //     Data data = new Data(
//                cursor.getInt(cursor.getColumnIndex(Utils.COLOUMN_ID)),
//                cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_NAME)),
//                cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_LNAME)),
//                cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_DESCRIPTION)),
//                cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_AGE)),
//                cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_TIME_STAMP))  );
        Data_Answer data1 = new Data_Answer(
                cursor.getString(1),
                Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)));
        return data1;
    }


// get all data

    public List<Data_Student> getAllData() {
        Data_Student data = new Data_Student();
        List<Data_Student> allData = new ArrayList<>();
        String query = "SELECT * FROM "+ TABLE3_NAME +
                " ORDER BY " + "fname" + " DESC"; //  query must be completed
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( query ,null);
        if(cursor.moveToFirst())
          do{
              Data_Student data1 = new Data_Student();
              data.setId(cursor.getInt(cursor.getColumnIndex("id")));
              data.setName( cursor.getString(cursor.getColumnIndex("name")));
              data.setFname( cursor.getString(cursor.getColumnIndex("fname")));
              data.setLname( cursor.getString(cursor.getColumnIndex("lname")));
              data.setUsername(cursor.getString(cursor.getColumnIndex("username")));
              data.setId_exam( cursor.getString(cursor.getColumnIndex("id_exam")));
              allData.add(data1);

          }while (cursor.moveToNext());
        db.close();
        return allData;
    }


//    public  int getDataCount(){
//        String query = "SELECT * FROM "+ Utils.TABLE_NAME ;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery( query ,null);
//        int count = cursor.getCount();
//        cursor.close();
//        return count;
//    }


}
