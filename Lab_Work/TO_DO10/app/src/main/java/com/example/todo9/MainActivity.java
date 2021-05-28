package com.example.todo9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText val1, val2;
    private TextView resultFinal;
    public Calculator cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal = new Calculator();
        val1 = (EditText) findViewById(R.id.value1);
        val2 = (EditText) findViewById(R.id.value2);
        resultFinal = (TextView) findViewById(R.id.textView);
    }

    public void Add(View view) {
        String value1 = val1.getText().toString();
        String value2 = val2.getText().toString();
        double result = cal.Add(Double.valueOf(value1),Double.valueOf(value2));
        resultFinal.setText(String.valueOf(result));
        Log.d("LOG_TAG","DEBUG MODE");
    }

    public void sub(View view) {
        String value1 = val1.getText().toString();
        String value2 = val2.getText().toString();
        double result = cal.Sub(Double.valueOf(value1),Double.valueOf(value2));
        resultFinal.setText(String.valueOf(result));
        Log.d("LOG_TAG","DEBUG MODE");
    }

    public void mult(View view) {
        String value1 = val1.getText().toString();
        String value2 = val2.getText().toString();
        double result = cal.Mult(Double.valueOf(value1),Double.valueOf(value2));
        resultFinal.setText(String.valueOf(result));
        Log.d("LOG_TAG","DEBUG MODE");
    }

    public void div(View view) {
        String value1 = val1.getText().toString();
        String value2 = val2.getText().toString();
        double result = cal.Div(Double.valueOf(value1),Double.valueOf(value2));
        resultFinal.setText(String.valueOf(result));
        Log.d("LOG_TAG","DEBUG MODE");
    }
}