package com.gcit.sms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextInputLayout editTextSchoolCode, editTextPassword;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        editTextSchoolCode = (TextInputLayout) findViewById(R.id.editTextLogin_SchoolCode);
        editTextPassword = (TextInputLayout) findViewById(R.id.editTextTextLogin_Password);
    }

    public void callHomePage(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        if (!validateSchoolCode() | !validatePassword()) {
            progressDialog.dismiss();
            return;
        }
        //Admin Condition
        else {
            int countNo = editTextSchoolCode.getEditText().length();
            System.out.println("COUNT" +countNo);
            if(countNo == 3){
                String schoolCode = editTextSchoolCode.getEditText().getText().toString().trim();
                String password = editTextPassword.getEditText().getText().toString().trim();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("SMSadmin");
                Query checkUser = databaseReference.orderByChild("schoolCode").equalTo(schoolCode);
                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            editTextSchoolCode.setError(null);
                            editTextSchoolCode.setEnabled(false);
                            String passwordDB = snapshot.child(schoolCode).child("password").getValue(String.class);
                            if (passwordDB.equals(password)) {
                                editTextPassword.setError(null);
                                editTextPassword.setEnabled(false);
                                String schoolCodeDB = snapshot.child(schoolCode).child("schoolCode").getValue(String.class);
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                intent.putExtra("schoolCode", schoolCodeDB);
                                startActivity(intent);
                            } else {
                                progressDialog.dismiss();
                                editTextPassword.setError("Wrong password");
                                editTextPassword.requestFocus();
                            }
                        }
                        else{
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),"No such Account",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                    }
                });
            }
            //Teacher login conditions
            else if(countNo == 11){
                String employeeID = editTextSchoolCode.getEditText().getText().toString().trim();
                String password = editTextPassword.getEditText().getText().toString().trim();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("employee");
                Query checkUser = databaseReference.orderByChild("employeeID").equalTo(employeeID);
                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            editTextSchoolCode.setError(null);
                            editTextSchoolCode.setEnabled(false);
                            String passwordDB = snapshot.child(employeeID).child("password").getValue(String.class);
                            if (passwordDB.equals(password)) {
                                editTextPassword.setError(null);
                                editTextPassword.setEnabled(false);
                                String employeeIDDB = snapshot.child(employeeID).child("employeeID").getValue(String.class);
                                Intent intent = new Intent(getApplicationContext(), TeacherHomeActivity.class);
                                intent.putExtra("employeeID", employeeIDDB);
                                startActivity(intent);
                            } else {
                                progressDialog.dismiss();
                                editTextPassword.setError("Wrong password");
                                editTextPassword.requestFocus();
                            }
                        }
                        else{
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),"No such Account",Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else{
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"No such Account",Toast.LENGTH_SHORT).show();
            }
        }
    }
    private boolean validateSchoolCode(){
        String val = editTextSchoolCode.getEditText().getText().toString().trim();
        if(val.isEmpty()){
            editTextSchoolCode.setError("School Code/ EmployeeID/ Student Code is Required!");
            editTextSchoolCode.requestFocus();
            return false;
        }
        else if(val.length() > 14) {
            editTextSchoolCode.setError("School Code/ EmployeeID/ Student Code is too large, it should less than 14");
            editTextSchoolCode.requestFocus();
            return false;
        }
        return true;
    }
    private boolean validatePassword(){
        String val = editTextPassword.getEditText().getText().toString().trim();
        if(val.isEmpty()){
            editTextPassword.setError("Password is Empty");
            editTextPassword.requestFocus();
        }
        else if(val.length() < 8) {
            editTextPassword.setError("Password is too short, it should be at least 8");
            editTextPassword.requestFocus();
            return false;
        }
        return true;
    }

    public void callRegisterPage(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        Intent loginIntent = new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(loginIntent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.dismiss();
    }
}