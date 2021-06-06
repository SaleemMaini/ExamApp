package com.example.examapp.Model;

public class Data_Exam {
    public int id_course;
    public int id_student;
    public int mark;

    public Data_Exam() {
    }

    public Data_Exam(int id_course, int id_student, int mark) {
        this.id_course = id_course;
        this.id_student = id_student;
        this.mark = mark;
    }


    public int getId_course() {
        return id_course;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
