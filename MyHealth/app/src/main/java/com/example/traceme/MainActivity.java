package com.example.traceme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        View background = findViewById(R.id.main_background);
        background.setBackgroundResource(R.drawable.background);
        background.getBackground().setAlpha(255);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * Creates an explicit intent to start the NewHealth activity
     * @param v "newHealth" Button view that runs this method onclick
     */
    public void gotoNewHealth(View v){
        Intent gotoActivity= new Intent();
        gotoActivity.setClass(this, NewHealth.class);
        startActivity(gotoActivity);
    }
    /**
     * Creates an explicit intent to start the OldHealth activity
     * @param v "oldHealth" Button view that runs this method onclick
     */
    public void gotoOldHealth(View v){
        Intent gotoActivity= new Intent();
        gotoActivity.setClass(this, OldHealth.class);
        startActivity(gotoActivity);
    }

    /**
     * Creates an explicit intent to start the Resources activity
     * @param v "resources" Button view that runs this method onclick
     */
    public void gotoResources(View v){
        Intent gotoActivity= new Intent();
        gotoActivity.setClass(this, Resources.class);
        startActivity(gotoActivity);
    }

    /**
     * Creates an explicit intent to start the Hekp activity
     * @param v "resources" Button view that runs this method onclick
     */
    public void gotoHelp(View v){
        Intent gotoActivity= new Intent();
        gotoActivity.setClass(this, Help.class);
        startActivity(gotoActivity);
    }

}
