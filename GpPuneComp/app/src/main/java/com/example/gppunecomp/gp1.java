package com.example.gppunecomp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.logging.LogRecord;

public class gp1 extends AppCompatActivity {
EditText etuser1,etpass1;
String msg="Thank you for registering in GPPUNECOMP App ,have a nice day... :)",sub="GpPuneComp App Login",pno;
String user1,pass1;
Button btlogin1;
SQLiteDatabase sql;
Handler handler=new Handler();
int s=0;
ProgressBar pb1;
SmsManager smsManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp1);
        etuser1=(EditText)findViewById(R.id.etuser1);
        etpass1=(EditText)findViewById(R.id.etpass1);
        btlogin1=(Button) findViewById(R.id.btlogin1);
        smsManager=SmsManager.getDefault();
        btlogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });

        pb1=(ProgressBar)findViewById(R.id.pb1);
        pb1.setVisibility(View.INVISIBLE);
        sql = openOrCreateDatabase("gpcomp", Context.MODE_PRIVATE, null);
    }
    public void check()
    {
        user1=etuser1.getText().toString().trim();
        pass1=etpass1.getText().toString().trim();
        if(user1.equals("")||pass1.equals(""))
        {
            Toast.makeText(getApplicationContext(), "fields should be filled", Toast.LENGTH_LONG).show();
        }
        else {
            Cursor c = sql.rawQuery("select * from gpstudent", null);
            if (c.getCount() == 0) {
                Toast.makeText(gp1.this, "No such table exists", Toast.LENGTH_SHORT).show();
                return;
            }
            while (c.moveToNext()) {
                if (user1.equals(c.getString(5))&& pass1.equals(c.getString(6))) {
                    Toast.makeText(gp1.this, "Login successful......Welcome....", Toast.LENGTH_SHORT).show();
                    pno=c.getString(4);
                    sendmsg();
                    pb();
                }
                else if(!user1.equals(c.getString(5))&&!pass1.equals(c.getString(6)))
                {
                    //Toast.makeText(gp1.this, "No such user exists1", Toast.LENGTH_SHORT).show();
                }

            }
        }

    }

   /* public void sendEmail()
    {
        Intent ie=new Intent(Intent.ACTION_SEND);
        ie.putExtra(Intent.EXTRA_EMAIL,to);
        ie.putExtra(Intent.EXTRA_SUBJECT,sub);
        ie.putExtra(Intent.EXTRA_TEXT,msg);
        ie.setType("message/rfc822");
        startActivity(Intent.createChooser(ie,"Choose one of following"));
    }*/

    public void sendmsg()
    {
        smsManager.sendTextMessage(pno,null,msg,null,null);
        Toast.makeText(gp1.this, "msg sent", Toast.LENGTH_SHORT).show();
    }
    public void pb()
    {
        pb1.setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(s<100)
                {
                    s+=10;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pb1.setProgress(s);
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
                Intent i1=new Intent(gp1.this,gp2.class);
                startActivity(i1);
            }
        }).start();

    }
}
