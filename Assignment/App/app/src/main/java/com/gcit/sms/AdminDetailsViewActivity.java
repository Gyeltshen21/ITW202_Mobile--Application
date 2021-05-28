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

public class AdminDetailsViewActivity extends AppCompatActivity {

    RecyclerView AdminRecycleView;
    AdminNewAddDetailsAdapter adminNewAddDetailsAdapter;
    FloatingActionButton AdminFloatingBar;
    String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_details_view);

        Intent intent = getIntent();
        String sCode1 = intent.getStringExtra("schoolCode");
        s1 = sCode1;

        AdminFloatingBar = (FloatingActionButton)findViewById(R.id.AdminFloatingBar);
        AdminFloatingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(getApplicationContext(),AdminAddNewDetailsActivity.class);
                intentHome.putExtra("schoolCode",s1);
                startActivity(intentHome);
            }
        });

        AdminRecycleView = (RecyclerView) findViewById(R.id.AdminPDFRecycleView);
        AdminRecycleView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<AdminNewDetailsHelperClass> options =
                new FirebaseRecyclerOptions.Builder<AdminNewDetailsHelperClass>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("SMSemployeeDetails"),AdminNewDetailsHelperClass.class)
                        .build();

        adminNewAddDetailsAdapter = new AdminNewAddDetailsAdapter(options);
        AdminRecycleView.setAdapter(adminNewAddDetailsAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adminNewAddDetailsAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adminNewAddDetailsAdapter.stopListening();
    }

    public void BackToAdminHome(View view) {
        Intent intentHome = new Intent(getApplicationContext(),HomeActivity.class);
        intentHome.putExtra("schoolCode",s1);
        startActivity(intentHome);
    }
}