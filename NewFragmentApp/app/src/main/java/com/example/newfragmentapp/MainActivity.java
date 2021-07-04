package com.example.newfragmentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btopen;
Boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
        final android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
        btopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag)
                {
                    Fragment11 f1=new Fragment11();
                    ft.add(R.id.rl1,f1);
                    ft.addToBackStack(null);
                    ft.commit();
                    btopen.setText("Open 2nd fragment");
                    flag=true;
                }
                else{
                    Fragment12 f2=new Fragment12();
                    ft.add(R.id.rl1,f2);
                    ft.addToBackStack(null);
                    ft.commit();
                    btopen.setText("Open 1st fragment");
                    flag=false;
                }
            }
        });
    }
}
