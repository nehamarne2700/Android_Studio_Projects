package com.example.wifiapp;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button bton,btoff;
WifiManager wifiManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bton=(Button)findViewById(R.id.bton);
        btoff=(Button)findViewById(R.id.btoff);

        bton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wifiManager=(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(true);
            }
        });
        btoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wifiManager=(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifiManager.setWifiEnabled(false);
            }
        });
    }
}
