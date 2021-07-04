package com.example.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ListView lv;
    public GridView gv;
    ArrayList<String> arr=new ArrayList(5);
    String[] arr1= new String[]{"Google", "firefox", "Explorer", "MicrosoftEdge","Opera","GoogleChrome"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lv);
        gv=(GridView)findViewById(R.id.gv);
        arr.add("c");
        arr.add("c++");
        arr.add("java");
        arr.add("adJava");
        arr.add("php");
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        aa.add("JS");
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"clicked item:"+position+" "+arr.get(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });

        final ArrayAdapter<String> aa1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr1);
        gv.setAdapter(aa1);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String v=aa1.getItem(position);
                Toast.makeText(getApplicationContext(),"Item Selected :"+v,Toast.LENGTH_LONG).show();
            }
        });
    }
}
