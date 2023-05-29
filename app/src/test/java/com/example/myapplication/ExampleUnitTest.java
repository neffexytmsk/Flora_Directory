package com.example.myapplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Test;

import org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
public class ExampleUnitTest extends  LoginActivityJava{
    Button btnLog = findViewById(R.id.buttonLogin);
    EditText emailNameLog = findViewById(R.id.emailLog);
    EditText emailNameReg = findViewById(R.id.emailReg);
    EditText passwordReg = findViewById(R.id.passwordReg);
    EditText passwordLog = findViewById(R.id.passwordLog);
    @Test
    public void addition_isCorrect1() {
    }
}