package com.example.examapp.Model;

public class Data_Account {

    public String userName;
    public String password;
    public int type;

    public Data_Account() {
    }

    public Data_Account(String userName, String password, int type) {
        this.userName = userName;
        this.password = password;
        this.type = type;
    }


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getType() {
        return type;
    }
    ///////////////////////////////////////////////

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(int type) {
        this.type = type;
    }
}
