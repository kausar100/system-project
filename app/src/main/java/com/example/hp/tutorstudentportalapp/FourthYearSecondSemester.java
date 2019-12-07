package com.example.hp.tutorstudentportalapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class FourthYearSecondSemester extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_year_second_semester);
        this.setTitle("fourth year second semester");

        dl = (DrawerLayout) findViewById(R.id.fouryss);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.attendence:
                        Toast.makeText(getApplicationContext(),"attendence",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ctm:
                        Toast.makeText(getApplicationContext(),"CT mark",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.post:
                        Toast.makeText(getApplicationContext(),"Post To Student",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.fileshare:
                        Toast.makeText(getApplicationContext(),"File Sharing",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.result:
                        Toast.makeText(getApplicationContext(),"Result with Grade",Toast.LENGTH_SHORT).show();
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
            super.onBackPressed();
    }
}