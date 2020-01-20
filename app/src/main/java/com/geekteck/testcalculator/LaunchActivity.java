package com.geekteck.testcalculator;

import androidx.annotation.Nullable;
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

    }


    public void calc_activity_change(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void change_window(View view) {
        String resu = result_tv.getText().toString();
        Intent intent = new Intent(this, LaunchActivity.class);
        intent.putExtra("result", resu);
        startActivityForResult(intent, 42);
    }



    public void getAnswer(View view) {
        Intent intent = getIntent();
        resultCalc= intent.getStringExtra("result");
        result_tv.setText(resultCalc);
    }
}
