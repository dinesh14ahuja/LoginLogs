package com.example.dinesh.loginlogs;

/**
 * Created by dinesh on 04-07-2018.
 */

public class Login {
    public static final String TABLE_NAME = "LoginDetails";

    public static final String COLUMN_ID = "id";
    public static final String UserName = "username";
    public static final String PassWord = "password";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String username;
    private String password;
    private String timestamp;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + UserName + " TEXT,"+ PassWord + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public Login() {
    }

    public Login(int id, String username,String password, String timestamp) {
        this.id = id;
        this.username = username;
        this.password=password;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }
    public void setPassWord(String password) {
        this.password = password;
    }
    public String getPassWord() {
        return password;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
