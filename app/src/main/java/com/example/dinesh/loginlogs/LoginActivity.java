package com.example.dinesh.loginlogs;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText Username,Password;
    Button LoginUserbutton;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        Username=(EditText)findViewById(R.id.Username);
        Password=(EditText)findViewById(R.id.Password);
    }
    public void LoginOnclick(View v){

        String username,password;
        username=Username.getText().toString();
        password=Password.getText().toString();

        if(username!=null && password!=null){

            long id=db.insertUser(username,password);
            if(id!=-1){
            Toast.makeText(this, "Login Succesfull", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(LoginActivity.this,UserMainActivity.class);
            i.putExtra("Username",username);
            startActivity(i);
            finish();}
            else{
                Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Fill all Required feilds", Toast.LENGTH_SHORT).show();
        }

    }
}
