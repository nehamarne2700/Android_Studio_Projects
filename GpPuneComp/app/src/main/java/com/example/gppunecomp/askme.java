package com.example.gppunecomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class askme extends AppCompatActivity {

    private Button photo;
    private Button course;
    private Button query;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_askme);
        photo=(Button)findViewById(R.id.btnphoto);
        course=(Button)findViewById(R.id.btncourse);
        query=(Button)findViewById(R.id.btnqueries);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(askme.this,photo.class);
                startActivity(i);
            }
        });
        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(askme.this,course.class);
                startActivity(i);
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(askme.this, query.class);
                startActivity(i);
            }
        });
    }
}
