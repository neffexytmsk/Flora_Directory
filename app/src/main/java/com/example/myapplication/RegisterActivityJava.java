package com.example.myapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.tv.TvContract;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class RegisterActivityJava extends AppCompatActivity {
    EditText emailNameReg, namePersonReg, passwordReg, passwordConfirmReg;
    Button btnReg;
    Connection con;
    Statement stmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initReg();
    }

    public void initReg() {
        btnReg = findViewById(R.id.btnReg);
        emailNameReg = findViewById(R.id.emailReg);
        namePersonReg = findViewById(R.id.namePerson);
        passwordReg = findViewById(R.id.passwordReg);
        passwordConfirmReg = findViewById(R.id.confirmPasswordReg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((emailNameReg.getText().length() > 0 && namePersonReg.getText().length() > 0 && passwordReg.getText().length() > 0 && passwordConfirmReg.getText().length() > 0) && (passwordReg.getText().toString().equals(passwordConfirmReg.getText().toString()) && isValidEmail(emailNameReg.getText().toString()))) {
                    startActivity(new Intent(RegisterActivityJava.this, LoginActivityJava.class));
                    Toast.makeText(RegisterActivityJava.this,"Вы зарегистрированы",Toast.LENGTH_LONG).show();
                    ConnectionHelper connectionHelper = new ConnectionHelper();
                    try
                    {
                        Connection con = connectionHelper.CONN();
                        String query = "INSERT INTO Userr (Name,Mail,Password) VALUES ('"+namePersonReg.getText().toString()+"','"+emailNameReg.getText().toString()+"','"+passwordReg.getText().toString()+"') " ;
                        Statement stmt = con.createStatement();
                        stmt.executeQuery(query);
                    }
                    catch (SQLException se)
                    {
                        Log.e("ERROR", se.getMessage());
                    }
                } else if (!passwordReg.getText().toString().equals(passwordConfirmReg.getText().toString())) {
                    Toast.makeText(RegisterActivityJava.this, "Пароли не совпадают", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(RegisterActivityJava.this, "Вы не зарегистрировались", Toast.LENGTH_LONG).show();
                }

            }

        });

    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}
