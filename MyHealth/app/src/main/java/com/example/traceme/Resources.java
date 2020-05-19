package com.example.traceme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Resources extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);
        View background = findViewById(R.id.resources_background);
        background.setBackgroundResource(R.drawable.background);
        background.getBackground().setAlpha(128);

        /**
         * Use an ArrayAdapter to display the list of resources in a spinner
         */

        Spinner spinner = findViewById(R.id.resources_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.resources_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    /**
     * This method is called when an item is selected from the Spinner. It loads a web page depending
     * on the selection in the Spinner.
     * @param parent Adapter
     * @param view Spinner view
     * @param position unused parameter
     * @param id unused parameter
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        WebView webview = findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        String choice = parent.getSelectedItem().toString();
        String[] choiceArray = getResources().getStringArray(R.array.resources_array);
        if (choice.equals(choiceArray[0])){
            webview.loadUrl("https://www.cdc.gov/coronavirus/2019-ncov/symptoms-testing/symptoms.html");
        }else if(choice.equals(choiceArray[1])){
            webview.loadUrl("https://www.cdc.gov/coronavirus/2019-ncov/prevent-getting-sick/prevention.html");
        }else if(choice.equals(choiceArray[2])){
            webview.loadUrl("https://www.cdc.gov/coronavirus/2019-ncov/if-you-are-sick/steps-when-sick.html");
        }else if(choice.equals(choiceArray[3])){
            webview.loadUrl("https://www.cdc.gov/coronavirus/2019-ncov/faq.html");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /**
     * Finish the activity to return to MainActivity
     * @param v "submit" Button view that runs this method onclick
     */
    public void goBack(View v){
        finish();
    }

}
