package com.example.basiccomponentsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
public TextView n,s,c,g,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        n=(TextView)findViewById(R.id.n2);
        s=(TextView)findViewById(R.id.s2);
        c=(TextView)findViewById(R.id.c2);
        g=(TextView)findViewById(R.id.g2);
        y=(TextView)findViewById(R.id.y2);

        n.setText(demo.name);
        s.setText(demo.state);
        c.setText(demo.city);
        g.setText(demo.gen);
        y.setText(demo.year);
    }
}
