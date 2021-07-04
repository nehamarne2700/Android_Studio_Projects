package com.example.gppunecomp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class gpform extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String[] c = new String[]{"Pune", "Mumbai", "Nashik", "Jalgao", "Other"};
    EditText etname,etenno,etemail,etphno,etuser,etpass;
    Spinner sp;
    Button btsign;
    String name,enno,city,email,phno,user,pass;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpform);
        sp=(Spinner)findViewById(R.id.spcity);
        sp.setOnItemSelectedListener(this);
        btsign=(Button)findViewById(R.id.btsign);
        etname = (EditText) findViewById(R.id.etname);
        etenno = (EditText) findViewById(R.id.etenno);
        etemail = (EditText) findViewById(R.id.etemail);
        etphno = (EditText) findViewById(R.id.etphno);
        etuser = (EditText) findViewById(R.id.etuser);
        etpass = (EditText) findViewById(R.id.etpass);

        btsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata();
            }
        });
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,c);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp.setAdapter(aa);

        sqLiteDatabase = openOrCreateDatabase("gpcomp", Context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS GPSTUDENT(NAME VHARCHAR(50),ENNO INTEGER,CITY VARCHAR(50),MAILID VHARCHAR(50),PHNO INTEGER,USER VARCHAR(50),PASS VARCHAR(50));");
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),c[position] , Toast.LENGTH_LONG).show();
        city=c[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void savedata()
    {
        name = etname.getText().toString().trim();
        enno = etenno.getText().toString().trim();
        email = etemail.getText().toString().trim();
        phno = etphno.getText().toString().trim();
        user = etuser.getText().toString().trim();
        pass = etpass.getText().toString().trim();

            if (name.equals("") || enno.equals("") || email.equals("")||city.equals("") || phno.equals("") || user.equals("")||pass.equals("")) {
                Toast.makeText(getApplicationContext(), "fields should be filled", Toast.LENGTH_LONG).show();
            } else {
                sqLiteDatabase.execSQL("INSERT INTO GPSTUDENT(NAME,ENNO,CITY,MAILID,PHNO,USER,PASS)VALUES('"+ name +"','"+ enno +"','"+ city +"','"+ email +"','"+ phno +"','"+ user +"','"+ pass +"');");
                Toast.makeText(getApplicationContext(), "Signup Successful....", Toast.LENGTH_LONG).show();
                Intent i=new Intent(gpform.this,gp1.class);
                startActivity(i);
            }
    }
}
