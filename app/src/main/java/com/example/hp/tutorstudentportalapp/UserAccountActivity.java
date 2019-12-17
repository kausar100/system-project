package com.example.hp.tutorstudentportalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class UserAccountActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    Button button;
    final String message2 = "MESSAGE_KEY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        getSupportActionBar().setTitle("user account choose page");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        final String message = intent.getStringExtra(message2);
        button = findViewById(R.id.go);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup =  findViewById(R.id.radio);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if((message.equals("LOGIN")) && (selectedId==R.id.teacher)){
                    Intent it = new Intent(UserAccountActivity.this, LoginForTeacherActivity.class);
                    startActivity(it);

                }
                else if((message.equals("LOGIN")) && (selectedId == R.id.student)){
                    Intent it2 = new Intent(UserAccountActivity.this, LoginForStudentActivity.class);
                    startActivity(it2);

                }
                else if((message.equals("REGISTRATION")) && (selectedId==R.id.teacher)){
                    Intent it3 = new Intent(UserAccountActivity.this, RegistrationForTeacherActivity.class);
                    startActivity(it3);

                }
                else if((message.equals("REGISTRATION")) && (selectedId == R.id.student)){
                    Intent it4 = new Intent(UserAccountActivity.this, RegistrationForStudentActivity.class);
                    startActivity(it4);

                }


            }
        });

    }
}


