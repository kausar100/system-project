package com.example.hp.tutorstudentportalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ResultOfSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_search);

        getSupportActionBar().setTitle("StudentHomepage");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        String sbname = bundle.getString("SEARCH BY NAME");
        String sbemail = bundle.getString("SEARCH BY EMAIL");
        String sbdepartment = bundle.getString("SEARCH BY DEPARTMENT");

        if(bundle!=null){
            if(sbname!=null){
                Toast.makeText(getApplicationContext(),"search by name value: "+sbname,Toast.LENGTH_SHORT).show();

            }
            else if (sbemail!=null){
                Toast.makeText(getApplicationContext(),"search by email value: "+sbemail,Toast.LENGTH_SHORT).show();


            }
            else if(sbdepartment!=null){
                Toast.makeText(getApplicationContext(),"search by department value: "+sbdepartment,Toast.LENGTH_SHORT).show();


            }
        }

    }
}
