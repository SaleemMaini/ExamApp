package com.example.examapp.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.examapp.Model.Data;

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

    public  long insertData(Data data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Utils.COLOUMN_NAME , data.getName());
        cv.put(Utils.COLOUMN_LNAME , data.getLname());
        cv.put(Utils.COLOUMN_DESCRIPTION , data.getDescription());
        cv.put(Utils.COLOUMN_AGE , data.getAge());
        long id = db.insert(Utils.TABLE_NAME , null , cv);
        db.close();
        return  id;
    }

    public  int updateData(Data data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Utils.COLOUMN_NAME , data.getName());
        cv.put(Utils.COLOUMN_LNAME , data.getLname());
        cv.put(Utils.COLOUMN_DESCRIPTION , data.getDescription());
        cv.put(Utils.COLOUMN_AGE , data.getAge());
        return db.update(Utils.TABLE_NAME , cv , "id" + " =?",
                new String[]{String.valueOf(data.getId())});
    }


    public  void deleteData(Data data){
        SQLiteDatabase db = this.getWritableDatabase();
            db.delete(Utils.TABLE_NAME ,  Utils.COLOUMN_ID + " =?",
                new String[]{String.valueOf(data.getId())});
            db.close();
    }


    public  Data getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Utils.TABLE_NAME,
                new String[]{Utils.COLOUMN_ID,
                        Utils.COLOUMN_NAME,Utils.COLOUMN_LNAME
                        ,Utils.COLOUMN_DESCRIPTION,
                        Utils.COLOUMN_AGE,Utils.COLOUMN_TIME_STAMP},
                Utils.COLOUMN_ID + "=?", new String[]{String.valueOf(id)},
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


         Data data = new Data(
        Integer.parseInt(cursor.getString(0)),
        cursor.getString(1) ,
                cursor.getString(2) ,
                cursor.getString(3) ,
                cursor.getString(4)
        );

        return data;
    }




    public List<Data> getAllData() {
        List<Data> allData = new ArrayList<>();
        String query = "SELECT * FROM "+ Utils.TABLE_NAME +
                " ORDER BY " + Utils.COLOUMN_TIME_STAMP + " DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( query ,null);
        if(cursor.moveToFirst())
          do{
              Data data = new Data();
              data.setId(cursor.getInt(cursor.getColumnIndex(Utils.COLOUMN_ID)));
              data.setName( cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_NAME)));
              data.setLname( cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_LNAME)));
              data.setAge(cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_AGE)));
              data.setDescription( cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_DESCRIPTION)));
              data.setTimeStamp(cursor.getString(cursor.getColumnIndex(Utils.COLOUMN_TIME_STAMP)));

              allData.add(data);

          }while (cursor.moveToNext());
        db.close();
        return allData;
    }


    public  int getDataCount(){
        String query = "SELECT * FROM "+ Utils.TABLE_NAME ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( query ,null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }


}
