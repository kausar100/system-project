package com.example.hp.tutorstudentportalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class RegistrationPage extends AppCompatActivity {
    Button button1, button2;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        button1 = findViewById(R.id.cancel_button_id);
        button2 = findViewById(R.id.register_button_id);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(RegistrationPage.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup = (RadioGroup) findViewById(R.id.radio);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if(selectedId==R.id.teacher){
                    Intent intent = new Intent(RegistrationPage.this, TutorHomepage.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(RegistrationPage.this, StudentHomepage.class);
                    startActivity(intent);
                }

            }
        });
    }
}
