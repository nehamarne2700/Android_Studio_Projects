package com.example.toggleapp;

import android.service.autofill.TextValueSanitizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv;
    private ToggleButton tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.tv);
        tb=(ToggleButton)findViewById(R.id.tb);
        tb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (tb.isChecked())
        {
            tv.setText("vibrate on");
        }
        else
        {
            tv.setText("vibrate off");
        }
    }
}
