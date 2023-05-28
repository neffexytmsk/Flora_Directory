package com.example.myapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ShrubsActivityJava extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shrubs);
        initFunction();
    }
    protected void initFunction(){
        ImageView backImage;
        backImage = findViewById(R.id.backFunSh);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShrubsActivityJava.this,MainActivityJava.class));
            }
        });
    }
}