package com.example.myapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivityJava extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCategories();
    }
    protected void initCategories(){
        ImageView catMush = findViewById(R.id.categoryMushrooms);
                ImageView catBAF = findViewById(R.id.categoryBerriesAndFruits);
                ImageView catTr = findViewById(R.id.categoryTrees);
                ImageView catFl = findViewById(R.id.categoryFlowers);
                ImageView catSh = findViewById(R.id.categoryShrubs);
                ImageView catOh = findViewById(R.id.categoryOthers);
                ImageView userbtn = findViewById(R.id.userLog);
                catMush.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivityJava.this,MushroomActivityJava.class));
                    }
                });
        catBAF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityJava.this,BandFActivityJava.class));
            }
        });
        catTr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityJava.this,TreesActivityJava.class));
            }
        });
        catFl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityJava.this,FlowersActivityJava.class));
            }
        });
        catSh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityJava.this,ShrubsActivityJava.class));
            }
        });
        catOh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityJava.this,OthersActivityJava.class));
            }
        });
        userbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityJava.this,UserActivityJava.class));
            }
        });
    }
}