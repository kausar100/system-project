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

public class ProfileStudent extends AppCompatActivity {
    TextView UserName, Email, Dept, nameId, passId, rollID;
    DatabaseReference databaseReference;
    String std_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_student);
        this.setTitle("profile Page student");

        UserName = (TextView) findViewById(R.id.username);
        Email = (TextView) findViewById(R.id.email);
        Dept = (TextView) findViewById(R.id.department);
        nameId = (TextView) findViewById(R.id.name);
        passId = (TextView) findViewById(R.id.password);
        rollID = (TextView) findViewById(R.id.roll);


        Bundle bundle = getIntent().getExtras();
        std_profile = bundle.getString("STUDENT_PROFILE");

        if(bundle!=null)
        {
            if (std_profile != null) {

                //std_profile=null;
                String key = std_profile.replace(".", ",");
                databaseReference = FirebaseDatabase.getInstance().getReference("STUDENT").child(key);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String Department = dataSnapshot.child("Department").getValue().toString();
                        String User_Name = dataSnapshot.child("Name").getValue().toString();
                        String Password = dataSnapshot.child("Password").getValue().toString();
                        String Roll = dataSnapshot.child("Roll").getValue().toString();

                        Email.setText(std_profile);
                        UserName.setText(User_Name);
                        Dept.setText(Department);
                        nameId.setText(User_Name);
                        passId.setText(Password);
                        rollID.setText(Roll);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

        }
    }
}
