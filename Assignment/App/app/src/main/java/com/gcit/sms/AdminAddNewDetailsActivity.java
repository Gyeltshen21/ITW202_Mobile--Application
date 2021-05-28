package com.gcit.sms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.squareup.picasso.Picasso;

public class AdminAddNewDetailsActivity extends AppCompatActivity {
    private TextInputLayout adminFullName, adminEmployeeID, adminEmail, adminPhoneNo, adminCourse, adminClass;
    private ImageView imageView;
    private Uri FilePath;
    private androidx.appcompat.widget.Toolbar toolbar;
    private FirebaseDatabase rootNode;
    private StorageReference storageReference;
    private DatabaseReference databaseReference;
    String s2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_details);

        storageReference = FirebaseStorage.getInstance().getReference();
        rootNode = FirebaseDatabase.getInstance();
        databaseReference = rootNode.getReference("SMSemployeeDetails");

        String sCode = getIntent().getStringExtra("schoolCode");
        s2 = sCode;

        adminFullName = (TextInputLayout) findViewById(R.id.EmlpoyeeName);
        adminEmployeeID = (TextInputLayout) findViewById(R.id.AdminID);
        adminEmail = (TextInputLayout) findViewById(R.id.AdminEmail);
        adminPhoneNo = (TextInputLayout) findViewById(R.id.AdminPhoneNo);
        adminCourse = (TextInputLayout) findViewById(R.id.AdminCourse);
        adminClass = (TextInputLayout) findViewById(R.id.AdminClass);
        imageView = (ImageView)findViewById(R.id.ProfilePic);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dexter.withContext(getApplicationContext())
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent intent = new Intent();
                                intent.setType("image/*");
                                intent.setAction(Intent.ACTION_GET_CONTENT);
                                startActivityForResult(Intent.createChooser(intent, "Select Image Files"),101);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                permissionToken.continuePermissionRequest();
                            }
                        }).check();
            }
        });
    }

    public void callVerifyScreen(View view) {
        if (!validateEmail() | !validatePhoneNumber()) {
            return;
        }
        else {
            processUpload(FilePath);
        }
    }

    private void processUpload(Uri filePath) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.show();
        if(filePath != null){
            String name = adminFullName.getEditText().getText().toString().trim();
            String employeeid = adminEmployeeID.getEditText().getText().toString().trim();
            String email = adminEmail.getEditText().getText().toString().trim();
            String phoneNo = adminPhoneNo.getEditText().getText().toString().trim();
            String course = adminCourse.getEditText().getText().toString().trim();
            String standard = adminClass.getEditText().getText().toString().trim();
            StorageReference reference = storageReference.child("SMSProfile/" + databaseReference.push().getKey() + ".png");
            reference.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    AdminNewDetailsHelperClass details = new AdminNewDetailsHelperClass(name, employeeid, email, phoneNo,course, standard,uri.toString());
                                    databaseReference.child(databaseReference.push().getKey()).setValue(details);
                                    progressDialog.dismiss();
                                    Toast.makeText(getApplicationContext(),"New Details saved Successfully",Toast.LENGTH_SHORT).show();
                                    adminFullName.getEditText().setText("");
                                    adminEmployeeID.getEditText().setText("");
                                    adminEmail.getEditText().setText("");
                                    adminPhoneNo.getEditText().setText("");
                                    adminCourse.getEditText().setText("");
                                    adminClass.getEditText().setText("");
                                }
                            });
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                            float percent = (100 * snapshot.getBytesTransferred()/snapshot.getTotalByteCount());
                            progressDialog.setMessage("Saving...." + (int)percent + "%");
                        }
                    });
        }
        else{
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(),"No file selected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 && resultCode == RESULT_OK){
            FilePath = data.getData();
            Picasso.with(this).load(FilePath).into(imageView);
        }
    }

    private boolean validateEmail(){
        String val = adminEmail.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(!val.matches(checkEmail)){
            adminEmail.setError("Please enter valid Email Address");
            adminEmail.requestFocus();
            return false;
        }
        return true;
    }
    private boolean validatePhoneNumber(){
        String val = adminPhoneNo.getEditText().getText().toString().trim();
        String checksTNumber = "[7][7][0-9]{6}";
        if(!val.matches(checksTNumber)){
            adminPhoneNo.setError("Invalid Phone Number");
            adminPhoneNo.requestFocus();
            return false;
        }
        return true;
    }
    //Back button
    public void AdminAddNewDetailsToDetails(View view) {
        Intent intent = new Intent(getApplicationContext(),AdminDetailsViewActivity.class);
        intent.putExtra("schoolCode",s2);
        startActivity(intent);
    }
}