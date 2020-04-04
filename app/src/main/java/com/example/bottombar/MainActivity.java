package com.example.bottombar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


        BottomNavigationView bottomNavigationView;

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_delete).setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                     MainActivity.super.onBackPressed();

                    }
                }).setNegativeButton("No", null).show();
        super.onBackPressed();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bar);
        bottomNavigationView.setSelectedItemId(R.id.dashboard);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {

                    case R.id.dashboard:
                      return true;
                    case R.id.home:
                        Intent i=new Intent(getApplicationContext(),Home.class);
                        startActivity(i);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.about:
                        Intent p=new Intent(getApplicationContext(),About.class);
                        startActivity(p);
                        overridePendingTransition(0,0);
                        return true;



                }
                return false;
            }
        });
    }
}
