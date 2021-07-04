package com.example.gppunecomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class query extends AppCompatActivity {

    ArrayList<String> s=new  ArrayList();
    ArrayAdapter aa;
    ListView l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        l1=(ListView)findViewById(R.id.lv);
        s.add("Sem Structure");
        s.add("Detension");
        s.add("Time Table");
        aa=new ArrayAdapter(this,android.R.layout.simple_list_item_1,s);
        l1.setAdapter(aa);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String p=s.get(position);
                if(p.equals("Sem Structure")){
                   // Toast.makeText(getApplicationContext(), "sem structure", Toast.LENGTH_LONG).show();
                    Intent isem=new Intent(query.this,semstructure.class);
                    startActivity(isem);
                }
                else if(p.equals("Detension")){
                    Intent idet=new Intent(query.this,detension.class);
                    startActivity(idet);
                }
                else if(p.equals("Time Table")){
                    Intent itime=new Intent(query.this,timetable.class);
                    startActivity(itime);
                }
            }
        });
    }
}
