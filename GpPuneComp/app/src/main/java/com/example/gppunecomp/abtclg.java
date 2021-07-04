package com.example.gppunecomp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class abtclg extends AppCompatActivity {

    private TextView tv;
    String s="The Government Polytechnic, Pune, was established in the year 1957. Thirty seven years later, in May 1994, the institute was awarded academic autonomy. Today it houses in its 28 acre campus, a main building, students hostels, classrooms for various faculties including Electronic Computers, Library, Canteen, post office and other facilities and has the capacity to groom more than 300 students in various engineering fields every year.\n" +
            "\n" +
            "Over the last four decades, the institute has produced more than 8000 diploma engineers in different disciplines, has won several awards in academics as well as socio-cultural activities and on the whole has succeeded in contributing humble positive efforts towards the building of a progressive society. ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abtclg);
        tv=(TextView)findViewById(R.id.tvabtclg);
        tv.setText(s);
    }
}
