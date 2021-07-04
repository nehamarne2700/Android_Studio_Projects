package com.example.gppunecomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gp2 extends AppCompatActivity {
    private Button abtclg;
    private Button mission;
    private Button askme,btnabt,btnfeed;
    private TextView tv;
    String s="To develop self reliant, versatile, innovative, quality conscious engineers for betterment of society.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp2);
        abtclg=(Button)findViewById(R.id.btnabtclg);
        mission=(Button)findViewById(R.id.btnmission);
        askme=(Button)findViewById(R.id.btnask);
        btnabt=(Button)findViewById(R.id.btnabt);
        btnfeed=(Button)findViewById(R.id.btnfeed);
        tv=(TextView)findViewById(R.id.tv3);
        tv.setText(s);
        abtclg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ia=new Intent(gp2.this,abtclg.class);
                startActivity(ia);
            }
        });
        mission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im=new Intent(gp2.this,mission.class);
                startActivity(im);
            }
        });
        askme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ias=new Intent(gp2.this,askme.class);
                startActivity(ias);
            }
        });
        btnabt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iatn=new Intent(gp2.this,abtapp.class);
                startActivity(iatn);
            }
        });
        btnfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ifeed=new Intent(gp2.this,feedback.class);
                startActivity(ifeed);
            }
        });

    }
}
