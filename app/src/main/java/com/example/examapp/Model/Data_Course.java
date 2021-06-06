package com.example.examapp.Model;

public class Data_Course {
    private int id;
    private String type;
    private int id_question;
    private int id_exam;

    public Data_Course() {
    }

    public Data_Course(int id, String type, int id_question, int id_exam) {
        this.id = id;
        this.type = type;
        this.id_question = id_question;
        this.id_exam = id_exam;
    }

    public Data_Course(String type, int id_question, int id_exam) {
        this.type = type;
        this.id_question = id_question;
        this.id_exam = id_exam;
    }


    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getId_question() {
        return id_question;
    }

    public int getId_exam() {
        return id_exam;
    }
    ///////////////////////////////////////////////////////

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public void setId_exam(int id_exam) {
        this.id_exam = id_exam;
    }
}
