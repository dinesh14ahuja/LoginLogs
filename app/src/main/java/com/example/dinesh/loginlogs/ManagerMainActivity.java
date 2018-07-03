package com.example.dinesh.loginlogs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ManagerMainActivity extends AppCompatActivity {
    TextView managerName,LoginLogs;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_main);
        String managername;
        db=new DatabaseHelper(this);
        managername=getIntent().getStringExtra("username");
        managerName=(TextView)findViewById(R.id.ManagerName);
        LoginLogs=(TextView)findViewById(R.id.logs);
        managerName.setText(managername);
        String logs=db.getAllLogs();
        LoginLogs.setText(logs);
    }
    public void managerLogOut(View v){
        Intent i = new Intent(ManagerMainActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }

}
