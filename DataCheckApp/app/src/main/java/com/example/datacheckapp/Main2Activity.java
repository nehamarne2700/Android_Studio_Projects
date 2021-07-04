package com.example.datacheckapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText etemail1,etpassword1;
    Button btfetch;
    String email,password,p;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etemail1=(EditText)findViewById(R.id.etemail1);
        etpassword1 = (EditText) findViewById(R.id.etpassword1);
        btfetch=(Button)findViewById(R.id.btfetch);
        btfetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = etemail1.getText().toString().trim();
                password = etpassword1.getText().toString().trim();
                if (email.equals("") || password.equals("")) {
                    Toast.makeText(Main2Activity.this, "fields cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                Cursor c = sqLiteDatabase.rawQuery("select * from info1 where pass='" + password + "'", null);
                if (c.getCount() == 0) {
                    Toast.makeText(Main2Activity.this, "No such data exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                while (c.moveToNext()) {
                    if (email.equals(c.getString(3))) {
                        Toast.makeText(Main2Activity.this, "Fetch successful......Welcome....", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(Main2Activity.this, Main3Activity.class);
                        intent1.putExtra("em",email);
                        startActivity(intent1);
                    } else {
                        Toast.makeText(Main2Activity.this, "No such data exists", Toast.LENGTH_SHORT).show();
                    }

                }
            }

        });
        sqLiteDatabase = openOrCreateDatabase("information", Context.MODE_PRIVATE, null);
    }
}
