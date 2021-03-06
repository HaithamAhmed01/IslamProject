package com.example.islamproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.islamproject.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler()
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        StartHomeActivity();
                    }
                }, 2000);
    }
    public void StartHomeActivity(){
        Intent intent=new Intent(this, Homepage.class);
        startActivity(intent);
        finish();
    }
}
