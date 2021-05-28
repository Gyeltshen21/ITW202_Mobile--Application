package com.gcit.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class AdminTimeTableActivity extends AppCompatActivity {

    RecyclerView AdminTimeTableRecycleView;
    AdminTimeTableAdapter AdminTimeTableAdapter;
    FloatingActionButton AdminFloatingBar;
    String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_time_table);

        Intent intent = getIntent();
        String sCode1 = intent.getStringExtra("schoolCode");
        s1 = sCode1;

        AdminFloatingBar = (FloatingActionButton)findViewById(R.id.AdminFloatingBar);
        AdminFloatingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(getApplicationContext(),AdminTimeTableUploadActivity.class);
                intentHome.putExtra("schoolCode",s1);
                startActivity(intentHome);
            }
        });

        AdminTimeTableRecycleView = (RecyclerView) findViewById(R.id.AdminTimeTableRecycleView);
        AdminTimeTableRecycleView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<AdminTimeTableHelperClass> options =
                new FirebaseRecyclerOptions.Builder<AdminTimeTableHelperClass>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("SMSTIMETABLE"),AdminTimeTableHelperClass.class)
                        .build();

        AdminTimeTableAdapter = new AdminTimeTableAdapter(options);
        AdminTimeTableRecycleView.setAdapter(AdminTimeTableAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        AdminTimeTableAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        AdminTimeTableAdapter.stopListening();
    }

    public void BackToAdminHome(View view) {
        Intent intentHome = new Intent(getApplicationContext(),HomeActivity.class);
        intentHome.putExtra("schoolCode",s1);
        startActivity(intentHome);
    }
}