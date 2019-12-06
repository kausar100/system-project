package com.example.hp.tutorstudentportalapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class TeacherHomepage extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_homepage);
        this.setTitle("Welcome to Teacher Homepage");

        dl = (DrawerLayout) findViewById(R.id.homepage);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final Bundle bundle = getIntent().getExtras();
        final String get_email = bundle.getString("TEACHER_LOGIN");

        nv =  findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        //Toast.makeText(TeacherHomepage.this, "Profile", Toast.LENGTH_SHORT).show();
                        Intent it = new Intent(TeacherHomepage.this,ProfileTeacher.class);
                        if(bundle!=null){
                            if(get_email!=null){
                                it.putExtra("TEACHER_PROFILE",get_email);
                            }
                        }
                        startActivity(it);
                        break;

                    case R.id.main:
                        Intent intent = new Intent(TeacherHomepage.this, TeacherMainMenu.class);
                        startActivity(intent);
                        break;

                    case R.id.request:
                        Toast.makeText(TeacherHomepage.this, "Student Request", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.logout:
                        Intent intent2 = new Intent(TeacherHomepage.this,MainActivity.class);
                        startActivity(intent2);
                        break;
                }

                dl.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (dl.isDrawerOpen(GravityCompat.START)) {
            dl.closeDrawer(GravityCompat.START);

        }
        else
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TeacherHomepage.this);
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setMessage(R.string.exit);

            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    moveTaskToBack(true);
                }
            });
            alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

    }
}