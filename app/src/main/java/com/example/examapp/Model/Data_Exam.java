package com.example.examapp.Model;

public class Data_Exam {
    public int id;
    public int student_id;
    public int mark;
    public int course_id;

    public Data_Exam() {
    }

    public Data_Exam(int student_id, int mark, int course_id) {
        this.student_id = student_id;
        this.mark = mark;
        this.course_id = course_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
}