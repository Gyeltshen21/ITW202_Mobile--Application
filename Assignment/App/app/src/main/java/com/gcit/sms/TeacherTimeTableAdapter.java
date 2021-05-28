package com.gcit.sms;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class TeacherTimeTableAdapter extends FirebaseRecyclerAdapter<AdminTimeTableHelperClass, TeacherTimeTableAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public TeacherTimeTableAdapter(@NonNull FirebaseRecyclerOptions<AdminTimeTableHelperClass> options) {
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

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup Teacher, int viewType) {
        View view = LayoutInflater.from(Teacher.getContext()).inflate(R.layout.teacher_time_table_single_row,Teacher,false);
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

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            mClass = itemView.findViewById(R.id.Class);
            mSection = itemView.findViewById(R.id.Section);

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


