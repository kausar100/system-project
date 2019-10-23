package com.example.hp.tutorstudentportalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class LoginPage extends AppCompatActivity {
    Button button1, button2, button3;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        button1 = (Button) findViewById(R.id.login_button_id);
        button2 = (Button) findViewById(R.id.cancel_button_id);
        button3 = (Button) findViewById(R.id.go_register_id);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup = (RadioGroup) findViewById(R.id.radio);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if(selectedId==R.id.teacher){
                    Intent intent = new Intent(LoginPage.this, TutorHomepage.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(LoginPage.this, StudentHomepage.class);
                    startActivity(intent);
                }


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(LoginPage.this, MainActivity.class);
                startActivity(intent1);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2= new Intent(LoginPage.this, RegistrationPage.class);
                startActivity(intent2);
            }
        });
    }
}