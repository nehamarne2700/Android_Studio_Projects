package com.example.blutoothapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    Button bton,btoff,btlist,btvisible;
    BluetoothAdapter ba;
    ListView lv;
    private Set<BluetoothDevice> pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bton=(Button)findViewById(R.id.bton);
        btoff=(Button)findViewById(R.id.btoff);
        btlist=(Button)findViewById(R.id.btlist);
        btvisible=(Button)findViewById(R.id.btsbtvisible);
        ba=BluetoothAdapter.getDefaultAdapter();
        lv=(ListView)findViewById(R.id.lv);
        bton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ba.isEnabled())
                {
                    Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(i,0);
                }
            }
        });
        btoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ba.disable();
            }
        });
        btvisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                startActivityForResult(i1,0);
            }
        });
        btlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list();}
        });
    }
    public void list()
    {
        pd=ba.getBondedDevices();
        ArrayList  l=new ArrayList();
        for(BluetoothDevice bd:pd)
        {
            l.add(bd.getName());
        }
        final ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,l);
        lv.setAdapter(arrayAdapter);
    }
}
