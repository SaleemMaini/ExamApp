package com.example.examapp.Model;

public class Data_Question {
    private int id;
    private String text;
    private int id_answer;
    private int mark;

    public Data_Question() {
    }

    public Data_Question(int id, String text, int id_answer, int mark) {
        this.id = id;
        this.text = text;
        this.id_answer = id_answer;
        this.mark = mark;
    }

    public Data_Question(String text, int id_answer, int mark) {
        this.text = text;
        this.id_answer = id_answer;
        this.mark = mark;
    }


    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getId_answer() {
        return id_answer;
    }

    public int getMark() {
        return mark;
    }
    //////////////////////////////////////////////////////

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId_answer(int id_answer) {
        this.id_answer = id_answer;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
