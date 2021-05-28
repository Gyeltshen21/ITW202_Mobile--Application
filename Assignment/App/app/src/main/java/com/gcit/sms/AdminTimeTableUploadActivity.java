package com.gcit.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminTimeTableUploadActivity extends AppCompatActivity {
    private EditText mPeriodRow1, mPeriodRow2, mPeriodRow3, mPeriodRow4, mPeriodRow5, mPeriodRow6, mPeriodRow7, mPeriodRow8;
    private EditText mMondayCol1, mMondayCol2, mMondayCol3, mMondayCol4, mMondayCol5, mMondayCol6, mMondayCol7, mMondayCol8;
    private EditText mTuesdayCol1, mTuesdayCol2, mTuesdayCol3, mTuesdayCol4, mTuesdayCol5, mTuesdayCol6, mTuesdayCol7, mTuesdayCol8;
    private EditText mWednesdayCol1, mWednesdayCol2, mWednesdayCol3, mWednesdayCol4, mWednesdayCol5, mWednesdayCol6, mWednesdayCol7, mWednesdayCol8;
    private EditText mThursdayCol1, mThursdayCol2, mThursdayCol3, mThursdayCol4, mThursdayCol5, mThursdayCol6, mThursdayCol7, mThursdayCol8;
    private EditText mFridayCol1, mFridayCol2, mFridayCol3, mFridayCol4, mFridayCol5, mFridayCol6, mFridayCol7, mFridayCol8;
    private EditText mSaturdayCol1, mSaturdayCol2, mSaturdayCol3, mSaturdayCol4, mSaturdayCol5, mSaturdayCol6, mSaturdayCol7, mSaturdayCol8;
    private EditText mClass, mSection;
    private Context mContext = AdminTimeTableUploadActivity.this;

    private DatabaseReference databaseReference;
    private Button mSaveBtn;
    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_time_table_upload);

        Intent intent = getIntent();
        String sCode1 = intent.getStringExtra("schoolCode");
        s1 = sCode1;
        databaseReference = FirebaseDatabase.getInstance().getReference("SMSTIMETABLE");
        
        mPeriodRow1 = findViewById(R.id.period_row1);
        mPeriodRow2 = findViewById(R.id.period_row2);
        mPeriodRow3 = findViewById(R.id.period_row3);
        mPeriodRow4 = findViewById(R.id.period_row4);
        mPeriodRow5 = findViewById(R.id.period_row5);
        mPeriodRow6 = findViewById(R.id.period_row6);
        mPeriodRow7 = findViewById(R.id.period_row7);
        mPeriodRow8 = findViewById(R.id.period_row8);
        
        mMondayCol1 = findViewById(R.id.Monday_col1);
        mMondayCol2 = findViewById(R.id.Monday_col2);
        mMondayCol3 = findViewById(R.id.Monday_col3);
        mMondayCol4 = findViewById(R.id.Monday_col4);
        mMondayCol5 = findViewById(R.id.Monday_col5);
        mMondayCol6 = findViewById(R.id.Monday_col6);
        mMondayCol7 = findViewById(R.id.Monday_col7);
        mMondayCol8 = findViewById(R.id.Monday_col8);
        
        mTuesdayCol1  = findViewById(R.id.Tuesday_col1);
        mTuesdayCol2  = findViewById(R.id.Tuesday_col2);
        mTuesdayCol3  = findViewById(R.id.Tuesday_col3);
        mTuesdayCol4  = findViewById(R.id.Tuesday_col4);
        mTuesdayCol5  = findViewById(R.id.Tuesday_col5);
        mTuesdayCol6  = findViewById(R.id.Tuesday_col6);
        mTuesdayCol7  = findViewById(R.id.Tuesday_col7);
        mTuesdayCol8  = findViewById(R.id.Tuesday_col8);

        mWednesdayCol1 = findViewById(R.id.Wednesday_col1);
        mWednesdayCol2 = findViewById(R.id.Wednesday_col2);
        mWednesdayCol3 = findViewById(R.id.Wednesday_col3);
        mWednesdayCol4 = findViewById(R.id.Wednesday_col4);
        mWednesdayCol5 = findViewById(R.id.Wednesday_col5);
        mWednesdayCol6 = findViewById(R.id.Wednesday_col6);
        mWednesdayCol7 = findViewById(R.id.Wednesday_col7);
        mWednesdayCol8 = findViewById(R.id.Wednesday_col8);

        mThursdayCol1 = findViewById(R.id.Thursday_col1);
        mThursdayCol2 = findViewById(R.id.Thursday_col2);
        mThursdayCol3 = findViewById(R.id.Thursday_col3);
        mThursdayCol4 = findViewById(R.id.Thursday_col4);
        mThursdayCol5 = findViewById(R.id.Thursday_col5);
        mThursdayCol6 = findViewById(R.id.Thursday_col6);
        mThursdayCol7 = findViewById(R.id.Thursday_col7);
        mThursdayCol8 = findViewById(R.id.Thursday_col8);

        mFridayCol1 = findViewById(R.id.Friday_col1);
        mFridayCol2 = findViewById(R.id.Friday_col2);
        mFridayCol3 = findViewById(R.id.Friday_col3);
        mFridayCol4 = findViewById(R.id.Friday_col4);
        mFridayCol5 = findViewById(R.id.Friday_col5);
        mFridayCol6 = findViewById(R.id.Friday_col6);
        mFridayCol7 = findViewById(R.id.Friday_col7);
        mFridayCol8 = findViewById(R.id.Friday_col8);

        mSaturdayCol1 = findViewById(R.id.Saturday_col1);
        mSaturdayCol2 = findViewById(R.id.Saturday_col2);
        mSaturdayCol3 = findViewById(R.id.Saturday_col3);
        mSaturdayCol4 = findViewById(R.id.Saturday_col4);
        mSaturdayCol5 = findViewById(R.id.Saturday_col5);
        mSaturdayCol6 = findViewById(R.id.Saturday_col6);
        mSaturdayCol7 = findViewById(R.id.Saturday_col7);
        mSaturdayCol8 = findViewById(R.id.Saturday_col8);

        mClass = findViewById(R.id.Class);
        mSection = findViewById(R.id.Section);
        mSaveBtn = findViewById(R.id.saveBtn);

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mClassText = mClass.getText().toString().trim();
                String mSectionText = mSection.getText().toString().trim();

                String mTime1 = mPeriodRow1.getText().toString().trim();
                String mTime2 = mPeriodRow2.getText().toString().trim();
                String mTime3 = mPeriodRow3.getText().toString().trim();
                String mTime4 = mPeriodRow4.getText().toString().trim();
                String mTime5 = mPeriodRow5.getText().toString().trim();
                String mTime6 = mPeriodRow6.getText().toString().trim();
                String mTime7 = mPeriodRow7.getText().toString().trim();
                String mTime8 = mPeriodRow8.getText().toString().trim();

                String mMonday1 = mMondayCol1.getText().toString().trim();
                String mMonday2 = mMondayCol2.getText().toString().trim();
                String mMonday3 = mMondayCol3.getText().toString().trim();
                String mMonday4 = mMondayCol4.getText().toString().trim();
                String mMonday5 = mMondayCol5.getText().toString().trim();
                String mMonday6 = mMondayCol6.getText().toString().trim();
                String mMonday7 = mMondayCol7.getText().toString().trim();
                String mMonday8 = mMondayCol8.getText().toString().trim();

                String mTuesday1 = mTuesdayCol1.getText().toString().trim();
                String mTuesday2 = mTuesdayCol2.getText().toString().trim();
                String mTuesday3 = mTuesdayCol3.getText().toString().trim();
                String mTuesday4 = mTuesdayCol4.getText().toString().trim();
                String mTuesday5 = mTuesdayCol5.getText().toString().trim();
                String mTuesday6 = mTuesdayCol6.getText().toString().trim();
                String mTuesday7 = mTuesdayCol7.getText().toString().trim();
                String mTuesday8 = mTuesdayCol8.getText().toString().trim();

                String mWednesday1 = mWednesdayCol1.getText().toString().trim();
                String mWednesday2 = mWednesdayCol2.getText().toString().trim();
                String mWednesday3 = mWednesdayCol3.getText().toString().trim();
                String mWednesday4 = mWednesdayCol4.getText().toString().trim();
                String mWednesday5 = mWednesdayCol5.getText().toString().trim();
                String mWednesday6 = mWednesdayCol6.getText().toString().trim();
                String mWednesday7 = mWednesdayCol7.getText().toString().trim();
                String mWednesday8 = mWednesdayCol8.getText().toString().trim();

                String mThursday1 = mThursdayCol1.getText().toString().trim();
                String mThursday2 = mThursdayCol2.getText().toString().trim();
                String mThursday3 = mThursdayCol3.getText().toString().trim();
                String mThursday4 = mThursdayCol4.getText().toString().trim();
                String mThursday5 = mThursdayCol5.getText().toString().trim();
                String mThursday6 = mThursdayCol6.getText().toString().trim();
                String mThursday7 = mThursdayCol7.getText().toString().trim();
                String mThursday8 = mThursdayCol8.getText().toString().trim();

                String mFriday1 = mFridayCol1.getText().toString().trim();
                String mFriday2 = mFridayCol2.getText().toString().trim();
                String mFriday3 = mFridayCol3.getText().toString().trim();
                String mFriday4 = mFridayCol4.getText().toString().trim();
                String mFriday5 = mFridayCol5.getText().toString().trim();
                String mFriday6 = mFridayCol6.getText().toString().trim();
                String mFriday7 = mFridayCol7.getText().toString().trim();
                String mFriday8 = mFridayCol8.getText().toString().trim();

                String mSaturday1 = mSaturdayCol1.getText().toString().trim();
                String mSaturday2 = mSaturdayCol2.getText().toString().trim();
                String mSaturday3 = mSaturdayCol3.getText().toString().trim();
                String mSaturday4 = mSaturdayCol4.getText().toString().trim();
                String mSaturday5 = mSaturdayCol5.getText().toString().trim();
                String mSaturday6 = mSaturdayCol6.getText().toString().trim();
                String mSaturday7 = mSaturdayCol7.getText().toString().trim();
                String mSaturday8 = mSaturdayCol8.getText().toString().trim();

                ProgressDialog progressDialog = new ProgressDialog(mContext);
                progressDialog.setMessage("Saving....");
                progressDialog.show();

                if(!validateClass() | !ValidateSection()){
                    progressDialog.dismiss();
                    return;
                }
                else{
                    progressDialog.dismiss();
                    AdminTimeTableHelperClass time = new AdminTimeTableHelperClass(mClassText, mSectionText, mTime1, mTime2, mTime3, mTime4, mTime5,
                            mTime6, mTime7, mTime8, mMonday1, mMonday2, mMonday3, mMonday4, mMonday5, mMonday6, mMonday7, mMonday8,
                            mTuesday1, mTuesday2, mTuesday3, mTuesday4, mTuesday5, mTuesday6, mTuesday7, mTuesday8,
                            mWednesday1, mWednesday2, mWednesday3, mWednesday4, mWednesday5, mWednesday6, mWednesday7, mWednesday8,
                            mThursday1, mThursday2, mThursday3, mThursday4, mThursday5, mThursday6, mThursday7, mThursday8,
                            mFriday1, mFriday2, mFriday3, mFriday4, mFriday5, mFriday6, mFriday7, mFriday8,
                            mSaturday1, mSaturday2, mSaturday3, mSaturday4, mSaturday5, mSaturday6, mSaturday7, mSaturday8);
                    databaseReference.child(databaseReference.push().getKey()).setValue(time);
                    Toast.makeText(getApplicationContext(),"Saved Successfully",Toast.LENGTH_SHORT).show();

                    mClass.setText("");
                    mSection.setText("");

                    mPeriodRow1.setText("");
                    mPeriodRow2.setText("");
                    mPeriodRow3.setText("");
                    mPeriodRow4.setText("");
                    mPeriodRow5.setText("");
                    mPeriodRow6.setText("");
                    mPeriodRow7.setText("");
                    mPeriodRow8.setText("");

                    mMondayCol1.setText("");
                    mMondayCol2.setText("");
                    mMondayCol3.setText("");
                    mMondayCol4.setText("");
                    mMondayCol5.setText("");
                    mMondayCol6.setText("");
                    mMondayCol7.setText("");
                    mMondayCol8.setText("");

                    mTuesdayCol1.setText("");
                    mTuesdayCol2.setText("");
                    mTuesdayCol3.setText("");
                    mTuesdayCol4.setText("");
                    mTuesdayCol5.setText("");
                    mTuesdayCol6.setText("");
                    mTuesdayCol7.setText("");
                    mTuesdayCol8.setText("");

                    mWednesdayCol1.setText("");
                    mWednesdayCol2.setText("");
                    mWednesdayCol3.setText("");
                    mWednesdayCol4.setText("");
                    mWednesdayCol5.setText("");
                    mWednesdayCol6.setText("");
                    mWednesdayCol7.setText("");
                    mWednesdayCol8.setText("");

                    mThursdayCol1.setText("");
                    mThursdayCol2.setText("");
                    mThursdayCol3.setText("");
                    mThursdayCol4.setText("");
                    mThursdayCol5.setText("");
                    mThursdayCol6.setText("");
                    mThursdayCol7.setText("");
                    mThursdayCol8.setText("");

                    mFridayCol1.setText("");
                    mFridayCol2.setText("");
                    mFridayCol3.setText("");
                    mFridayCol4.setText("");
                    mFridayCol5.setText("");
                    mFridayCol6.setText("");
                    mFridayCol7.setText("");
                    mFridayCol8.setText("");

                    mSaturdayCol1.setText("");
                    mSaturdayCol2.setText("");
                    mSaturdayCol3.setText("");
                    mSaturdayCol4.setText("");
                    mSaturdayCol5.setText("");
                    mSaturdayCol6.setText("");
                    mSaturdayCol7.setText("");
                    mSaturdayCol8.setText("");
                }
            }
        });
        
    }

    private boolean ValidateSection() {
        String val = mClass.getText().toString().trim();
        if(val.isEmpty()){
            mClass.setError("Field cannot be empty");
            mClass.requestFocus();
            return false;
        }
        return true;
    }

    private boolean validateClass() {
        String val = mClass.getText().toString().trim();
        if(val.isEmpty()){
            mSection.setError("Field cannot be empty");
            mSection.requestFocus();
            return false;
        }
        return true;
    }

    public void BackToTimeTablePDFList(View view) {
        Intent intentHome = new Intent(getApplicationContext(),AdminTimeTableActivity.class);
        intentHome.putExtra("schoolCode",s1);
        startActivity(intentHome);
    }
}