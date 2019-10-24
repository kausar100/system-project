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

public class LoginPage extends AppCompatActivity {
    Button button1, button2, button3;
    private RadioGroup radioGroup;
    private EditText input_email, input_pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        this.setTitle("Welcome to Login Page");
        button1 = (Button) findViewById(R.id.login_button_id);
        button2 = (Button) findViewById(R.id.cancel_button_id);
        button3 = (Button) findViewById(R.id.go_register_id);

        input_email = (EditText) findViewById(R.id.editText2);
        input_pass = (EditText) findViewById(R.id.editText3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup = (RadioGroup) findViewById(R.id.radio);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == R.id.teacher) {
                    boolean check = VerificationMethod();
                    if (check) {
                        Intent intent = new Intent(LoginPage.this, TutorHomepage.class);
                        startActivity(intent);
                    }
                }
                else if(selectedId == R.id.student)
                {
                    boolean check = VerificationMethod();
                    if (check) {
                        Intent intent = new Intent(LoginPage.this, StudentHomepage.class);
                        startActivity(intent);
                    }
                }
                else{
                    Toast.makeText(LoginPage.this,"Please Choose an Account!!!",Toast.LENGTH_SHORT).show();
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

    public  boolean VerificationMethod() {

        String username, pass;

        username = input_email.getText().toString();
        pass = input_pass.getText().toString();

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
        else
            return true;

    }
}