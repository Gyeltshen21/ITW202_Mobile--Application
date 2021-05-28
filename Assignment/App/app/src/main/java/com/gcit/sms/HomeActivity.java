package com.gcit.sms;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private androidx.appcompat.widget.Toolbar toolbar;
    private Menu menu;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    String sCode;
    private Context context = HomeActivity.this;
    private DatabaseReference databaseReference;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        String code = intent.getStringExtra("schoolCode");
        sCode = code;

        drawerLayout = (DrawerLayout) findViewById(R.id.admin_drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.adminnav);
        toolbar = (Toolbar) findViewById(R.id.admin_toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.admin_navigation_drawer_open,R.string.admin_navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.adminnav);
    }

    public void TimeTable(View view) {
        Intent intentHome = new Intent(HomeActivity.this,AdminTimeTableActivity.class);
        intentHome.putExtra("schoolCode",sCode);
        startActivity(intentHome);
    }

    public void TeacherDetails(View view) {
        Intent intentHome = new Intent(HomeActivity.this, AdminDetailsViewActivity.class);
        intentHome.putExtra("schoolCode",sCode);
        startActivity(intentHome);
    }

    public void CreateAccount(View view) {
        Intent intentHome = new Intent(HomeActivity.this,TeacherRegisterActivity.class);
        intentHome.putExtra("schoolCode",sCode);
        startActivity(intentHome);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.admin_nav_profile:
                Intent homeIntent = new Intent(this,AdminProfileActivity.class);
                homeIntent.putExtra("schoolCode",sCode);
                startActivity(homeIntent);
                break;

            case R.id.admin_nav_setting:
                Intent home = new Intent(this,AdminSettingActivity.class);
                home.putExtra("schoolCode",sCode);
                startActivity(home);
                break;

            case R.id.admin_nav_logout:
                FirebaseAuth.getInstance().signOut();
                Intent intentHome = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intentHome);
                finish();
                break;
        }
        return true;
    }
}