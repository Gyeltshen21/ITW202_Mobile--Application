package com.gcit.sms;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class AdminTimeTableAdapter extends FirebaseRecyclerAdapter<AdminTimeTableHelperClass, AdminTimeTableAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdminTimeTableAdapter(@NonNull FirebaseRecyclerOptions<AdminTimeTableHelperClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myViewHolder holder, final int position, @NonNull final AdminTimeTableHelperClass adminTimeTableHelperClass) {
        holder.mClass.setText(adminTimeTableHelperClass.getmClassText());
        holder.mSection.setText(adminTimeTableHelperClass.getmSectionText());

        holder.mPeriodRow1.setText(adminTimeTableHelperClass.getmTime1());
        holder.mPeriodRow2.setText(adminTimeTableHelperClass.getmTime2());
        holder.mPeriodRow3.setText(adminTimeTableHelperClass.getmTime3());
        holder.mPeriodRow4.setText(adminTimeTableHelperClass.getmTime4());
        holder.mPeriodRow5.setText(adminTimeTableHelperClass.getmTime5());
        holder.mPeriodRow6.setText(adminTimeTableHelperClass.getmTime6());
        holder.mPeriodRow7.setText(adminTimeTableHelperClass.getmTime7());
        holder.mPeriodRow8.setText(adminTimeTableHelperClass.getmTime8());

        holder.mMondayCol1.setText(adminTimeTableHelperClass.getmMonday1());
        holder.mMondayCol2.setText(adminTimeTableHelperClass.getmMonday2());
        holder.mMondayCol3.setText(adminTimeTableHelperClass.getmMonday3());
        holder.mMondayCol4.setText(adminTimeTableHelperClass.getmMonday4());
        holder.mMondayCol5.setText(adminTimeTableHelperClass.getmMonday5());
        holder.mMondayCol6.setText(adminTimeTableHelperClass.getmMonday6());
        holder.mMondayCol7.setText(adminTimeTableHelperClass.getmMonday7());
        holder.mMondayCol8.setText(adminTimeTableHelperClass.getmMonday8());

        holder.mTuesdayCol1.setText(adminTimeTableHelperClass.getmTuesday1());
        holder.mTuesdayCol2.setText(adminTimeTableHelperClass.getmTuesday2());
        holder.mTuesdayCol3.setText(adminTimeTableHelperClass.getmTuesday3());
        holder.mTuesdayCol4.setText(adminTimeTableHelperClass.getmTuesday4());
        holder.mTuesdayCol5.setText(adminTimeTableHelperClass.getmTuesday5());
        holder.mTuesdayCol6.setText(adminTimeTableHelperClass.getmTuesday6());
        holder.mTuesdayCol7.setText(adminTimeTableHelperClass.getmTuesday7());
        holder.mTuesdayCol8.setText(adminTimeTableHelperClass.getmTuesday8());

        holder.mWednesdayCol1.setText(adminTimeTableHelperClass.getmWednesday1());
        holder.mWednesdayCol2.setText(adminTimeTableHelperClass.getmWednesday2());
        holder.mWednesdayCol3.setText(adminTimeTableHelperClass.getmWednesday3());
        holder.mWednesdayCol4.setText(adminTimeTableHelperClass.getmWednesday4());
        holder.mWednesdayCol5.setText(adminTimeTableHelperClass.getmWednesday5());
        holder.mWednesdayCol6.setText(adminTimeTableHelperClass.getmWednesday6());
        holder.mWednesdayCol7.setText(adminTimeTableHelperClass.getmWednesday7());
        holder.mWednesdayCol8.setText(adminTimeTableHelperClass.getmWednesday8());

        holder.mThursdayCol1.setText(adminTimeTableHelperClass.getmThursday1());
        holder.mThursdayCol2.setText(adminTimeTableHelperClass.getmThursday2());
        holder.mThursdayCol3.setText(adminTimeTableHelperClass.getmThursday3());
        holder.mThursdayCol4.setText(adminTimeTableHelperClass.getmThursday4());
        holder.mThursdayCol5.setText(adminTimeTableHelperClass.getmThursday5());
        holder.mThursdayCol6.setText(adminTimeTableHelperClass.getmThursday6());
        holder.mThursdayCol7.setText(adminTimeTableHelperClass.getmThursday7());
        holder.mThursdayCol8.setText(adminTimeTableHelperClass.getmThursday8());

        holder.mFridayCol1.setText(adminTimeTableHelperClass.getmFriday1());
        holder.mFridayCol2.setText(adminTimeTableHelperClass.getmFriday2());
        holder.mFridayCol3.setText(adminTimeTableHelperClass.getmFriday3());
        holder.mFridayCol4.setText(adminTimeTableHelperClass.getmFriday4());
        holder.mFridayCol5.setText(adminTimeTableHelperClass.getmFriday5());
        holder.mFridayCol6.setText(adminTimeTableHelperClass.getmFriday6());
        holder.mFridayCol7.setText(adminTimeTableHelperClass.getmFriday7());
        holder.mFridayCol8.setText(adminTimeTableHelperClass.getmFriday8());

        holder.mSaturdayCol1.setText(adminTimeTableHelperClass.getmSaturday1());
        holder.mSaturdayCol2.setText(adminTimeTableHelperClass.getmSaturday2());
        holder.mSaturdayCol3.setText(adminTimeTableHelperClass.getmSaturday3());
        holder.mSaturdayCol4.setText(adminTimeTableHelperClass.getmSaturday4());
        holder.mSaturdayCol5.setText(adminTimeTableHelperClass.getmSaturday5());
        holder.mSaturdayCol6.setText(adminTimeTableHelperClass.getmSaturday6());
        holder.mSaturdayCol7.setText(adminTimeTableHelperClass.getmSaturday7());
        holder.mSaturdayCol8.setText(adminTimeTableHelperClass.getmSaturday8());

        holder.mDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.mClass.getContext());
                builder.setTitle("Delete");
                builder.setMessage("Are sure you want to delete?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("SMSTIMETABLE").child(getRef(position).getKey()).removeValue();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

        holder.mEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.mClass.getContext())
                        .setContentHolder(new ViewHolder(R.layout.admin_timetable_dialog_content))
                        .setExpanded(true,1600)
                        .create();
                //Reference
                View time = dialogPlus.getHolderView();
                EditText mClass = time.findViewById(R.id.Class);
                EditText mSection = time.findViewById(R.id.Section);

                EditText mPeriodRow1 = time.findViewById(R.id.period_row1);
                EditText mPeriodRow2 = time.findViewById(R.id.period_row2);
                EditText mPeriodRow3 = time.findViewById(R.id.period_row3);
                EditText mPeriodRow4 = time.findViewById(R.id.period_row4);
                EditText mPeriodRow5 = time.findViewById(R.id.period_row5);
                EditText mPeriodRow6 = time.findViewById(R.id.period_row6);
                EditText mPeriodRow7 = time.findViewById(R.id.period_row7);
                EditText mPeriodRow8 = time.findViewById(R.id.period_row8);

                EditText mMondayCol1 = time.findViewById(R.id.Monday_col1);
                EditText mMondayCol2 = time.findViewById(R.id.Monday_col2);
                EditText mMondayCol3 = time.findViewById(R.id.Monday_col3);
                EditText mMondayCol4 = time.findViewById(R.id.Monday_col4);
                EditText mMondayCol5 = time.findViewById(R.id.Monday_col5);
                EditText mMondayCol6 = time.findViewById(R.id.Monday_col6);
                EditText mMondayCol7 = time.findViewById(R.id.Monday_col7);
                EditText mMondayCol8 = time.findViewById(R.id.Monday_col8);

                EditText mTuesdayCol1  = time.findViewById(R.id.Tuesday_col1);
                EditText mTuesdayCol2  = time.findViewById(R.id.Tuesday_col2);
                EditText mTuesdayCol3  = time.findViewById(R.id.Tuesday_col3);
                EditText mTuesdayCol4  = time.findViewById(R.id.Tuesday_col4);
                EditText mTuesdayCol5  = time.findViewById(R.id.Tuesday_col5);
                EditText mTuesdayCol6  = time.findViewById(R.id.Tuesday_col6);
                EditText mTuesdayCol7  = time.findViewById(R.id.Tuesday_col7);
                EditText mTuesdayCol8  = time.findViewById(R.id.Tuesday_col8);

                EditText mWednesdayCol1 = time.findViewById(R.id.Wednesday_col1);
                EditText mWednesdayCol2 = time.findViewById(R.id.Wednesday_col2);
                EditText mWednesdayCol3 = time.findViewById(R.id.Wednesday_col3);
                EditText mWednesdayCol4 = time.findViewById(R.id.Wednesday_col4);
                EditText mWednesdayCol5 = time.findViewById(R.id.Wednesday_col5);
                EditText mWednesdayCol6 = time.findViewById(R.id.Wednesday_col6);
                EditText mWednesdayCol7 = time.findViewById(R.id.Wednesday_col7);
                EditText mWednesdayCol8 = time.findViewById(R.id.Wednesday_col8);

                EditText mThursdayCol1 = time.findViewById(R.id.Thursday_col1);
                EditText mThursdayCol2 = time.findViewById(R.id.Thursday_col2);
                EditText mThursdayCol3 = time.findViewById(R.id.Thursday_col3);
                EditText mThursdayCol4 = time.findViewById(R.id.Thursday_col4);
                EditText mThursdayCol5 = time.findViewById(R.id.Thursday_col5);
                EditText mThursdayCol6 = time.findViewById(R.id.Thursday_col6);
                EditText mThursdayCol7 = time.findViewById(R.id.Thursday_col7);
                EditText mThursdayCol8 = time.findViewById(R.id.Thursday_col8);

                EditText mFridayCol1 = time.findViewById(R.id.Friday_col1);
                EditText mFridayCol2 = time.findViewById(R.id.Friday_col2);
                EditText mFridayCol3 = time.findViewById(R.id.Friday_col3);
                EditText mFridayCol4 = time.findViewById(R.id.Friday_col4);
                EditText mFridayCol5 = time.findViewById(R.id.Friday_col5);
                EditText mFridayCol6 = time.findViewById(R.id.Friday_col6);
                EditText mFridayCol7 = time.findViewById(R.id.Friday_col7);
                EditText mFridayCol8 = time.findViewById(R.id.Friday_col8);

                EditText mSaturdayCol1 = time.findViewById(R.id.Saturday_col1);
                EditText mSaturdayCol2 = time.findViewById(R.id.Saturday_col2);
                EditText mSaturdayCol3 = time.findViewById(R.id.Saturday_col3);
                EditText mSaturdayCol4 = time.findViewById(R.id.Saturday_col4);
                EditText mSaturdayCol5 = time.findViewById(R.id.Saturday_col5);
                EditText mSaturdayCol6 = time.findViewById(R.id.Saturday_col6);
                EditText mSaturdayCol7 = time.findViewById(R.id.Saturday_col7);
                EditText mSaturdayCol8 = time.findViewById(R.id.Saturday_col8);
                Button mUpdate = time.findViewById(R.id.updateBtn);

                //Displaying
                mClass.setText(adminTimeTableHelperClass.getmClassText());
                holder.mSection.setText(adminTimeTableHelperClass.getmSectionText());

                mPeriodRow1.setText(adminTimeTableHelperClass.getmTime1());
                mPeriodRow2.setText(adminTimeTableHelperClass.getmTime2());
                mPeriodRow3.setText(adminTimeTableHelperClass.getmTime3());
                mPeriodRow4.setText(adminTimeTableHelperClass.getmTime4());
                mPeriodRow5.setText(adminTimeTableHelperClass.getmTime5());
                mPeriodRow6.setText(adminTimeTableHelperClass.getmTime6());
                mPeriodRow7.setText(adminTimeTableHelperClass.getmTime7());
                mPeriodRow8.setText(adminTimeTableHelperClass.getmTime8());

                mMondayCol1.setText(adminTimeTableHelperClass.getmMonday1());
                mMondayCol2.setText(adminTimeTableHelperClass.getmMonday2());
                mMondayCol3.setText(adminTimeTableHelperClass.getmMonday3());
                mMondayCol4.setText(adminTimeTableHelperClass.getmMonday4());
                mMondayCol5.setText(adminTimeTableHelperClass.getmMonday5());
                mMondayCol6.setText(adminTimeTableHelperClass.getmMonday6());
                mMondayCol7.setText(adminTimeTableHelperClass.getmMonday7());
                mMondayCol8.setText(adminTimeTableHelperClass.getmMonday8());

                mTuesdayCol1.setText(adminTimeTableHelperClass.getmTuesday1());
                mTuesdayCol2.setText(adminTimeTableHelperClass.getmTuesday2());
                mTuesdayCol3.setText(adminTimeTableHelperClass.getmTuesday3());
                mTuesdayCol4.setText(adminTimeTableHelperClass.getmTuesday4());
                mTuesdayCol5.setText(adminTimeTableHelperClass.getmTuesday5());
                mTuesdayCol6.setText(adminTimeTableHelperClass.getmTuesday6());
                mTuesdayCol7.setText(adminTimeTableHelperClass.getmTuesday7());
                mTuesdayCol8.setText(adminTimeTableHelperClass.getmTuesday8());

                mWednesdayCol1.setText(adminTimeTableHelperClass.getmWednesday1());
                mWednesdayCol2.setText(adminTimeTableHelperClass.getmWednesday2());
                mWednesdayCol3.setText(adminTimeTableHelperClass.getmWednesday3());
                mWednesdayCol4.setText(adminTimeTableHelperClass.getmWednesday4());
                mWednesdayCol5.setText(adminTimeTableHelperClass.getmWednesday5());
                mWednesdayCol6.setText(adminTimeTableHelperClass.getmWednesday6());
                mWednesdayCol7.setText(adminTimeTableHelperClass.getmWednesday7());
                mWednesdayCol8.setText(adminTimeTableHelperClass.getmWednesday8());

                mThursdayCol1.setText(adminTimeTableHelperClass.getmThursday1());
                mThursdayCol2.setText(adminTimeTableHelperClass.getmThursday2());
                mThursdayCol3.setText(adminTimeTableHelperClass.getmThursday3());
                mThursdayCol4.setText(adminTimeTableHelperClass.getmThursday4());
                mThursdayCol5.setText(adminTimeTableHelperClass.getmThursday5());
                mThursdayCol6.setText(adminTimeTableHelperClass.getmThursday6());
                mThursdayCol7.setText(adminTimeTableHelperClass.getmThursday7());
                mThursdayCol8.setText(adminTimeTableHelperClass.getmThursday8());

                mFridayCol1.setText(adminTimeTableHelperClass.getmFriday1());
                mFridayCol2.setText(adminTimeTableHelperClass.getmFriday2());
                mFridayCol3.setText(adminTimeTableHelperClass.getmFriday3());
                mFridayCol4.setText(adminTimeTableHelperClass.getmFriday4());
                mFridayCol5.setText(adminTimeTableHelperClass.getmFriday5());
                mFridayCol6.setText(adminTimeTableHelperClass.getmFriday6());
                mFridayCol7.setText(adminTimeTableHelperClass.getmFriday7());
                mFridayCol8.setText(adminTimeTableHelperClass.getmFriday8());

                mSaturdayCol1.setText(adminTimeTableHelperClass.getmSaturday1());
                mSaturdayCol2.setText(adminTimeTableHelperClass.getmSaturday2());
                mSaturdayCol3.setText(adminTimeTableHelperClass.getmSaturday3());
                mSaturdayCol4.setText(adminTimeTableHelperClass.getmSaturday4());
                mSaturdayCol5.setText(adminTimeTableHelperClass.getmSaturday5());
                mSaturdayCol6.setText(adminTimeTableHelperClass.getmSaturday6());
                mSaturdayCol7.setText(adminTimeTableHelperClass.getmSaturday7());
                mSaturdayCol8.setText(adminTimeTableHelperClass.getmSaturday8());
                dialogPlus.show();

                mUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("mClassText", mClass.getText().toString().trim());
                        map.put("mSectionText", mSection.getText().toString().trim());

                        map.put("mTime1", mPeriodRow1.getText().toString().trim());
                        map.put("mTime2", mPeriodRow2.getText().toString().trim());
                        map.put("mTime3", mPeriodRow3.getText().toString().trim());
                        map.put("mTime4", mPeriodRow4.getText().toString().trim());
                        map.put("mTime5", mPeriodRow5.getText().toString().trim());
                        map.put("mTime6", mPeriodRow6.getText().toString().trim());
                        map.put("mTime7", mPeriodRow7.getText().toString().trim());
                        map.put("mTime8", mPeriodRow8.getText().toString().trim());

                        map.put("mMonday1", mMondayCol1.getText().toString().trim());
                        map.put("mMonday2", mMondayCol2.getText().toString().trim());
                        map.put("mMonday3", mMondayCol3.getText().toString().trim());
                        map.put("mMonday4", mMondayCol4.getText().toString().trim());
                        map.put("mMonday5", mMondayCol5.getText().toString().trim());
                        map.put("mMonday6", mMondayCol6.getText().toString().trim());
                        map.put("mMonday7", mMondayCol7.getText().toString().trim());
                        map.put("mMonday8", mMondayCol8.getText().toString().trim());

                        map.put("mTuesday1", mTuesdayCol1.getText().toString().trim());
                        map.put("mTuesday2", mTuesdayCol2.getText().toString().trim());
                        map.put("mTuesday3", mTuesdayCol3.getText().toString().trim());
                        map.put("mTuesday4", mTuesdayCol4.getText().toString().trim());
                        map.put("mTuesday5", mTuesdayCol5.getText().toString().trim());
                        map.put("mTuesday6", mTuesdayCol6.getText().toString().trim());
                        map.put("mTuesday7", mTuesdayCol7.getText().toString().trim());
                        map.put("mTuesday8", mTuesdayCol8.getText().toString().trim());

                        map.put("mWednesday1", mWednesdayCol1.getText().toString().trim());
                        map.put("mWednesday2", mWednesdayCol2.getText().toString().trim());
                        map.put("mWednesday3", mWednesdayCol3.getText().toString().trim());
                        map.put("mWednesday4", mWednesdayCol4.getText().toString().trim());
                        map.put("mWednesday5", mWednesdayCol5.getText().toString().trim());
                        map.put("mWednesday6", mWednesdayCol6.getText().toString().trim());
                        map.put("mWednesday7", mWednesdayCol7.getText().toString().trim());
                        map.put("mWednesday8", mWednesdayCol8.getText().toString().trim());

                        map.put("mThursday1", mThursdayCol1.getText().toString().trim());
                        map.put("mThursday2", mThursdayCol2.getText().toString().trim());
                        map.put("mThursday3", mThursdayCol3.getText().toString().trim());
                        map.put("mThursday4", mThursdayCol4.getText().toString().trim());
                        map.put("mThursday5", mThursdayCol5.getText().toString().trim());
                        map.put("mThursday6", mThursdayCol6.getText().toString().trim());
                        map.put("mThursday7", mThursdayCol7.getText().toString().trim());
                        map.put("mThursday8", mThursdayCol8.getText().toString().trim());

                        map.put("mFriday1", mFridayCol1.getText().toString().trim());
                        map.put("mFriday2", mFridayCol2.getText().toString().trim());
                        map.put("mFriday3", mFridayCol3.getText().toString().trim());
                        map.put("mFriday4", mFridayCol4.getText().toString().trim());
                        map.put("mFriday5", mFridayCol5.getText().toString().trim());
                        map.put("mFriday6", mFridayCol6.getText().toString().trim());
                        map.put("mFriday7", mFridayCol7.getText().toString().trim());
                        map.put("mFriday8", mFridayCol8.getText().toString().trim());

                        map.put("mSaturday1", mSaturdayCol1.getText().toString().trim());
                        map.put("mSaturday2", mSaturdayCol2.getText().toString().trim());
                        map.put("mSaturday3", mSaturdayCol3.getText().toString().trim());
                        map.put("mSaturday4", mSaturdayCol4.getText().toString().trim());
                        map.put("mSaturday5", mSaturdayCol5.getText().toString().trim());
                        map.put("mSaturday6", mSaturdayCol6.getText().toString().trim());
                        map.put("mSaturday7", mSaturdayCol7.getText().toString().trim());
                        map.put("mSaturday8", mSaturdayCol8.getText().toString().trim());

                        FirebaseDatabase.getInstance().getReference("SMSTIMETABLE").child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        dialogPlus.dismiss();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                            }
                        });
                    }
                });
            }
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_time_table_single_row,parent,false);
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        private TextView mPeriodRow1, mPeriodRow2, mPeriodRow3, mPeriodRow4, mPeriodRow5, mPeriodRow6, mPeriodRow7, mPeriodRow8;
        private TextView mMondayCol1, mMondayCol2, mMondayCol3, mMondayCol4, mMondayCol5, mMondayCol6, mMondayCol7, mMondayCol8;
        private TextView mTuesdayCol1, mTuesdayCol2, mTuesdayCol3, mTuesdayCol4, mTuesdayCol5, mTuesdayCol6, mTuesdayCol7, mTuesdayCol8;
        private TextView mWednesdayCol1, mWednesdayCol2, mWednesdayCol3, mWednesdayCol4, mWednesdayCol5, mWednesdayCol6, mWednesdayCol7, mWednesdayCol8;
        private TextView mThursdayCol1, mThursdayCol2, mThursdayCol3, mThursdayCol4, mThursdayCol5, mThursdayCol6, mThursdayCol7, mThursdayCol8;
        private TextView mFridayCol1, mFridayCol2, mFridayCol3, mFridayCol4, mFridayCol5, mFridayCol6, mFridayCol7, mFridayCol8;
        private TextView mSaturdayCol1, mSaturdayCol2, mSaturdayCol3, mSaturdayCol4, mSaturdayCol5, mSaturdayCol6, mSaturdayCol7, mSaturdayCol8;
        private TextView mClass, mSection;
        private Button mEditBtn, mDeleteBtn;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            mClass = itemView.findViewById(R.id.Class);
            mSection = itemView.findViewById(R.id.Section);
            mEditBtn = itemView.findViewById(R.id.editBtn);
            mDeleteBtn = itemView.findViewById(R.id.deleteBtn);

            mPeriodRow1 = itemView.findViewById(R.id.period_row1);
            mPeriodRow2 = itemView.findViewById(R.id.period_row2);
            mPeriodRow3 = itemView.findViewById(R.id.period_row3);
            mPeriodRow4 = itemView.findViewById(R.id.period_row4);
            mPeriodRow5 = itemView.findViewById(R.id.period_row5);
            mPeriodRow6 = itemView.findViewById(R.id.period_row6);
            mPeriodRow7 = itemView.findViewById(R.id.period_row7);
            mPeriodRow8 = itemView.findViewById(R.id.period_row8);

            mMondayCol1 = itemView.findViewById(R.id.Monday_col1);
            mMondayCol2 = itemView.findViewById(R.id.Monday_col2);
            mMondayCol3 = itemView.findViewById(R.id.Monday_col3);
            mMondayCol4 = itemView.findViewById(R.id.Monday_col4);
            mMondayCol5 = itemView.findViewById(R.id.Monday_col5);
            mMondayCol6 = itemView.findViewById(R.id.Monday_col6);
            mMondayCol7 = itemView.findViewById(R.id.Monday_col7);
            mMondayCol8 = itemView.findViewById(R.id.Monday_col8);

            mTuesdayCol1  = itemView.findViewById(R.id.Tuesday_col1);
            mTuesdayCol2  = itemView.findViewById(R.id.Tuesday_col2);
            mTuesdayCol3  = itemView.findViewById(R.id.Tuesday_col3);
            mTuesdayCol4  = itemView.findViewById(R.id.Tuesday_col4);
            mTuesdayCol5  = itemView.findViewById(R.id.Tuesday_col5);
            mTuesdayCol6  = itemView.findViewById(R.id.Tuesday_col6);
            mTuesdayCol7  = itemView.findViewById(R.id.Tuesday_col7);
            mTuesdayCol8  = itemView.findViewById(R.id.Tuesday_col8);

            mWednesdayCol1 = itemView.findViewById(R.id.Wednesday_col1);
            mWednesdayCol2 = itemView.findViewById(R.id.Wednesday_col2);
            mWednesdayCol3 = itemView.findViewById(R.id.Wednesday_col3);
            mWednesdayCol4 = itemView.findViewById(R.id.Wednesday_col4);
            mWednesdayCol5 = itemView.findViewById(R.id.Wednesday_col5);
            mWednesdayCol6 = itemView.findViewById(R.id.Wednesday_col6);
            mWednesdayCol7 = itemView.findViewById(R.id.Wednesday_col7);
            mWednesdayCol8 = itemView.findViewById(R.id.Wednesday_col8);

            mThursdayCol1 = itemView.findViewById(R.id.Thursday_col1);
            mThursdayCol2 = itemView.findViewById(R.id.Thursday_col2);
            mThursdayCol3 = itemView.findViewById(R.id.Thursday_col3);
            mThursdayCol4 = itemView.findViewById(R.id.Thursday_col4);
            mThursdayCol5 = itemView.findViewById(R.id.Thursday_col5);
            mThursdayCol6 = itemView.findViewById(R.id.Thursday_col6);
            mThursdayCol7 = itemView.findViewById(R.id.Thursday_col7);
            mThursdayCol8 = itemView.findViewById(R.id.Thursday_col8);

            mFridayCol1 = itemView.findViewById(R.id.Friday_col1);
            mFridayCol2 = itemView.findViewById(R.id.Friday_col2);
            mFridayCol3 = itemView.findViewById(R.id.Friday_col3);
            mFridayCol4 = itemView.findViewById(R.id.Friday_col4);
            mFridayCol5 = itemView.findViewById(R.id.Friday_col5);
            mFridayCol6 = itemView.findViewById(R.id.Friday_col6);
            mFridayCol7 = itemView.findViewById(R.id.Friday_col7);
            mFridayCol8 = itemView.findViewById(R.id.Friday_col8);

            mSaturdayCol1 = itemView.findViewById(R.id.Saturday_col1);
            mSaturdayCol2 = itemView.findViewById(R.id.Saturday_col2);
            mSaturdayCol3 = itemView.findViewById(R.id.Saturday_col3);
            mSaturdayCol4 = itemView.findViewById(R.id.Saturday_col4);
            mSaturdayCol5 = itemView.findViewById(R.id.Saturday_col5);
            mSaturdayCol6 = itemView.findViewById(R.id.Saturday_col6);
            mSaturdayCol7 = itemView.findViewById(R.id.Saturday_col7);
            mSaturdayCol8 = itemView.findViewById(R.id.Saturday_col8);
        }
    }
}

