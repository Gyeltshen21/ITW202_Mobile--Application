package com.gcit.sms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class TeacherAdapter extends FirebaseRecyclerAdapter<AdminNewDetailsHelperClass, TeacherAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public TeacherAdapter(@NonNull FirebaseRecyclerOptions<AdminNewDetailsHelperClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myViewHolder holder, final int position, @NonNull final AdminNewDetailsHelperClass adminNewDetailsHelperClass) {
        holder.TeacherName.setText("Name: " +adminNewDetailsHelperClass.getName());
        holder.TeacherID.setText("Employee ID: " +adminNewDetailsHelperClass.getEmployeeid());
        holder.TeacherEmail.setText("Email: " +adminNewDetailsHelperClass.getEmail());
        holder.TeacherPhoneNo.setText("Phone: " +adminNewDetailsHelperClass.getPhoneNo());
        holder.TeacherCourse.setText("Course: " +adminNewDetailsHelperClass.getCourse());
        holder.TeacherClass.setText("Class: " +adminNewDetailsHelperClass.getStandard());
        Glide.with(holder.TeacherImage.getContext()).load(adminNewDetailsHelperClass.getFileUri()).into(holder.TeacherImage);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teache_details_view_single_row,parent,false);
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        private ImageView TeacherImage;
        private TextView TeacherName, TeacherID, TeacherEmail, TeacherPhoneNo, TeacherCourse, TeacherClass;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            
            TeacherImage = itemView.findViewById(R.id.ProfilePic);
            TeacherName = itemView.findViewById(R.id.TeacherName);
            TeacherID = itemView.findViewById(R.id.TeacherID);
            TeacherEmail = itemView.findViewById(R.id.TeacherEmail);
            TeacherPhoneNo = itemView.findViewById(R.id.TeacherPhoneNo);
            TeacherCourse = itemView.findViewById(R.id.TeacherCourse);
            TeacherClass = itemView.findViewById(R.id.TeacherClass);
        }
    }
}
