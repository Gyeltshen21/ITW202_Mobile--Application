package com.example.to_do12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public static final String LOG = MainActivity.class.getName();
    FloatingActionButton floatingActionButton;
    String phone = "111-111-111";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.callFloatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri url = Uri.parse("tel:"+phone);
                Intent sentIntent = new Intent(Intent.ACTION_VIEW,url);
                if(sentIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(sentIntent);
                }
                else{
                    Log.d(LOG,"Implicit Message Error");
                }
            }
        });
    }

    public void donut(View view) {
        Toast.makeText(this,"You ordered a donut",Toast.LENGTH_SHORT).show();
    }

    public void ice_cream(View view) {
        Toast.makeText(this,"You ordered a ice cream",Toast.LENGTH_SHORT).show();
    }

    public void froyo(View view) {
        Toast.makeText(this,"You ordered a froyo",Toast.LENGTH_SHORT).show();
    }
}