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
//    private final SQLiteDatabase db;
    private AppCompatActivity activity;
    public static final String DB_NAME = "ExamApp_db";
    public static final int DB_VERSION = 1;
    public static final String TABLE2_NAME = "admin";
    public static final String TABLE3_NAME = "student";
    public static final String TABLE4_NAME = "question";
    public static final String TABLE5_NAME = "answer";
    public static final String TABLE6_NAME = "course";
    public static final String TABLE7_NAME = "exam";

    public DatabaseHelper1(@Nullable Context context  ) {
        super(context, DB_NAME,null, DB_VERSION);
    }


//    public void execSQL(String sql) {
//        db.execSQL(sql);
//    }
//    public Cursor getData(String sql) {
//        return db.rawQuery(sql, null);
//    }
//    public long insertData(String TableName, ContentValues values) {
//        return db.insert(TableName, null, values);
//    }
//    public long updateData(String TableName, ContentValues values, String where, String[] whereAr) {
//        return db.update(TableName, values, where, whereAr);
//    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE  IF NOT EXISTS " + TABLE2_NAME  +" ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name" + " TEXT,"
                + "username" + " TEXT UNIQUE,"
                + "password" + " TEXT "
                +  " );" );

        db.execSQL("CREATE TABLE  IF NOT EXISTS " + TABLE5_NAME  +" ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "text" + " TEXT,"
                + "status" + " TEXT,"
                + "id_question" + " INTEGER ,"
                + " FOREIGN KEY(\"id_question\") REFERENCES \"question\"(\"id\")" + " );" );

        db.execSQL("CREATE TABLE  IF NOT EXISTS " + TABLE4_NAME  +" ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "text" + " TEXT,"
                + "id_answer" + " INTEGER,"
                + "mark" + " INTEGER,"
                + "id_course" + " INTEGER,"
                + " FOREIGN KEY(\"id_course\") REFERENCES \"course\"(\"id\")"+ " );" );

        db.execSQL("CREATE TABLE  IF NOT EXISTS " + TABLE5_NAME  +" ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "text" + " TEXT,"
                + "status" + " TEXT,"
                + "id_question" + " INTEGER,"
                + " FOREIGN KEY(\"id_question\") REFERENCES \"question\"(\"id\")" + " );" );

        db.execSQL("CREATE TABLE  IF NOT EXISTS " + TABLE6_NAME  +" ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "type" + " TEXT,"
                + "id_question" + " INTEGER,"
                + "id_exam" + " INTEGER,"
                + "FOREIGN KEY(id_question) REFERENCES question(id)" + " );" );

        db.execSQL("CREATE TABLE  IF NOT EXISTS " + TABLE7_NAME  +" ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "id_Student" + " INTEGER,"
                + "mark" + " INTEGER,"
                + "id_course" + " INTEGER,"
                + "FOREIGN KEY(id_course) REFERENCES course(id)"
                +  " );" );

        db.execSQL("CREATE TABLE  IF NOT EXISTS " + TABLE3_NAME  +" ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name" + " TEXT,"
                + "username" + " TEXT,"
                + "password" + " TEXT,"
                + "id_exam" + " INTEGER,"
                + " FOREIGN KEY(\"id_exam\") REFERENCES \"exam\"(\"id\")"
                +  " );" );
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

//        db.execSQL("DROP TABLE IF EXISTS "+ TABLE1_NAME);
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
//    public  long insertDataToAccount(Data_Account data){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put("userName", data.getUserName());
//        cv.put("password" , data.getPassword());
//        cv.put("type" , data.getType());
//        long id = db.insert(TABLE1_NAME , null , cv);
//        db.close();
//        return  id;
//    }
    // insert data to admin table
    public  long insertDataToAdmin(Data_Admin data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name" , data.getName());
        cv.put("username", data.getUsername());
        cv.put("password", data.getUsername());
        long id = db.insert(TABLE2_NAME , null , cv);
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
        cv.put("id_exam", data.getId_exam());
        long id = db.insert(TABLE3_NAME , null , cv);
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
        long id = db.insert(TABLE4_NAME , null , cv);
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
        long id = db.insert(TABLE5_NAME , null , cv);
        db.close();
        return  id;
    }
    // insert data to course table
    public  long insertDataToCourse(Data_Course data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
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
        cv.put("id_student" , data.getStudent_id());
        cv.put("mark" , data.getMark());
        cv.put("id_course", data.getCourse_id());
        long id = db.insert(TABLE7_NAME , null , cv);
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
        return  db.update(TABLE4_NAME, cv, whereClause, whereArgs);
    }
    // update data for answer table
    public  int updateDataToAnswer(Data_Answer data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("text" , data.getText());
        cv.put("status" , data.getStatus());
        cv.put("id_question", data.getId_question());
        return db.update(TABLE5_NAME, cv , "id_question =?",
                new String[]{String.valueOf(data.getId())});
    }
    // update data for student table
    public  int updateDataToStudent(Data_Student data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name" , data.getName());
        cv.put("username", data.getUsername());
        cv.put("username", data.getUsername());
        cv.put("id_exam", data.getId_exam());
        return db.update(TABLE3_NAME, cv , "name" + " =?",
                new String[]{String.valueOf(data.getId())});
    }
