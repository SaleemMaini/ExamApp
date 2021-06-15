//package com.example.examapp.Controller;
//
//import android.content.ContentValues;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.examapp.helper.DatabaseHelper1;
//
//public class CourseController extends BaseController {
//
//    public CourseController(AppCompatActivity activity) {
//        super(activity);
//    }
//
//    @Override
//    public void create() {
//        try {
//            String create = "CREATE TABLE  IF NOT EXISTS " + "course"  +" ("
//                    + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//                    + "type" + " TEXT,"
//                    + "id_question" + " INTEGER,"
//                    + "id_exam" + " TEXT,"
//                    + "FOREIGN KEY(id_question) REFERENCES question(id)" + " );";
//            new DatabaseHelper1(getActivity()).execSQL(create);
//        } catch (Exception e) {
//        }
//    }
//
//    @Override
//    public boolean login(String username, String password) { return false; }
//
//    @Override
//    public long insert(ContentValues values) {
//        return new DatabaseHelper1(getActivity()).insertData("course", values);
//    }
//    public long updateData(String TableName, ContentValues values, String where, String[] whereAr){
//        return new DatabaseHelper1(getActivity()).updateData("course", values, where, whereAr);
//
//    }
//}