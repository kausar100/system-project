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

public class StudentHomepage extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_homepage);
        this.setTitle("Welcome to Student Homepage");

        dl = (DrawerLayout) findViewById(R.id.homepage);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final Bundle bundle2 = getIntent().getExtras();
        final String get_email2 = bundle2.getString("STUDENT_LOGIN");

        nv =  findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        //Toast.makeText(StudentHomepage.this, "Profile", Toast.LENGTH_SHORT).show();
                        Intent it = new Intent(StudentHomepage.this,ProfileStudent.class);
                        if(bundle2!=null){
                            if(get_email2!=null){
                                it.putExtra("STUDENT_PROFILE",get_email2);
                            }
                        }
                        startActivity(it);
                        break;

                    case R.id.notification:
                        Toast.makeText(StudentHomepage.this,"notification",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.message:
                        Toast.makeText(StudentHomepage.this,"message",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.pft:
                        Toast.makeText(StudentHomepage.this,"Post From Teacher",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.findteacher:
                       // Toast.makeText(StudentHomepage.this,"Find Teacher",Toast.LENGTH_SHORT).show();
                        Intent it2 = new Intent(getApplicationContext(),FindTeacherActivity.class);
                        startActivity(it2);
                        break;

                    case R.id.result:
                        Toast.makeText(StudentHomepage.this,"result",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.logout:
                        Intent intent = new Intent(StudentHomepage.this,MainActivity.class);
                        startActivity(intent); break;
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
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(StudentHomepage.this);
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
