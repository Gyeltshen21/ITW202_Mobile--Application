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

public class ForgotPasswordActivity extends AppCompatActivity {

    TextInputLayout editTextSchoolCode;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        editTextSchoolCode = (TextInputLayout) findViewById(R.id.SchoolCode);

    }

    public void BackToLoginPage(View view) {
        Intent loginIntent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(loginIntent);
    }

    public void callPhoneAuthPage(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        if (!validateSchoolCode()) {
            progressDialog.dismiss();
            return;
        }
        //Admin Condition
        else {
            int countNo = editTextSchoolCode.getEditText().length();
            if(countNo == 3){
                String schoolCode = editTextSchoolCode.getEditText().getText().toString().trim();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("SMSadmin");
                Query checkUser = databaseReference.orderByChild("schoolCode").equalTo(schoolCode);
                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            editTextSchoolCode.setError(null);
                            editTextSchoolCode.setEnabled(false);
                            String passwordDB = snapshot.child(schoolCode).child("password").getValue(String.class);
                            String schoolCodeDB = snapshot.child(schoolCode).child("schoolCode").getValue(String.class);
                            String phoneNoDB = snapshot.child(schoolCode).child("phone").getValue(String.class);
                            String emailDB = snapshot.child(schoolCode).child("email").getValue(String.class);
                            String fullNameDB = snapshot.child(schoolCode).child("name").getValue(String.class);
                            Intent intent = new Intent(getApplicationContext(), PhoneAuthActivity.class);
                            intent.putExtra("schoolCode", schoolCodeDB);
                            intent.putExtra("password", passwordDB);
                            intent.putExtra("email", emailDB);
                            intent.putExtra("phone", phoneNoDB);
                            intent.putExtra("name", fullNameDB);
                            intent.putExtra("whatToDo", "AdminUpdate");
                            startActivity(intent);
                            finish();
                        }
                        else{
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),"No such Account", Toast.LENGTH_SHORT).show();
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
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("SMSemployee");
                Query checkUser = databaseReference.orderByChild("employeeID").equalTo(employeeID);
                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            editTextSchoolCode.setError(null);
                            editTextSchoolCode.setEnabled(false);
                            String passwordDB = snapshot.child(employeeID).child("password").getValue(String.class);
                            String employeeIDDB = snapshot.child(employeeID).child("employeeID").getValue(String.class);
                            String phoneNoDB = snapshot.child(employeeID).child("phone").getValue(String.class);
                            String emailDB = snapshot.child(employeeID).child("email").getValue(String.class);
                            String fullNameDB = snapshot.child(employeeID).child("name").getValue(String.class);
                            Intent intent = new Intent(getApplicationContext(), PhoneAuthActivity.class);
                            intent.putExtra("schoolCode", employeeIDDB);
                            intent.putExtra("password", passwordDB);
                            intent.putExtra("email", emailDB);
                            intent.putExtra("phone", phoneNoDB);
                            intent.putExtra("name", fullNameDB);
                            intent.putExtra("whatToDo", "EmployeeUpdate");
                            startActivity(intent);
                            finish();
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
            editTextSchoolCode.setError("School Code/ EmployeeID is Required!");
            editTextSchoolCode.requestFocus();
            return false;
        }
        else if(val.length() > 14) {
            editTextSchoolCode.setError("School Code/ EmployeeID is too large, it should less than 14");
            editTextSchoolCode.requestFocus();
            return false;
        }
        return true;
    }
}