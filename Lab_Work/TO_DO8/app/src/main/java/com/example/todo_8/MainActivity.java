package com.example.todo_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String LOG = MainActivity.class.getName();
    EditText website, location, share;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        website = (EditText) findViewById(R.id.websiteEditText);
        location = (EditText) findViewById(R.id.locationEditText);
        share = (EditText) findViewById(R.id.shareEditText);

    }

    public void website(View view) {
        String message = website.getText().toString();
        Uri url = Uri.parse(message);
        Intent sentIntent = new Intent(Intent.ACTION_VIEW,url);
        if(sentIntent.resolveActivity(getPackageManager()) != null){
            startActivity(sentIntent);
        }
        else{
            Log.d(LOG,"Implicit Message Error");
        }
    }

    public void location(View view) {
        String message = location.getText().toString();
        Uri url = Uri.parse("geo:0,0?q="+message);
        Intent sentIntent = new Intent(Intent.ACTION_VIEW,url);
        if(sentIntent.resolveActivity(getPackageManager()) != null){
            startActivity(sentIntent);
        }
        else{
            Log.d(LOG,"Implicit Message Error");
        }
    }

    public void share(View view) {
        String message = share.getText().toString();
        String mimeType = "Text/pain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with :")
                .setText(message)
                .startChooser();
    }
}