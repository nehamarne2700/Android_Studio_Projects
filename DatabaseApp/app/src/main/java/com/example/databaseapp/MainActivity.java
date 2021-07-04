package com.example.databaseapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etsearch, etname, etid, etmarks;
    String marks, mailid, search, name;
    Button btadd, btdelete, btselect, btselectall, btupdate;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etsearch = (EditText) findViewById(R.id.etsearch);
        etname = (EditText) findViewById(R.id.etname);
        etid = (EditText) findViewById(R.id.etid);
        etmarks = (EditText) findViewById(R.id.etmarks);

        btadd = (Button) findViewById(R.id.btadd);
        btdelete = (Button) findViewById(R.id.btdelete);
        btselect = (Button) findViewById(R.id.btselect);
        btselectall = (Button) findViewById(R.id.btselectall);
        btupdate = (Button) findViewById(R.id.btupdate);

        btadd.setOnClickListener(this);
        btdelete.setOnClickListener(this);
        btselect.setOnClickListener(this);
        btselectall.setOnClickListener(this);
        btupdate.setOnClickListener(this);
        sqLiteDatabase = openOrCreateDatabase("student", Context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS STUD(STUDID INTEGER PRIMARY KEY AUTOINCREMENT,NAME VHARCHAR(50),MAILID VHARCHAR(20),MARKS INTEGER);");
    }

    @Override
    public void onClick(View v) {
        name = etname.getText().toString().trim();
        marks = etmarks.getText().toString().trim();
        mailid = etid.getText().toString().trim();
        search = etsearch.getText().toString().trim();
        if (v.getId() == R.id.btadd) {
            if (name.equals("") || marks.equals("") || mailid.equals("")) {
                Toast.makeText(getApplicationContext(), "fields should be filled", Toast.LENGTH_LONG).show();
            } else {
                sqLiteDatabase.execSQL("INSERT INTO STUD(NAME,MAILID,MARKS)VALUES('" + name + "','" + mailid + "','" + marks + "');");
                Toast.makeText(getApplicationContext(), "Reord Saved", Toast.LENGTH_LONG).show();
            }
        } else if (v.getId() == R.id.btdelete) {
            if (search.equals("")) {
                Toast.makeText(this, "please enter student name", Toast.LENGTH_SHORT).show();
                return;
            }
            Cursor c = sqLiteDatabase.rawQuery("select * from stud where name='" + search + "'", null);
            if (c.moveToFirst()) {
                sqLiteDatabase.execSQL("delete from stud where name='" + search + "'");
                Toast.makeText(this, "Record deleted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "record not found", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btselectall) {
            Cursor c = sqLiteDatabase.rawQuery("select * from stud ", null);
            if (c.getCount() == 0) {
                Toast.makeText(this, "database is empty", Toast.LENGTH_SHORT).show();
                return;
            }
            StringBuffer buff = new StringBuffer();
            while (c.moveToNext()) {
                buff.append("student name:" + c.getString(1) + "\n");
                buff.append("email:" + c.getString(2) + "\n");
                buff.append("marks:" + c.getString(3) + "\n");
            }
            //Toast.makeText(buff.toString(),"data is",Toast.LENGTH_LONG).show();
            Toast.makeText(this, "data is:" + buff, Toast.LENGTH_LONG).show();
        } else if (v.getId() == R.id.btselect) {
            if (search.equals("")) {
                Toast.makeText(this, "enter stud name", Toast.LENGTH_SHORT).show();
                return;
            }
            Cursor c = sqLiteDatabase.rawQuery("select * from stud where name='" + search + "'", null);
            if (c.moveToFirst()) {
                etname.setText(c.getString(1));
                etid.setText(c.getString(2));
                etmarks.setText(c.getString(3));
            } else {
                Toast.makeText(this, "data not found", Toast.LENGTH_SHORT).show();
            }

        } else if (v.getId() == R.id.btupdate) {
            if (search.equals("")) {
                Toast.makeText(this, "please enter student name", Toast.LENGTH_SHORT).show();
                return;
            }
            Cursor c = sqLiteDatabase.rawQuery("select * from stud where name='" + search + "'", null);
            if (c.moveToFirst()) {
                if (name.equals("") || marks.equals("") || mailid.equals("")) {
                    Toast.makeText(this, "fields cant be kept empty", Toast.LENGTH_SHORT).show();
                } else {
                    sqLiteDatabase.execSQL("update stud set name='" + name + "',mailid='" + mailid + "',marks='" + marks + "',where name='" + search + "'",null);
                    Toast.makeText(this, "record updated", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "data not found", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
