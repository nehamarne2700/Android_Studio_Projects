package com.example.datacheckapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etname,etdiv,etmarks,etemail,etpassword;
    Button btsubmit,btskip;
    String name,div,marks,email,password;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname=(EditText)findViewById(R.id.etname);
        etdiv = (EditText) findViewById(R.id.etdiv);
        etmarks= (EditText) findViewById(R.id.etmarks);
        etemail = (EditText) findViewById(R.id.etemail);
        etpassword=(EditText)findViewById(R.id.etpassword);
        btsubmit= (Button) findViewById(R.id.btsubmit);
        btskip=(Button)findViewById(R.id.btskip);
        btskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                name = etname.getText().toString().trim();
                marks = etmarks.getText().toString().trim();
                email = etemail.getText().toString().trim();
                div = etdiv.getText().toString().trim();
                password=etpassword.getText().toString().trim();
                if (name.equals("") || marks.equals("") || email.equals("")||div.equals("")||password.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "fields should be filled", Toast.LENGTH_LONG).show();
                }
                else
                {
                    sqLiteDatabase.execSQL("INSERT INTO INFO1(NAME,DIV,MARKS,EMAIL,PASS)VALUES('" + name + "','"+div+"','"+marks+"','" + email + "','" + password + "');");
                    Toast.makeText(getApplicationContext(), "Reord Saved", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }
            }
        });
        sqLiteDatabase = openOrCreateDatabase("information", Context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS INFO1(NAME VHARCHAR(50),DIV VARCHAR(10),MARKS INTEGER,EMAIL VHARCHAR(20),PASS VARCHAR(20));");
    }
}
