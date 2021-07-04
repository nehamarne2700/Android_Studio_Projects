package com.example.gppunecomp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class mission extends AppCompatActivity {

    private TextView tv;
    String s= "*Update curricula in association with stakeholders.\n\n" +
            "*Modernize infrastructure & facilities.\n\n" +
            "*Set up strategic alliance with industries.\n\n" +
            "*Enhance e-governance.\n\n" +
            "*Continuous development of faculty & staff.\n\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission);
        tv=(TextView)findViewById(R.id.tvmission);
        tv.setText(s);
    }
}
