package com.example.dinesh.loginlogs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UserMainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        String username = getIntent().getStringExtra("Username");
        textView=(TextView)findViewById(R.id.userName);
        textView.setText(username);
    }
    public void LogoutOnclick(View v){
        Intent i = new Intent(UserMainActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
