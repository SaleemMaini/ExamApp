package com.example.examapp.Model;

public class Data_Student {
    public int id;
    public String name;
    public String fname;
    public String lname;
    public String username;
    public String password;
    public String id_exam;

    public Data_Student() {
    }

    public Data_Student(int id, String name, String fname, String lname, String username, String password, String id_exam) {
        this.id = id;
        this.name = name;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.id_exam = id_exam;
    }

    public Data_Student(String name, String fname, String lname, String username, String password, String id_exam) {
        this.name = name;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.id_exam = id_exam;
    }

    public Data_Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() { return password; }

    public String getId_exam() {
        return id_exam;
    }
    ////////////////////////////////////////////////////////////


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) { this.password = password; }

    public void setId_exam(String id_exam) {
        this.id_exam = id_exam;
    }
}
