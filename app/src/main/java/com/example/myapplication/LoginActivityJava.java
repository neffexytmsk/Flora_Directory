package com.example.myapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
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
    protected void initLog() {

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
                String z = "";
                Boolean isSuccess = false;
                if ((emailNameLog.getText().length() > 0 && passwordLog.getText().length() > 0) && isValidEmail(emailNameLog.getText().toString())) {
                    startActivity(new Intent(LoginActivityJava.this, MainActivityJava.class));
                    ConnectionHelper connectionHelper = new ConnectionHelper();
                    if (!(emailNameLog.getText().toString().equals(emailNameReg.getText().toString())) && !(passwordLog.getText().toString().equals(passwordReg.getText().toString()))) {
                        try {
                                Connection con = connectionHelper.CONN();
                                String query = "SELECT * FROM Userr WHERE Mail='" + emailNameLog.getText().toString() + "' and Password='" + passwordLog.getText().toString() + "'";
                                Statement stmt = con.createStatement();
                                stmt.executeQuery(query);
                        } catch (Exception ex) {
                            isSuccess = false;
                            z = "Exceptions";
                        }
                    }
                    else {
                        Toast.makeText(LoginActivityJava.this,"Аккаунта не существует",Toast.LENGTH_LONG).show();
                    }
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