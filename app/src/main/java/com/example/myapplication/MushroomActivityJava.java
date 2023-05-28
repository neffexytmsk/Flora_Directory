package com.example.myapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MushroomActivityJava extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mushrooms);
        initFunction();
    }
    protected void initFunction(){
        ImageView backImage;
        backImage = findViewById(R.id.backFunM);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MushroomActivityJava.this,MainActivityJava.class));
            }
        });
    }
}