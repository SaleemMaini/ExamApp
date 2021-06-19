package com.example.examapp.Model;

public class Data_Exam {
    public int id;
    public String namestudent;
    public int mark;
    public String namecourse;

    public Data_Exam() {
    }

    public Data_Exam(String namestudent, int mark, String namecourse) {
        this.namestudent = namestudent;
        this.mark = mark;
        this.namecourse = namecourse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamestudent() {
        return namestudent;
    }

    public void setNamestudent(String namestudent) {
        this.namestudent = namestudent;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getNamecourse() {
        return namecourse;
    }

    public void setNamecourse(String namecourse) {
        this.namecourse = namecourse;
    }
}