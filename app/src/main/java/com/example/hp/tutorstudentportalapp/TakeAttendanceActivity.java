package com.example.hp.tutorstudentportalapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class TakeAttendanceActivity extends AppCompatActivity {
    private ListView mListview;
    private ArrayList<String> mArrData;
    private SchoolAdapter mAdapter;
    private Button button, button2;
    EditText editText, editText2;
    Spinner sec, dept;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_take_attendance);
        this.setTitle("take attendance page");

        mListview = (ListView) findViewById(R.id.listSchool);

        editText = findViewById(R.id.totalstudent);
        editText2 = findViewById(R.id.initialroll);
        sec = findViewById(R.id.sectionID);
        dept = findViewById(R.id.departmentID);

        button2 = findViewById(R.id.showattID);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TakeAttendanceActivity.this,ShowAttendanceListActivity.class);
                startActivity(intent);
            }
        });


        button = findViewById(R.id.ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String section = sec.getSelectedItem().toString();
                final String department = dept.getSelectedItem().toString();
                String date;
                date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

                if (department.equals("Choose a Department")) {
                    Toast.makeText(getApplicationContext(), "Please Choose a Department", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (section.equals("Choose a Section")) {
                    Toast.makeText(getApplicationContext(), "Please Choose a Section", Toast.LENGTH_SHORT).show();
                    return;
                }
                ListViewItem listViewItem = new ListViewItem(section, department, date);

                int ts = 0;

                try {
                    ts = Integer.parseInt(editText.getText().toString());
                } catch (NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }
                final int sz = ts / 2;
                String[] str = new String[sz];

                int roll = 0;

                try {
                    roll = Integer.parseInt(editText2.getText().toString());
                    if ("A".equals(section)) {
                        for (int i = 0; i < sz; i++) {
                            str[i] = Integer.toString(roll++);
                        }
                    } else if ("B".equals(section)) {
                        roll += 60;
                        for (int i = 0; i < sz; i++) {
                            str[i] = Integer.toString(roll++);
                        }

                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }

                mArrData = new ArrayList<String>(Arrays.asList(str));
                // Initialize adapter and set adapter to list view
                mAdapter = new SchoolAdapter(TakeAttendanceActivity.this, mArrData, listViewItem);
                mListview.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }
        });


    }
}

