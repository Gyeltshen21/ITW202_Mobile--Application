package com.gcit.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class TeacherDetailsActivity extends AppCompatActivity {
    RecyclerView teacherRecycleView;
    TeacherAdapter teacherAdapter;

    String sCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_details);

        Intent intent = getIntent();
        String employeeID = intent.getStringExtra("employeeID");
        sCode = employeeID;

        teacherRecycleView = (RecyclerView) findViewById(R.id.TeacherRecycleView);
        teacherRecycleView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<AdminNewDetailsHelperClass> options =
                new FirebaseRecyclerOptions.Builder<AdminNewDetailsHelperClass>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("SMSemployeeDetails"), AdminNewDetailsHelperClass.class)
                        .build();

        teacherAdapter = new TeacherAdapter(options);
        teacherRecycleView.setAdapter(teacherAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        teacherAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        teacherAdapter.stopListening();
    }

    public void BackToTeacherHome(View view) {
        Intent intent = new Intent(getApplicationContext(),TeacherHomeActivity.class);
        intent.putExtra("employeeID",sCode);
        startActivity(intent);
    }
}