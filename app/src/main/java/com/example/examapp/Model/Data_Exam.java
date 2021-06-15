package com.example.examapp.Model;

public class Data_Exam {
    public int id;
    public int id_student;
    public int mark;

    public Data_Exam() {
    }

    public Data_Exam(int id, int id_student, int mark) {
        this.id = id;
        this.id_student = id_student;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
