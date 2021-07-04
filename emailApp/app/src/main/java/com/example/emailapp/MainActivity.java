package com.example.emailapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
EditText et1,et2,et3;
TextView tv1,tv2;
Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        tv1=(TextView)findViewById(R.id.tv1);
        tv1=(TextView)findViewById(R.id.tv1);
        bt1=(Button)findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }
    public void sendMail()
    {
        String receiveList=et1.getText().toString();
        String[] receive=receiveList.split(",");
        String subject=et2.getText().toString();
        String msg=et3.getText().toString();
        Intent i=new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL,receive);
        i.putExtra(Intent.EXTRA_SUBJECT,subject);
        i.putExtra(Intent.EXTRA_TEXT,msg);
        i.setType("msg/rfc822");
        startActivity(i.createChooser(i,"choose any of the client:"));


    }
}
