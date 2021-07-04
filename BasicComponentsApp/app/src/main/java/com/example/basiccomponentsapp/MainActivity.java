package com.example.basiccomponentsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] c = new String[]{"Pune", "Mumbai", "Nashik", "Jalgao", "Other"};
    //String[] s = new String[]{"Maharashtra", "Manipur", "Karnataka", "Uttarpradesh", "Chattisgad"};
    Spinner sp;
    EditText ename;
    AutoCompleteTextView autoCompleteTextView;
    RadioGroup radioGroup;
    RadioButton r1, r2;
    CheckBox c1, c2, c3;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ename = (EditText) findViewById(R.id.etName);
        autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.actv);
        radioGroup = (RadioGroup) findViewById(R.id.rgGender);
        c1 = (CheckBox) findViewById(R.id.cbFirst);
        c2 = (CheckBox) findViewById(R.id.cbSecond);
        c3 = (CheckBox) findViewById(R.id.cbThird);

        demo.name = ename.getText().toString();
        //demo.state=autoCompleteTextView.getText().toString();
        int rid = radioGroup.getCheckedRadioButtonId();
        r1 = (RadioButton) findViewById(rid);
        demo.gen = r1.getText().toString();
        if (c1.isChecked()) {
            demo.year = demo.year + c1.getText().toString();
        }
        if (c2.isChecked()) {
            demo.year = demo.year + c2.getText().toString();
        }
        if (c3.isChecked()) {
            demo.year = demo.year + c3.getText().toString();
        }

        ok = (Button) findViewById(R.id.btOk);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        sp=(Spinner)findViewById(R.id.spCity);
        sp.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,c);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),c[position] , Toast.LENGTH_LONG).show();
        demo.city=c[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}


