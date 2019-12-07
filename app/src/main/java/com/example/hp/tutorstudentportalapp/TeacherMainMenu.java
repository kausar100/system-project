package com.example.hp.tutorstudentportalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class TeacherMainMenu extends AppCompatActivity implements View.OnClickListener {
    private CardView first1, first2, second1, second2, third1, third2, fourth1, fourth2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main_menu);
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
            Toast.makeText(TeacherMainMenu.this, "firstyear firstsemester", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(getApplicationContext(),FirstYearFirstSemester.class);
            startActivity(intent1);

        }if(v.getId()==R.id.first2) {
            Toast.makeText(TeacherMainMenu.this, "firstyear secondsemester", Toast.LENGTH_SHORT).show();
            Intent intent2 = new Intent(getApplicationContext(),FirstYearSecondSemester.class);
            startActivity(intent2);

        }if(v.getId()==R.id.second1) {
            Toast.makeText(TeacherMainMenu.this, "secondyear firstsemester", Toast.LENGTH_SHORT).show();
            Intent intent3 = new Intent(getApplicationContext(),SecondYearFirstSemester.class);
            startActivity(intent3);

        }if(v.getId()==R.id.second2) {
            Toast.makeText(TeacherMainMenu.this, "secondyear secondsemester", Toast.LENGTH_SHORT).show();
            Intent intent4 = new Intent(getApplicationContext(),SecondYearSecondSemester.class);
            startActivity(intent4);

        }if(v.getId()==R.id.third1) {
            Toast.makeText(TeacherMainMenu.this, "thirdyear firstsemester", Toast.LENGTH_SHORT).show();
            Intent intent5 = new Intent(getApplicationContext(),ThirdYearFirstSemester.class);
            startActivity(intent5);

        }if(v.getId()==R.id.third2) {
            Toast.makeText(TeacherMainMenu.this, "thirdyear secondsemester", Toast.LENGTH_SHORT).show();
            Intent intent6 = new Intent(getApplicationContext(),ThirdYearSecondSemester.class);
            startActivity(intent6);

        }if(v.getId()==R.id.fourth1) {
            Toast.makeText(TeacherMainMenu.this, "fourthyear firstsemester", Toast.LENGTH_SHORT).show();
            Intent intent7 = new Intent(getApplicationContext(),FourthYearFirstSemester.class);
            startActivity(intent7);

        }if(v.getId()==R.id.fourth2) {
            Toast.makeText(TeacherMainMenu.this, "fourthyear secondsemester", Toast.LENGTH_SHORT).show();
            Intent intent8 = new Intent(getApplicationContext(),FourthYearSecondSemester.class);
            startActivity(intent8);

        }
    }
}
