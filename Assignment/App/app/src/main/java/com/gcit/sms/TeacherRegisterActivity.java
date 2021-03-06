package com.gcit.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class TeacherRegisterActivity extends AppCompatActivity {

    TextInputLayout teacherFullName, teacherEmployeeID, teacherEmail, teacherPhoneNo, teacherPassword, teacherConfirmPassword;
    androidx.appcompat.widget.Toolbar toolbar;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_register);
        firebaseAuth = FirebaseAuth.getInstance();
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("SMSemployee");

        String sCode = getIntent().getStringExtra("schoolCode");
        s2 = sCode;

        teacherFullName = (TextInputLayout) findViewById(R.id.EmlpoyeeName);
        teacherEmployeeID = (TextInputLayout) findViewById(R.id.EmlpoyeeID);
        teacherEmail = (TextInputLayout) findViewById(R.id.TeacherEmail);
        teacherPhoneNo = (TextInputLayout) findViewById(R.id.TeacherPhoneNo);
        teacherPassword = (TextInputLayout) findViewById(R.id.TeacherPassword);
        teacherConfirmPassword = (TextInputLayout) findViewById(R.id.TeacherConfirmPassword);
    }

    public void callVerifyScreen (View view){
        if (!validateName() | !validateSchoolCode() | !validateEmail() | !validatePhoneNumber() | !validatePassword()) {
            return;
        }
        else {
            String name = teacherFullName.getEditText().getText().toString().trim();
            String employeeid = teacherEmployeeID.getEditText().getText().toString().trim();
            String email = teacherEmail.getEditText().getText().toString().trim();
            String phone = teacherPhoneNo.getEditText().getText().toString().trim();
            String phoneNo = "+975" +phone;
            String password = teacherPassword.getEditText().getText().toString().trim();
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener((task)-> {
                if (!task.isSuccessful()) {
                    Toast.makeText(TeacherRegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(TeacherRegisterActivity.this, "Account has been successfully created, You can login now", Toast.LENGTH_SHORT).show();
                    TeacherUserHelperClass userHelperClass = new TeacherUserHelperClass(name, employeeid, email, phoneNo, password);
                    reference.child(employeeid).setValue(userHelperClass);
                    Intent registerIntent = new Intent(getApplicationContext(), TeacherRegisterActivity.class);
                    teacherFullName.getEditText().setText("");
                    teacherEmployeeID.getEditText().setText("");
                    teacherEmail.getEditText().setText("");
                    teacherPhoneNo.getEditText().setText("");
                    teacherPassword.getEditText().setText("");
                    teacherConfirmPassword.getEditText().setText("");
                    startActivity(registerIntent);
                }
            });
        }
    }
    private boolean validateName(){
        String val = teacherFullName.getEditText().getText().toString().trim();
        if(val.isEmpty()){
            teacherFullName.setError("Full Name is Required!");
            teacherFullName.requestFocus();
            return false;
        }
        return true;
    }
    private boolean validateSchoolCode(){
        String val = teacherEmployeeID.getEditText().getText().toString().trim();
        if(val.isEmpty()){
            teacherEmployeeID.setError("Employee ID is Required!");
            teacherEmployeeID.requestFocus();
            return false;
        }
        else if(val.length() != 11) {
            teacherEmployeeID.setError("Employee ID should be exactly 11");
            teacherEmployeeID.requestFocus();
            return false;
        }
        return true;
    }
    private boolean validateEmail(){
        String val = teacherEmail.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(val.isEmpty()){
            teacherEmail.setError("Email is Required!");
            teacherEmail.requestFocus();
            return false;
        }
        else if(!val.matches(checkEmail)){
            teacherEmail.setError("Please enter valid Email Address");
            teacherEmail.requestFocus();
            return false;
        }
        return true;
    }
    private boolean validatePhoneNumber(){
        String val = teacherPhoneNo.getEditText().getText().toString().trim();
        String checksTNumber = "[1][7][0-9]{6}";
        String checksBNumber = "(0/91)?[1][7][0-9]{6}";
        if(val.isEmpty()){
            teacherPhoneNo.setError("Phone Number is Required!");
            teacherPhoneNo.requestFocus();
            return false;
        }
        else if(!val.matches(checksTNumber)){
            teacherPhoneNo.setError("Invalid Phone Number");
            teacherPhoneNo.requestFocus();
            return false;
        }
        return true;
    }
    private boolean validatePassword(){
        String val = teacherPassword.getEditText().getText().toString().trim();
        String val1 = teacherConfirmPassword.getEditText().getText().toString().trim();
        final Pattern PASSWORD_PATTERN =
                Pattern.compile("^" +
                        "(?=.*[@#$%^&+=])" +     // at least 1 special character
                        "(?=\\S+$)" +            // no white spaces
                        ".{4,}" +                // at least 4 characters
                        "$");
        if(val.isEmpty()){
            teacherPassword.setError("Password is Empty");
            teacherPassword.requestFocus();
            return false;
        }
        else if(val1.isEmpty()){
            teacherConfirmPassword.setError("Confirm Password is Empty");
            teacherConfirmPassword.requestFocus();
            return false;
        }
        else if(val.length() < 8) {
            teacherPassword.setError("Password is too short, it should be at least 8");
            teacherPassword.requestFocus();
            return false;
        }
        else if(!PASSWORD_PATTERN.matcher(val).matches()){
            teacherPassword.setError("Password is too weak");
            teacherPassword.requestFocus();
            return false;
        }
        else if(!val.equals(val1)){
            teacherConfirmPassword.setError("Confirm Password is didn't match");
            teacherConfirmPassword.requestFocus();
            return false;
        }
        return true;
    }
    //Back button
    public void TeacherRegisterToHome(View view) {
        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
        intent.putExtra("schoolCode",s2);
        startActivity(intent);
    }
}