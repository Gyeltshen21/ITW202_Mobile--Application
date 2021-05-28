package com.gcit.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class TeacherTimeTableActivity extends AppCompatActivity {

    RecyclerView TeacherRecycleView;
    TeacherTimeTableAdapter TeacherTimeTableAdapter;
    String sCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_time_table);

        Intent intent = getIntent();
        String employeeID = intent.getStringExtra("employeeID");
        sCode = employeeID;

        TeacherRecycleView = (RecyclerView) findViewById(R.id.AdminTimeTableRecycleView);
        TeacherRecycleView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<AdminTimeTableHelperClass> options =
                new FirebaseRecyclerOptions.Builder<AdminTimeTableHelperClass>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("SMSTIMETABLE"), AdminTimeTableHelperClass.class)
                        .build();

        TeacherTimeTableAdapter = new TeacherTimeTableAdapter(options);
        TeacherRecycleView.setAdapter(TeacherTimeTableAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        TeacherTimeTableAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        TeacherTimeTableAdapter.stopListening();
    }

    public void BackToTeacherHome(View view) {
        Intent intent = new Intent(getApplicationContext(),TeacherHomeActivity.class);
        intent.putExtra("employeeID",sCode);
        startActivity(intent);
    }
}