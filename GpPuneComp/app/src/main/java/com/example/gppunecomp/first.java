package com.example.gppunecomp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class first extends AppCompatActivity {
    String[] s11={"FEE","Math","C","WD","CMS"};
    ArrayAdapter<String> aa11;
    GridView gvtimefirst;
    ImageView imgviewfirst,img1,img2;
    int[] imgmath={R.drawable.mo,R.drawable.mt,R.drawable.mpr};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        imgviewfirst=(ImageView)findViewById(R.id.imgview);

        gvtimefirst=(GridView)findViewById(R.id.gvtime);
        aa11=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,s11);
        gvtimefirst.setAdapter(aa11);
        gvtimefirst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String p=aa11.getItem(position);
                if(p.equals("Math")){
                    imgviewfirst.setImageResource(imgmath[0]);
                }

            }
        });
    }
}
