package com.example.bottombar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class About extends AppCompatActivity {
BottomNavigationView bottomNavigationView;

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_delete).setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        About.super.onBackPressed();

                    }
                }).setNegativeButton("No", null).show();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        bottomNavigationView=findViewById(R.id.bar);
        bottomNavigationView.setSelectedItemId(R.id.about);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {

                    case R.id.about:
                        return true;

                    case R.id.home:
                        Intent i=new Intent(getApplicationContext(),Home.class);
                        startActivity(i);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.dashboard:
                        Intent p=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(p);
                        overridePendingTransition(0,0);
                        return true;



                }
                return false;
            }
        });
    }
}
