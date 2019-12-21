package com.example.hp.tutorstudentportalapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowCTMarkActivity extends AppCompatActivity {
    ListView listView;
    Spinner dept, ct_no;
    Button fetch;
    DatabaseReference databaseReference;
    private List<FetchCtMark> list;
    private StdCustomAdapter customAdapter;
    private String selectDept, selectCtNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ctmark);
        this.setTitle("ct mark show page");

        dept = findViewById(R.id.showctdepartmentID);
        ct_no = findViewById(R.id.ctnoID);
        fetch = findViewById(R.id.fetchctmark);
    }

    @Override
    protected void onStart() {

        super.onStart();
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectDept = dept.getSelectedItem().toString();
                selectCtNum = ct_no.getSelectedItem().toString();


                if (selectDept.equals("Choose a Department")) {
                    Toast.makeText(getApplicationContext(), "Please Choose a Department", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (selectCtNum.equals("Choose CT")) {
                    Toast.makeText(getApplicationContext(), "Please Choose CT Number", Toast.LENGTH_SHORT).show();
                    return;
                }

                listView = findViewById(R.id.showctresult);
                list = new ArrayList<>();
                databaseReference = FirebaseDatabase.getInstance().getReference("CTMARK").child(selectDept).child(selectCtNum);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        list.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            FetchCtMark fetchItem = dataSnapshot1.getValue(FetchCtMark.class);
                            list.add(fetchItem);

                        }
                        listView.setAdapter(customAdapter);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
                customAdapter = new StdCustomAdapter(ShowCTMarkActivity.this, list);
            }
        });
    }
}
