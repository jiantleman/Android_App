package com.example.traceme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        View background = findViewById(R.id.help_background);
        background.setBackgroundResource(R.drawable.background);
        background.getBackground().setAlpha(128);
    }

    /**
     * Dials number
     * @param v "moh" TextView that runs this method onclick
     */
    public void callMoh(View v) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:18003339999"));
        startActivity(callIntent);

    }
    /**
     * Dials number
     * @param v "care" TextView that runs this method onclick
     */
    public void callCare(View v){
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:180062026868"));
        startActivity(callIntent);
    }
    /**
     * Dials number
     * @param v "shn" TextView that runs this method onclick
     */
    public void callShn(View v){
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:68125555"));
        startActivity(callIntent);
    }
    /**
     * Finish the activity to return to MainActivity
     * @param v "back" Button view that runs this method onclick
     */
    public void goBack(View v){
        finish();
    }
}
