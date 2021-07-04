package com.example.datacheckapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
String print="Welcome ",em;
TextView tv;
SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent2=getIntent();
        em=(String)intent2.getStringExtra("em");
        tv=(TextView)findViewById(R.id.textView);
        sqLiteDatabase = openOrCreateDatabase("information", Context.MODE_PRIVATE, null);
        Cursor c = sqLiteDatabase.rawQuery("select * from info1 where email='" + em + "'", null);
        if (c.moveToFirst()) {
            print=print+c.getString(0)+"\nYou are from "+c.getString(1)+"\nYou have got "+c.getString(2)+" marks";
            tv.setText(print);
        } else {
            Toast.makeText(this, "data not found", Toast.LENGTH_SHORT).show();
        }
    }
}
