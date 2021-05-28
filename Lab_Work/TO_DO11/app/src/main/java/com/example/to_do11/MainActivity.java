package com.example.to_do11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView mHello;

    public String[] mColor = {"purple_200", "purple_500", "teal_200", "teal_700"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHello = (TextView) findViewById(R.id.Hello_World);
    }


    public void changeColor(View view) {
        Random random = new Random();
        String colorName = mColor[random.nextInt(4)];
        int colorResourceName = getResources().getIdentifier(colorName,"color",getApplicationContext().getPackageName());

        int colorRs = ContextCompat.getColor(this,colorResourceName);
        mHello.setTextColor(colorRs);
    }
    public void onSavedInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("color",mHello.getCurrentTextColor());
    }
}