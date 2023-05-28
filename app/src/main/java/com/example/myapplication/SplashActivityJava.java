package com.example.myapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceActivity.Header;
import android.widget.Button;

public class SplashActivityJava extends AppCompatActivity {
private int SPLASH_DISPLAY_LENGTH = 1000;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                        startActivity(new Intent(SplashActivityJava.this, LoginActivityJava.class));
                        finish();
                };
        },SPLASH_DISPLAY_LENGTH);
        }
        }