package com.example.gppunecomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tvwel;
Button bl,bs;
String s="Hey Gppian...\nWelcome to GppuneComp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvwel=(TextView)findViewById(R.id.tvwel);
        tvwel.setText(s);
        bl=(Button)findViewById(R.id.btlogin);
        bs=(Button)findViewById(R.id.btsignup);
        bl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,gpform.class);
                startActivity(intent);
            }
        });
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,gp1.class);
                startActivity(intent);
            }
        });
    }
}
