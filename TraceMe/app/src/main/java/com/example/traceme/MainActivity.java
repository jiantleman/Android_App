package com.example.traceme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoNewHealth(View v){
        Intent gotoActivity= new Intent();
        gotoActivity.setClass(this, NewHealth.class);
        startActivity(gotoActivity);
    }

    public void gotoOldHealth(View v){
        Intent gotoActivity= new Intent();
        gotoActivity.setClass(this, OldHealth.class);
        startActivity(gotoActivity);
    }

}
