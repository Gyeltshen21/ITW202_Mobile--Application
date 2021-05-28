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

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class AdminNewAddDetailsAdapter extends FirebaseRecyclerAdapter<AdminNewDetailsHelperClass, AdminNewAddDetailsAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdminNewAddDetailsAdapter(@NonNull FirebaseRecyclerOptions<AdminNewDetailsHelperClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myViewHolder holder, final int position, @NonNull final AdminNewDetailsHelperClass adminNewDetailsHelperClass) {
        holder.AdminName.setText("Name: " +adminNewDetailsHelperClass.getName());
        holder.AdminID.setText("Employee ID: " +adminNewDetailsHelperClass.getEmployeeid());
        holder.AdminEmail.setText("Email: " +adminNewDetailsHelperClass.getEmail());
        holder.AdminPhoneNo.setText("Phone: " +adminNewDetailsHelperClass.getPhoneNo());
        holder.AdminCourse.setText("Course: " +adminNewDetailsHelperClass.getCourse());
        holder.AdminClass.setText("Class: " +adminNewDetailsHelperClass.getStandard());
        Glide.with(holder.AdminImage.getContext()).load(adminNewDetailsHelperClass.getFileUri()).into(holder.AdminImage);
        holder.AdminEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.AdminName.getContext())
                        .setContentHolder(new ViewHolder(R.layout.admin_details_view_dialog_content))
                        .setExpanded(true,2000)
                        .create();
                //Reference
                View AdminView = dialogPlus.getHolderView();
                Button updateBtn = AdminView.findViewById(R.id.Admin_next_btn);
                ImageView imageView = AdminView.findViewById(R.id.ProfilePic);
                TextInputLayout AdminName = AdminView.findViewById(R.id.EmlpoyeeName);
                TextInputLayout AdminID = AdminView.findViewById(R.id.AdminID);
                TextInputLayout AdminEmail = AdminView.findViewById(R.id.AdminEmail);
                TextInputLayout AdminPhoneNo = AdminView.findViewById(R.id.AdminPhoneNo);
                TextInputLayout AdminCourse = AdminView.findViewById(R.id.AdminCourse);
                TextInputLayout AdminClass = AdminView.findViewById(R.id.AdminClass);

                //Displaying
                Glide.with(imageView).load(adminNewDetailsHelperClass.getFileUri()).into(imageView);
                AdminName.getEditText().setText(adminNewDetailsHelperClass.getName());
                AdminID.getEditText().setText(adminNewDetailsHelperClass.getEmployeeid());
                AdminEmail.getEditText().setText(adminNewDetailsHelperClass.getEmail());
                AdminPhoneNo.getEditText().setText(adminNewDetailsHelperClass.getPhoneNo());
                AdminCourse.getEditText().setText(adminNewDetailsHelperClass.getCourse());
                AdminClass.getEditText().setText(adminNewDetailsHelperClass.getStandard());
                dialogPlus.show();

                updateBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("name", AdminName.getEditText().getText().toString().trim());
                        map.put("employeeid", AdminID.getEditText().getText().toString().trim());
                        map.put("email", AdminEmail.getEditText().getText().toString().trim());
                        map.put("phoneNo", AdminPhoneNo.getEditText().getText().toString().trim());
                        map.put("course", AdminCourse.getEditText().getText().toString().trim());
                        map.put("standard", AdminClass.getEditText().getText().toString().trim());
                        FirebaseDatabase.getInstance().getReference().child("SMSemployeeDetails").child(getRef(position).getKey()).updateChildren(map)
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
        holder.AdminDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.AdminName.getContext());
                builder.setTitle("Delete");
                builder.setMessage("Are sure you want to delete?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("SMSemployeeDetails").child(getRef(position).getKey()).removeValue();
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
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_details_view_single_row,parent,false);
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        private ImageView AdminImage, AdminEdit, AdminDelete;
        private TextView AdminName, AdminID, AdminEmail, AdminPhoneNo, AdminCourse, AdminClass;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            AdminEdit = itemView.findViewById(R.id.AdminEdit);
            AdminDelete = itemView.findViewById(R.id.AdminDelete);
            AdminImage = itemView.findViewById(R.id.ProfilePic);
            AdminName = itemView.findViewById(R.id.AdminName);
            AdminID = itemView.findViewById(R.id.AdminID);
            AdminEmail = itemView.findViewById(R.id.AdminEmail);
            AdminPhoneNo = itemView.findViewById(R.id.AdminPhoneNo);
            AdminCourse = itemView.findViewById(R.id.AdminCourse);
            AdminClass = itemView.findViewById(R.id.AdminClass);
        }
    }
}
