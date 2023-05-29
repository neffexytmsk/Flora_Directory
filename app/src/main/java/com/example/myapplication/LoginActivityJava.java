package com.example.myapplication;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.sourceforge.jtds.jdbcx.proxy.ConnectionProxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginActivityJava extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initLog();
    }
    public void initLog() {

        Button btnLog = findViewById(R.id.buttonLogin);
        TextView btnReg = findViewById(R.id.regHelp);
        EditText emailNameLog = findViewById(R.id.emailLog);
        EditText emailNameReg = findViewById(R.id.emailReg);
        EditText passwordReg = findViewById(R.id.passwordReg);
        EditText passwordLog = findViewById(R.id.passwordLog);
        TextView btnDostup = findViewById(R.id.nameDostup);
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((emailNameLog.getText().length() > 0 && passwordLog.getText().length() > 0) && isValidEmail(emailNameLog.getText().toString())) {
                    ConnectionHelper connectionHelper = new ConnectionHelper();
                    startActivity(new Intent(LoginActivityJava.this, MainActivityJava.class));
                }
                else if (emailNameLog.getText().length() == 0 && passwordLog.getText().length() == 0) {
                    Toast.makeText(LoginActivityJava.this, "Введите данные", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(LoginActivityJava.this, "Неправильные логин или пароль", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivityJava.this, RegisterActivityJava.class));
            }
        });
        btnDostup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity((new Intent(LoginActivityJava.this, PasswordDostupActivityJava.class)));
            }
        });
    }
    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}