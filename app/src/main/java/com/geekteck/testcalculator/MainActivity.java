package com.geekteck.testcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    public static String first_key = "FIRST_KEY";
    public static String second_key = "SECOND_KEY";
    public static String operation_key = "OPERATION_KEY";
    public static String result_key = "RESULT_KEY";


    Double firstValues;
    Double secondValues;
    String operation;
    Double result;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.result_txt_view);

    }


    public void onNumbersClick(View view) {
        switch (view.getId()) {
            case R.id.zero:
                textView.append("0");
                break;
            case R.id.one:
                textView.append("1");
                break;
            case R.id.two:
                textView.append("2");
                break;
            case R.id.three:
                textView.append("3");
                break;
            case R.id.four:
                textView.append("4");
                break;
            case R.id.five:
                textView.append("5");
                break;
            case R.id.six:
                textView.append("6");
                break;
            case R.id.seven:
                textView.append("7");
                break;
            case R.id.eight:
                textView.append("8");
                break;
            case R.id.nine:
                textView.append("9");
                break;
            case R.id.dot:
                if (textView != null && textView.length() > 0) {
                    textView.append(".");
                } else {
                    textView.setText("");
                }
                break;
            case R.id.clear:
                textView.setText("");
                break;


        }
    }

    @SuppressLint("SetTextI18n")
    public void onOperationsClick(View view) {


        switch (view.getId()) {
            case R.id.plus:
                operation = "+";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "+");
                break;

            case R.id.minus:
                operation = "-";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "-");
                break;
            case R.id.multiply:
                operation = "*";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "*");
                break;
            case R.id.divide:
                operation = "/";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "/");
                break;


            case R.id.equal:
                if (operation != null) {
                    String second = textView.getText().toString().replace(firstValues + operation + "", "");
                    secondValues = Double.valueOf(second);

                    switch (operation) {
                        case "+":
                            result = firstValues + secondValues;
                            textView.setText(firstValues + "+" + secondValues + "=" + result);
                            break;
                        case "-":
                            result = firstValues - secondValues;
                            textView.setText(firstValues + "-" + secondValues + "=" + result);
                            break;
                        case "*":
                            result = firstValues * secondValues;
                            textView.setText(firstValues + "*" + secondValues + "=" + result);
                            break;
                        case "/":
                            result = firstValues / secondValues;
                            textView.setText(firstValues + "/" + secondValues + "=" + result);
                            break;
                    }
                }
            default:
                break;
        }
    }

    public void send() {
        String resu = textView.getText().toString();
        Intent intent = new Intent(this, LaunchActivity.class);
        intent.putExtra("result", resu);
        startActivityForResult(intent, 42);
    }

    public void change_window(View view) {
        String resu = textView.getText().toString();
        Intent intent = new Intent(this, LaunchActivity.class);
        intent.putExtra("result", resu);
        startActivityForResult(intent, 42);
    }


}