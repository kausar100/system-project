package com.example.hp.tutorstudentportalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class TakeCtMarkActivity extends AppCompatActivity {
    private ListView mListview;
    private ArrayList<String> mArrData;
    private StdAdapter mAdapter;
    private Button button, ct;
    EditText editText, editText2;
    Spinner dept, ct_no;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_take_ct_mark);
        this.setTitle("take ct mark page");

        mListview = (ListView) findViewById(R.id.listStudent);

        editText = findViewById(R.id.cttotalstudent);
        editText2 = findViewById(R.id.ctinitialroll);
        dept = findViewById(R.id.ctdepartmentID);
        ct_no = findViewById(R.id.ctno);

        ct = findViewById(R.id.showctmarkID);
        ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TakeCtMarkActivity.this,ShowCTMarkActivity.class);
                startActivity(intent);
            }
        });


        button = findViewById(R.id.go);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String department = dept.getSelectedItem().toString();
                final String ct_num = ct_no.getSelectedItem().toString();

                if (department.equals("Choose a Department")) {
                    Toast.makeText(getApplicationContext(), "Please Choose a Department", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (ct_num.equals("Choose CT")) {
                    Toast.makeText(getApplicationContext(), "Please Choose CT Number", Toast.LENGTH_SHORT).show();
                    return;
                }

                ListViewItem listViewItem = new ListViewItem(department, ct_num);
                int tsz = 0;

                try {
                    tsz = Integer.parseInt(editText.getText().toString());
                } catch (NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }

                int roll = 0;
                String[] str = new String[tsz];

                try {
                    roll = Integer.parseInt(editText2.getText().toString());
                    for (int i = 0; i < tsz; i++) {
                        str[i] = Integer.toString(roll++);
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }

                mArrData = new ArrayList<String>(Arrays.asList(str));
                // Initialize adapter and set adapter to list view
                mAdapter = new StdAdapter(TakeCtMarkActivity.this, mArrData, listViewItem);
                mListview.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }
        });


    }
}

