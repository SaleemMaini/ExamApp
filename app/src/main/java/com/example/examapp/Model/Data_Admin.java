package com.example.examapp.Model;

public class Data_Admin {
    private int id;
    private String name;
    private String fname;
    private String lname;
    private String username;

    public Data_Admin() {
    }

    public Data_Admin(int id, String name, String fname, String lname, String username) {
        this.id = id;
        this.name = name;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
    }

    public Data_Admin(String name, String fname, String lname, String username) {
        this.name = name;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
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
    //////////////////////////////////////////////////

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
}
