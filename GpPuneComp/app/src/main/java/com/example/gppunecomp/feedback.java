package com.example.gppunecomp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class feedback extends AppCompatActivity {
ToggleButton tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        tb=(ToggleButton)findViewById(R.id.toggleButton);
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tb.isChecked())
                {
                    AlertDialog.Builder abt=new AlertDialog.Builder(feedback.this);
                    abt.setMessage("Thank You For Your Feedback............").setCancelable(true);
                    AlertDialog a=abt.create();
                    abt.setTitle("Feedback");
                    abt.show();
                }
                else
                {
                    AlertDialog.Builder abt=new AlertDialog.Builder(feedback.this);
                    abt.setMessage("Thank You For Your Feedback.......We will look forward to improve ourself...").setCancelable(true);
                    AlertDialog a=abt.create();
                    abt.setTitle("Feedback");
                    abt.show();
                }
            }
        });

    }
}
