package com.example.hp.tutorstudentportalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class YearActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView first1, first2, second1, second2, third1, third2, fourth1, fourth2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year);
        this.setTitle("Term & semester");

        first1 = findViewById(R.id.first1);
        first2 = findViewById(R.id.first2);
        second1 = findViewById(R.id.second1);
        second2 = findViewById(R.id.second2);
        third1 = findViewById(R.id.third1);
        third2 = findViewById(R.id.third2);
        fourth1 = findViewById(R.id.fourth1);
        fourth2 = findViewById(R.id.fourth2);

        first1.setOnClickListener(this);
        first2.setOnClickListener(this);
        second1.setOnClickListener(this);
        second2.setOnClickListener(this);
        third1.setOnClickListener(this);
        third2.setOnClickListener(this);
        fourth1.setOnClickListener(this);
        fourth2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.first1) {
            Toast.makeText(YearActivity.this, "firstyear firstsemester", Toast.LENGTH_SHORT).show();

        }if(v.getId()==R.id.first2) {
            Toast.makeText(YearActivity.this, "firstyear secondsemester", Toast.LENGTH_SHORT).show();

        }if(v.getId()==R.id.second1) {
            Toast.makeText(YearActivity.this, "secondyear firstsemester", Toast.LENGTH_SHORT).show();

        }if(v.getId()==R.id.second2) {
            Toast.makeText(YearActivity.this, "secondyear secondsemester", Toast.LENGTH_SHORT).show();

        }if(v.getId()==R.id.third1) {
            Toast.makeText(YearActivity.this, "thirdyear firstsemester", Toast.LENGTH_SHORT).show();

        }if(v.getId()==R.id.third2) {
            Toast.makeText(YearActivity.this, "thirdyear secondsemester", Toast.LENGTH_SHORT).show();

        }if(v.getId()==R.id.fourth1) {
            Toast.makeText(YearActivity.this, "fourthyear firstsemester", Toast.LENGTH_SHORT).show();

        }if(v.getId()==R.id.fourth2) {
            Toast.makeText(YearActivity.this, "fourthyear secondsemester", Toast.LENGTH_SHORT).show();

        }
    }
}
