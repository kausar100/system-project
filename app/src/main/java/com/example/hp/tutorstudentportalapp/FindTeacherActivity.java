package com.example.hp.tutorstudentportalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class FindTeacherActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    Button button;
    EditText editText;
    String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_teacher);


        button = findViewById(R.id.search_button);
        editText = findViewById(R.id.searchID);
        radioGroup =  findViewById(R.id.radio);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedId = radioGroup.getCheckedRadioButtonId();

                if(selectedId==R.id.sbname){
                    text = editText.getText().toString().trim();
                    Intent intent = new Intent(getApplicationContext(),ResultOfSearch.class);
                    intent.putExtra("SEARCH BY NAME",text);
                    startActivity(intent);

                }
                else if(selectedId==R.id.sbemail){

                    text = editText.getText().toString().trim();
                    Intent intent = new Intent(getApplicationContext(),ResultOfSearch.class);
                    intent.putExtra("SEARCH BY EMAIL",text);
                    startActivity(intent);

                }
                else if(selectedId==R.id.sbdepartment){
                    text = editText.getText().toString().trim();
                    Intent intent = new Intent(getApplicationContext(),ResultOfSearch.class);
                    intent.putExtra("SEARCH BY DEPARTMENT",text);
                    startActivity(intent);
                }


            }
        });
    }
}
