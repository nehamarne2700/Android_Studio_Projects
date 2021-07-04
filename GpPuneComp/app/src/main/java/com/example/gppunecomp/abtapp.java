package com.example.gppunecomp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class abtapp extends AppCompatActivity {

    private TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abtapp);
        t1=(TextView)findViewById(R.id.tv1);
        String s="Hello guys...Thank you so much for using this app..\n This app will help you to get exact information about Gpp computer department..and will try to solve every possible doubts...";
        t1.setText(s);
    }
}
