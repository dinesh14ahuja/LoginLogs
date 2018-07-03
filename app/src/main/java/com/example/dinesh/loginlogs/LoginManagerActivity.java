package com.example.dinesh.loginlogs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginManagerActivity extends AppCompatActivity {
    EditText ManagerUsername,managerPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_manager);
        ManagerUsername=(EditText)findViewById(R.id.managerUsername);
        managerPassword=(EditText)findViewById(R.id.managerPassword);

    }
    public void managerOnclick(View v){
        String managerusername,managerpassword;
        managerusername=ManagerUsername.getText().toString();
        managerpassword=managerPassword.getText().toString();
        if(managerusername.equals("SS")&&managerpassword.equals("SS")) {
            Intent i = new Intent(LoginManagerActivity.this, ManagerMainActivity.class);
            i.putExtra("username", managerusername);
            startActivity(i);
            finish();
        }
        else{
            Toast.makeText(this, "Please write username and password as SS", Toast.LENGTH_SHORT).show();
        }
    }
}
