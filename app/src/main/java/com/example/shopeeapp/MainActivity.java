package com.example.shopeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBtn, signUpBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUpBtn = findViewById(R.id.main_sign_up_btn);
        loginBtn = findViewById(R.id.main_login_btn);
        signUpBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==signUpBtn){
            startActivity(new Intent(MainActivity.this, RegisterActivity.class));
        }else if(v==loginBtn){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }
}