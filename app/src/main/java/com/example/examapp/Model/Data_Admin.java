package com.example.examapp.Model;

public class Data_Admin {
    public int id;
    public String name;
    public String fname;
    public String lname;
    public String username;
    public String password;

    public Data_Admin() {
    }

    public Data_Admin(int id, String name, String fname, String lname, String username, String password) {
        this.id = id;
        this.name = name;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
    }

    public Data_Admin(String name, String fname, String lname, String username, String password) {
        this.name = name;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
    }

    public Data_Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
