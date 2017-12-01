package com.weisico.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnOk;
    private Button btnRest;
    private EditText EdUser;
    private EditText EdPsw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOk=(Button)findViewById(R.id.BtnOk);
        btnRest=(Button)findViewById(R.id.BtnRest);
        EdUser=(EditText)findViewById(R.id.EdName);
        EdPsw=(EditText)findViewById(R.id.EdPsw);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=EdUser.getText().toString().trim();
                String password=EdPsw.getText().toString().trim();
                if (username.equals("admin")&&password.equals("admin"))
                {
                    Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent();
                    i.setClass(MainActivity.this,HomeActivity.class);
                    i.putExtra("IntentMessage",username);
                    startActivity(i);
                }else
                {
                    Toast.makeText(MainActivity.this,"登录失败"+username
                            +"/"+password,Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EdUser.setText(null);
                EdPsw.setText(null);
                //EdUser.requestFocus();
            }
        });
    }
}
