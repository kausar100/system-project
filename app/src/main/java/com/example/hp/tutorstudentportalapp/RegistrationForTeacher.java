package com.example.hp.tutorstudentportalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationForTeacher extends AppCompatActivity {
    private Button button1, button2, button;
    private EditText input_username, input_pass, input_con_pass, f_name, l_name, roll;
    private FirebaseAuth mAuth;
    private Spinner Department;
    private DatabaseReference parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_for_teacher);
        this.setTitle("Registration Page for teacher");

        getSupportActionBar().setTitle("welcome page");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();

        button=findViewById(R.id.go_login_id);
        button1 = (Button) findViewById(R.id.cancel_button_id);
        button2 = (Button) findViewById(R.id.register_button_id);

        input_username = (EditText) findViewById(R.id.input_username);
        input_pass = (EditText) findViewById(R.id.input_pass);
        input_con_pass = (EditText) findViewById(R.id.input_con_pass);

        f_name = (EditText) findViewById(R.id.firstName);
        l_name = (EditText) findViewById(R.id.lastName);
        Department = (Spinner) findViewById(R.id.spin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginForTeacher.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationForTeacher.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username, pass, con_pass, email, dept, first_name, last_name, std_roll;

                first_name = f_name.getText().toString();
                last_name = l_name.getText().toString();
                username = f_name.getText().toString() + " " + l_name.getText().toString();
                pass = input_pass.getText().toString();
                con_pass = input_con_pass.getText().toString();
                email = input_username.getText().toString();
                dept = Department.getSelectedItem().toString();


                if (first_name.isEmpty()) {
                    f_name.setError("Please Enter Your First Name !!!");
                    f_name.requestFocus();
                    return;
                }

                if (last_name.isEmpty()) {
                    l_name.setError("Please Enter Your Last Name !!!");
                    l_name.requestFocus();
                    return;
                }

                if (email.isEmpty()) {
                    input_username.setError("Please Enter Your Email Address !!!");
                    input_username.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    input_username.setError("Please Enter a valid Email Address !!!");
                    input_username.requestFocus();
                    return;
                }

                if (pass.isEmpty()) {
                    input_pass.setError("Please Enter a Password !!!");
                    input_pass.requestFocus();
                    return;
                }

                if (pass.length() < 6) {
                    input_pass.setError("Minimum Length of Password is 6 !!!");
                    input_pass.requestFocus();
                    return;
                }

                if (con_pass.isEmpty()) {
                    input_con_pass.setError("Please Re-Enter a Password !!!");
                    input_con_pass.requestFocus();
                    return;
                }

                if (!pass.equals(con_pass)) {
                    input_con_pass.setError("Password and Confirm Password is not SAME !!!");
                    input_con_pass.requestFocus();
                    return;
                }

                if(dept.equals("Choose a department"))
                {
                    Toast.makeText(getApplicationContext(),"Please Select a Department !!!",Toast.LENGTH_SHORT).show();

                }


                mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            parent = FirebaseDatabase.getInstance().getReference("TEACHER");
                            String temp = email.replace(".", ",");
                            parent.child(temp).child("Name").setValue(username);
                            parent.child(temp).child("Department").setValue(dept);
                            parent.child(temp).child("Password").setValue(pass);

                            Toast.makeText(getApplicationContext(), "Successfully Registered as a Teacher !!!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegistrationForTeacher.this,LoginForTeacher.class);
                            startActivity(intent);
                        }
                        else {

                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(getApplicationContext(), "User Is Already Registered !!!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Error : " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });


            }
        });
    }
}
