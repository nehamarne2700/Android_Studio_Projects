package com.example.gppunecomp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class timetable extends AppCompatActivity {
    String[] s={"G","H","N","B1","B2","B3","A1","A2","A3"};
    ArrayAdapter<String> aa;
    GridView gvtime;
    ImageView imgview;
    int[] img={R.drawable.fg,R.drawable.fh,R.drawable.fn,R.drawable.sbo,R.drawable.sbt,R.drawable.sbth,R.drawable.tao,R.drawable.tat,R.drawable.tath};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        imgview=(ImageView)findViewById(R.id.imgview);
        gvtime=(GridView)findViewById(R.id.gvtime);
        aa=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,s);
        gvtime.setAdapter(aa);
        gvtime.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String p=aa.getItem(position);
                if(p.equals("G")){
                imgview.setImageResource(img[0]);
                }
                else if(p.equals("H")){
                    imgview.setImageResource(img[1]);
                }
                else if(p.equals("N")){
                    imgview.setImageResource(img[2]);
                }
                else if(p.equals("B1")){
                    imgview.setImageResource(img[3]);
                }
                else if(p.equals("B2")){
                    imgview.setImageResource(img[4]);
                }
                else if(p.equals("B3")){
                    imgview.setImageResource(img[5]);
                }
                else if(p.equals("A1")){
                    imgview.setImageResource(img[6]);
                }
                else if(p.equals("A2")){
                    imgview.setImageResource(img[7]);
                }
                else if(p.equals("A3")){
                    imgview.setImageResource(img[8]);
                }
            }
        });
    }
}
