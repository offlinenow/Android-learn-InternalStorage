package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myapplication.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        try {
            FileOutputStream fileOutputStream = openFileOutput("text.txt", MODE_PRIVATE);
            OutputStream out = new BufferedOutputStream(fileOutputStream);
            String name = ((EditText) findViewById(R.id.EditText1)).getText().toString();
            String id = ((EditText) findViewById(R.id.EditText2)).getText().toString();
            String string = "姓名：" + name + " " + "学号：" + id;

            out.write(string.getBytes());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void PopUpWindow(View view) {
        int BUFFER_SIZE = 8192;
        try {
            FileInputStream fileInputStream = openFileInput("text.txt");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF8"), BUFFER_SIZE);
            Toast.makeText(MainActivity.this, bufferedReader.readLine(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
