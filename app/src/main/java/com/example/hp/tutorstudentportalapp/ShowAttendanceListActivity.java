package com.example.hp.tutorstudentportalapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowAttendanceListActivity extends AppCompatActivity {
    ListView listView;
    Spinner dept, sec;
    Button datechoose, fetch;
    DatabaseReference databaseReference;
    private List<FetchItem> list;
    private CustomAdapter customAdapter;
    private DatePickerDialog datePickerDialog;
    private String selectDept, selectSec, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_attendance_list);
        this.setTitle("attendancelist show page");

        dept = findViewById(R.id.showdepartmentID);
        sec = findViewById(R.id.showsectionID);
        datechoose = findViewById(R.id.datepickID);
        fetch = findViewById(R.id.fetchdata);


    }

    @Override
    protected void onStart() {

        super.onStart();
        datechoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectDept = dept.getSelectedItem().toString();
                selectSec = sec.getSelectedItem().toString();
                if (selectDept.equals("Choose a Department")) {
                    Toast.makeText(getApplicationContext(), "Please Choose a Department", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (selectSec.equals("Choose a Section")) {
                    Toast.makeText(getApplicationContext(), "Please Choose a Section", Toast.LENGTH_SHORT).show();
                    return;
                }
                DatePicker datePicker = new DatePicker(ShowAttendanceListActivity.this);

                int currentYear = datePicker.getYear();
                int currentMonth = (datePicker.getMonth())+1;
                int currentDay = datePicker.getDayOfMonth();

                datePickerDialog = new DatePickerDialog(ShowAttendanceListActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        datechoose.setText(year+"-"+(month+1)+"-"+dayOfMonth);
                        date = datechoose.getText().toString();
                    }
                }, currentYear, currentMonth, currentDay);
                datePickerDialog.show();

            }
        });

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView = findViewById(R.id.showattendanceID);
                list = new ArrayList<>();
                databaseReference = FirebaseDatabase.getInstance().getReference("ATTENDANCE").child(selectDept).child(selectSec).child(date);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        list.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            FetchItem fetchItem = dataSnapshot1.getValue(FetchItem.class);
                            list.add(fetchItem);

                        }
                        listView.setAdapter(customAdapter);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
                customAdapter = new CustomAdapter(ShowAttendanceListActivity.this, list);
            }
        });
    }
}
