package com.example.gppunecomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class course extends AppCompatActivity {
Button btnfirst,btnsecond,btnthird;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        btnfirst=(Button)findViewById(R.id.btnfirst);
        btnsecond=(Button) findViewById(R.id.btnsecond);
        btnthird=(Button) findViewById(R.id.btnthird);
        btnfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i1=new Intent(course.this,first.class);
               startActivity(i1);
            }
        });
    }
}
