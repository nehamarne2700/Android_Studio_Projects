package com.example.broadcastapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btint=(Button)findViewById(R.id.btint);
        btint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BroadcastIntent();
            }
        });
    }
    public void BroadcastIntent()
    {
        Intent i=new Intent();
        i.setAction("Neha.CUSTOM_INTENT");
        sendBroadcast(i);
    }
}
