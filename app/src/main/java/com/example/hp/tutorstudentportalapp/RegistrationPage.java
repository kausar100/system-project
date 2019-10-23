package com.example.hp.tutorstudentportalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity {
    Button button1, button2;
    private RadioGroup radioGroup;
    private EditText input_email, input_pass, input_con_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        button1 = findViewById(R.id.cancel_button_id);
        button2 = findViewById(R.id.register_button_id);

        input_email = (EditText) findViewById(R.id.editText2);
        input_pass = (EditText) findViewById(R.id.editText3);
        input_con_pass = (EditText) findViewById(R.id.editText4);

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
                if (selectedId == R.id.teacher) {
                    boolean check = VerificationMethod();
                    if (check) {
                        Intent intent = new Intent(RegistrationPage.this, TutorHomepage.class);
                        startActivity(intent);
                    }
                }
                else if(selectedId == R.id.student)
                {
                    boolean check = VerificationMethod();
                    if (check) {
                        Intent intent = new Intent(RegistrationPage.this, StudentHomepage.class);
                        startActivity(intent);
                    }
                }
                else{
                    Toast.makeText(RegistrationPage.this,"Please Choose an Account!!!",Toast.LENGTH_SHORT).show();
                }
            }


        }
    );
}

    public  boolean VerificationMethod() {

        String username, pass, con_pass;

        username = input_email.getText().toString();
        pass = input_pass.getText().toString();
        con_pass = input_con_pass.getText().toString();

        if (username.isEmpty()) {
            input_email.setError("Please Enter an Email Address !!!");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            input_email.setError("Please Enter a valid Email Address !!!");
            return false;
        }

        else if (pass.isEmpty()) {
            input_pass.setError("Please Enter a Password !!!");
            return false;
        }

        else if (con_pass.isEmpty()) {
            input_con_pass.setError("Please Re-Enter a Password !!!");
            return false;
        }

        else if (!pass.equals(con_pass)) {
            Toast.makeText(RegistrationPage.this, "Both Password Should be same!!!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
            return true;

    }
}
