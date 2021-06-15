//package com.example.examapp.Controller;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.examapp.Model.Data_Question;
//import com.example.examapp.Model.Data_Student;
//import com.example.examapp.helper.DatabaseHelper1;
//
//import java.util.ArrayList;
//
//public class QuestionController extends BaseController {
//
//    public QuestionController(AppCompatActivity activity) {
//        super(activity);
//    }
//
//
//    @Override
//    public void create() {
//        try {
//            String create = "CREATE TABLE  IF NOT EXISTS " + "question"  +" ("
//                    + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//                    + "text" + " TEXT,"
//                    + "id_answer" + " INTEGER,"
//                    + "mark" + " INTEGER,"
//                    + "id_course" + " INTEGER" + " );";
//            new DatabaseHelper1(getActivity()).execSQL(create);
//        } catch (Exception e) {
//        }
//    }
//
//    @Override
//    public boolean login(String username, String password) {
//            return false;
//        }
//
//
//    @Override
//    public long insert(ContentValues values) {
//        return new DatabaseHelper1(getActivity()).insertData("question", values);
//    }
//    public long updateData(String TableName, ContentValues values, String where, String[] whereAr){
//        return new DatabaseHelper1(getActivity()).updateData("question", values, where, whereAr);
//    }
//
////    public  Data_Question getData(int id) {
////        SQLiteDatabase db = this.getReadableDatabase();
////        Cursor cursor = db.query("question",
////                new String[]{"id",
////                        "text",
////                        "id_answer",
////                        "mark",
////                        "id_course"},
////                "id=?", new String[]{String.valueOf(id)},
////                null,null,null,null);
////
////        if(cursor != null  && cursor.getCount()>0)
////            cursor.moveToFirst();
////        Data_Question data = new Data_Question(
////                Integer.parseInt(cursor.getString(0)),
////                cursor.getString(1) ,
////                Integer.parseInt(cursor.getString(2)) ,
////                Integer.parseInt(cursor.getString(3))
////                ,Integer.parseInt(cursor.getString(4))
////        );
////        cursor.close();
////        return data;
////    }
//
//    public Data_Question getQuestionId(int id) {
//
//        Cursor cursor = new DatabaseHelper1(getActivity()).getData("SELECT * FROM question WHERE id='" + id + "';");
//        Data_Question Data_Question;
//        if (cursor!= null && cursor.getCount() == 0) return null;
//        Data_Question = new Data_Question();
//        if (cursor.moveToFirst()) do {
//            Data_Question.setText(cursor.getString(cursor.getColumnIndex("text")));
//            Data_Question.setId_answer(cursor.getInt(cursor.getColumnIndex("id_answer")));
//            Data_Question.setMark(cursor.getInt(cursor.getColumnIndex("mark")));
//            Data_Question.setId_answer(cursor.getInt(cursor.getColumnIndex("id_course")));
//        } while (cursor.moveToNext());
//
//        return Data_Question;
//    }
//}