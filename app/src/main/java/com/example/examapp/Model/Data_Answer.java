package com.example.examapp.Model;

public class Data_Answer {
    public int id;
    public String text;
    public int status;
    public int id_question;

    public Data_Answer() {
    }

    public Data_Answer(int id, String text, int status, int id_question) {
        this.id = id;
        this.text = text;
        this.status = status;
        this.id_question = id_question;
    }

    public Data_Answer(String text, int status, int id_question) {
        this.text = text;
        this.status = status;
        this.id_question = id_question;
    }


    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getStatus() {
        return status;
    }

    public int getId_question() {
        return id_question;
    }
    /////////////////////////////////////////////////////

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

}
