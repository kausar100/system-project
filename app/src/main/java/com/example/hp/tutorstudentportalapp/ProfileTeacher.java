package com.example.hp.tutorstudentportalapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileTeacher extends AppCompatActivity {
    TextView UserName, Email, Dept, nameId, passId;
    DatabaseReference databaseReference;
    String teacher_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_teacher);
        this.setTitle("profile Page teacher");

        UserName = (TextView) findViewById(R.id.username);
        Email = (TextView) findViewById(R.id.email);
        Dept = (TextView) findViewById(R.id.department);
        nameId = (TextView) findViewById(R.id.name);
        passId = (TextView) findViewById(R.id.password);


        Bundle bundle = getIntent().getExtras();
        teacher_profile = bundle.getString("TEACHER_PROFILE");

        if(bundle!=null)
        {
            if (teacher_profile != null) {

                //std_profile=null;
                String key = teacher_profile.replace(".", ",");
                databaseReference = FirebaseDatabase.getInstance().getReference("TEACHER").child(key);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String Department = dataSnapshot.child("Department").getValue().toString();
                        String User_Name = dataSnapshot.child("Name").getValue().toString();
                        String Password = dataSnapshot.child("Password").getValue().toString();

                        Email.setText(teacher_profile);
                        UserName.setText(User_Name);
                        Dept.setText(Department);
                        nameId.setText(User_Name);
                        passId.setText(Password);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

        }
    }
}
