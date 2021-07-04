package com.example.nikita;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.audioapp.R;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    Button btstart,btstop,btstart1,btstop1;
    MediaRecorder mr;
    MediaPlayer mp;
    String path="";
    final int REQUEST_PERMISSION_CODE=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btstart=(Button)findViewById(R.id.btstart);
        btstop=(Button)findViewById(R.id.btstop);
        btstart1=(Button)findViewById(R.id.btstart1);
        btstop1=(Button)findViewById(R.id.btstop1);

        btstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + UUID.randomUUID().toString() + "_audio_record_3gp";
                    setupMediaRecorder();
                    try {
                        mr.prepare();
                        mr.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(MainActivity.this, "Recording............", Toast.LENGTH_LONG).show();
            }

        });
        btstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mr.stop();
                Toast.makeText(MainActivity.this,"Recording stopped.....",Toast.LENGTH_LONG).show();
            }
        });
        btstart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp=new MediaPlayer();
                try
                {
                    mp.setDataSource(path);
                    mp.prepare();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                mp.start();
                Toast.makeText(MainActivity.this,"playing audio.................",Toast.LENGTH_LONG).show();
            }
        });
        btstop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp!=null)
                {
                    mp.stop();
                    mp.release();
                    setupMediaRecorder();
                }
                Toast.makeText(MainActivity.this,"play stopped............",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void setupMediaRecorder()
    {
        mr=new MediaRecorder();
        mr.setAudioSource(MediaRecorder.AudioSource.MIC);
        mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mr.setOutputFile(path);
    }
    /*private void requestPermission()
    {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.RECORD_AUDIO},REQUEST_PERMISSION_CODE);
    }
    private boolean checkPermissionFromDevice()
    {
        Toast.makeText(MainActivity.this, "in check", Toast.LENGTH_LONG).show();
        int write_result= ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int record_audio=ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO);
        return write_result== PackageManager.PERMISSION_GRANTED && record_audio==PackageManager.PERMISSION_GRANTED;
    }*/

}