//
// Delete Part //
    // delete data from question table
    public  void deleteDataFromQuestion(Data_Question data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE4_NAME ,  "id" + " =?",
                new String[]{String.valueOf(data.getId())});
        db.close();
    }
    // delete data from answer table
//    public  void deleteDataFromAnswer(Data_Answer data){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE5_NAME ,  data.getText() + " =?",
//                new String[]{String.valueOf(data.getId())});
//        db.close();
//    }

// Get Part //

//    public  Data_Question getDataFromQuestion(int id) {
//        Data_Question data = new Data_Question();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(TABLE4_NAME,
//                new String[]{ data.getText() },
//                data.getId() + "=?", new String[]{String.valueOf(id)},
//                null,null,null,null);
//        if(cursor != null)
//            cursor.moveToFirst();
//        Data_Question data1 = new Data_Question(
//                cursor.getString(cursor.getColumnIndex("text")),
//                cursor.getInt(cursor.getColumnIndex("id_answer")),
//                cursor.getString(cursor.getColumnIndex("mark")),
//        Data_Question data1 = new Data_Question((cursor.getString(1)));
//        return data1;
//
//    }


//    public  Data_Answer getDataFromAnswer(int id) {
//        Data_Answer data = new Data_Answer();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(TABLE5_NAME,
//                new String[]{ data.getText(), String.valueOf(data.getStatus()), String.valueOf(data.getId_question())},
//                data.getId() + "=?", new String[]{String.valueOf(id)},
//                null,null,null,null);
//        if(cursor != null)
//            cursor.moveToFirst();
//             Data data = new Data(
//                cursor.getInt(cursor.getColumnIndex(Utils.COLOUMN_ID)),
//                cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_NAME)),
//                cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_LNAME)),
//                cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_DESCRIPTION)),
//                cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_AGE)),
//                cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_TIME_STAMP))  );
//        Data_Answer data1 = new Data_Answer(
//                cursor.getString(1),
//                Integer.parseInt(cursor.getString(2)),
//                Integer.parseInt(cursor.getString(3)));
//        return data1;
//    }


// get all data

    public List<Data_Question> getAllDataQuestions() {
        List<Data_Question> allData = new ArrayList<>();
        String query = "SELECT text,mark FROM "+ TABLE4_NAME;
//                + " ORDER BY " + "text" + " DESC"; //  query must be completed
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( query ,null);
        if(cursor.moveToFirst())
          do{
              Data_Question data1 = new Data_Question();
              data1.setText( cursor.getString(cursor.getColumnIndex("text")));
              data1.setMark(cursor.getInt(cursor.getColumnIndex("mark")));
              allData.add(data1);

          }while (cursor.moveToNext());
        db.close();
        return allData;
    }
    public List<Data_Answer> getAllDataAnswer() {
        List<Data_Answer> allData = new ArrayList<>();
        String query = "SELECT * FROM "+ TABLE5_NAME;
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
    public List<Data_Answer> getAllDataAnswerForQuestion(int id) {
        List<Data_Answer> allData = new ArrayList<>();
        String query = "SELECT * FROM "+ TABLE4_NAME + " , " + TABLE5_NAME + " WHERE " + TABLE5_NAME + ".id_question = " + TABLE4_NAME + ".id"
               + " AND " + TABLE5_NAME + ".id_question = " + id;
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

    public List<Data_Question> getCourse1Questions() {
        List<Data_Question> allData = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE4_NAME + " WHERE id_course = " + 0
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
    public List<Data_Question> getCourse2Questions() {
        List<Data_Question> allData = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE4_NAME + " WHERE id_course = " + 1
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
    public List<Data_Question> getCourse3Questions() {
        List<Data_Question> allData = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE4_NAME + " WHERE id_course = " + 2
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
    public List<Data_Question> getCourse4Questions() {
        List<Data_Question> allData = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE4_NAME + " WHERE id_course = " + 3
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

    public  Data_Question getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("question",
                new String[]{"id"},
                "id=?", new String[]{String.valueOf(id)},
                null,null,"id ",null);

        if(cursor != null  && cursor.getCount()>0)
            cursor.moveToFirst();
        Data_Question data = new Data_Question(
                Integer.parseInt(cursor.getString(0))

        );
        cursor.close();
        return data;
    }
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



//        else {
//            return new Data_Question("Hi",1,1,1); // try again
//        }
//    }

//            Data_Question data = new Data_Question(
//                    cursor.getInt(cursor.getColumnIndex("id")),
//                    cursor.getString(cursor.getColumnIndex("text")),
//                    cursor.getInt(cursor.getColumnIndex("id_answer")),
//                    cursor.getInt(cursor.getColumnIndex("mark")),
//                    cursor.getInt(cursor.getColumnIndex("id_course")));




//    public  int getDataCount(){
//        String query = "SELECT * FROM "+ Utils.TABLE_NAME ;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery( query ,null);
//        int count = cursor.getCount();
//        cursor.close();
//        return count;
//    }
//}
