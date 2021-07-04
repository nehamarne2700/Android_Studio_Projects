package com.example.progressapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import java.lang.*;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    Button b;
    Handler handler=new Handler();
    int s=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb=(ProgressBar)findViewById(R.id.pb);
        b=(Button)findViewById(R.id.btstart);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbstart();
            }
        });
    }
    public void pbstart()
    {
        pb.setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(s<100)
                {
                    s+=10;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pb.setProgress(s);
                        }
                    });
                    try {
                        Thread.sleep(200);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

