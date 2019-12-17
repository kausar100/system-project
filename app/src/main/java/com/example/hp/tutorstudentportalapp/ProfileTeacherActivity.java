package com.example.hp.tutorstudentportalapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileTeacherActivity extends AppCompatActivity {
    TextView UserName, Email, Dept, nameId, passId;
    DatabaseReference databaseReference;
    Teacher teacher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_teacher);
        this.setTitle("profile Page teacher");

        teacher = new Teacher();

        UserName = (TextView) findViewById(R.id.username);
        Email = (TextView) findViewById(R.id.email);
        Dept = (TextView) findViewById(R.id.department);
        nameId = (TextView) findViewById(R.id.name);
        passId = (TextView) findViewById(R.id.password);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final String key = FirebaseAuth.getInstance().getCurrentUser().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference("TEACHER");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    teacher = dataSnapshot.child(key).getValue(Teacher.class);

                    if (teacher != null) {
                        Email.setText(teacher.getEmail());
                    }
                    if (teacher != null) {
                        UserName.setText(teacher.getName());
                        nameId.setText(teacher.getName());
                    }
                    if (teacher != null) {
                        Dept.setText(teacher.getDepartment());
                    }
                    if (teacher != null) {
                        passId.setText(teacher.getPassword());
                    }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
