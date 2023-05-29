package com.example.myapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;

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