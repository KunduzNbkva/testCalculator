package com.geekteck.testcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LaunchActivity extends AppCompatActivity {
    TextView result_tv;
    Button share, get;
    String resultCalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        result_tv = findViewById(R.id.launch_tv);

        Intent intent = getIntent();

        if (intent != null) {
            resultCalc = intent.getStringExtra("result");
            if (resultCalc != null) {
                result_tv.setText(resultCalc);
            } else {
                result_tv.setText("error");
            }

        }

    }



    public void calc_activity_change(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

}
