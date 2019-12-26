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

import com.google.firebase.auth.FirebaseAuth;

public class TeacherHomepageActivity extends AppCompatActivity {
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

        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        Intent it = new Intent(TeacherHomepageActivity.this, ProfileTeacherActivity.class);
                        startActivity(it);
                        break;


                    case R.id.ctm:
                        Intent it2 = new Intent(getApplicationContext(), TakeCtMarkActivity.class);
                        startActivity(it2);
                        //Toast.makeText(TeacherHomepageActivity.this, "ct mark", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.attendence:
                        Intent it3 = new Intent(getApplicationContext(), TakeAttendanceActivity.class);
                        startActivity(it3);
                        //Toast.makeText(TeacherHomepageActivity.this, "attendence", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.result:
                        Intent it4 = new Intent(getApplicationContext(), FindResultActivity.class);
                        startActivity(it4);
                        //Toast.makeText(TeacherHomepageActivity.this, "request", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.post:
                        Toast.makeText(TeacherHomepageActivity.this, "post to student", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.fileshare:
                        Intent it5 = new Intent(getApplicationContext(), FileShareActivity.class);
                        startActivity(it5);
                        //Toast.makeText(TeacherHomepageActivity.this, "fileshare", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.request:
                        Intent intent1 = new Intent(TeacherHomepageActivity.this, StudentRequestActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.logout:
                        FirebaseAuth.getInstance().signOut();
                        Intent intent2 = new Intent(TeacherHomepageActivity.this, MainActivity.class);
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

        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TeacherHomepageActivity.this);
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
