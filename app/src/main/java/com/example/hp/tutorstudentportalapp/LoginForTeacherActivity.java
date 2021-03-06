package com.example.hp.tutorstudentportalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginForTeacherActivity extends AppCompatActivity {
    private Button button1, button2, button3;
    private EditText input_username, input_pass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_for_teacher);
        this.setTitle("Login Page teacher");


        button1 = (Button) findViewById(R.id.login_button_id);
        button2 = (Button) findViewById(R.id.cancel_button_id);
        button3 = (Button) findViewById(R.id.go_register_id);

        input_username = (EditText) findViewById(R.id.input_username);
        input_pass = (EditText) findViewById(R.id.input_pass);

        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null){
            Toast.makeText(LoginForTeacherActivity.this, "Successfully Login AS A TEACHER!!!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginForTeacherActivity.this, TeacherHomepageActivity.class);
            startActivity(intent);
        }

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginForTeacherActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginForTeacherActivity.this, RegistrationForTeacherActivity.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }

        });
    }

    private void userLogin() {

        final String username, pass;

        username = input_username.getText().toString();
        pass = input_pass.getText().toString();

        if (username.isEmpty()) {
            input_username.setError("Please Enter an Email Address !!!");
            input_username.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            input_username.setError("Please Enter a valid Email Address !!!");
            input_username.requestFocus();
            return;
        }

        if (pass.isEmpty()) {
            input_pass.setError("Please Enter a Password !!!");
            input_pass.requestFocus();
            return;
        }


        mAuth.signInWithEmailAndPassword(username, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(LoginForTeacherActivity.this, "Successfully Login AS A TEACHER!!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginForTeacherActivity.this, TeacherHomepageActivity.class);
                    startActivity(intent);


                } else {

                    Toast.makeText(LoginForTeacherActivity.this, "Error : " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
}