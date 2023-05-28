package com.example.myapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PasswordDostupActivityJava extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_dostup);
        initDostup();
    }
    protected void initDostup(){
        Button btnDostup = findViewById(R.id.buttonDostup);
                EditText emailNameDostup = findViewById(R.id.emailDostup);
                EditText passwordDostup = findViewById(R.id.passwordDostup);
                EditText passwordConfirmDostup = findViewById(R.id.confirmPasswordDostup);
                btnDostup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if((emailNameDostup.getText().length()>0&&passwordDostup.getText().length()>0&&passwordConfirmDostup.getText().length()>0)&& (passwordDostup.getText().toString().equals(passwordConfirmDostup.getText().toString()) &&isValidEmail(emailNameDostup.getText().toString()))){
                            startActivity(new Intent(PasswordDostupActivityJava.this,LoginActivityJava.class));
                        }
                        else if (!passwordDostup.getText().toString().equals(passwordConfirmDostup.getText().toString())) {
                            Toast.makeText(PasswordDostupActivityJava.this, "Пароли не совпадают", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(PasswordDostupActivityJava.this, "Введите данные", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}