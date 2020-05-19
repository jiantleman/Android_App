package com.example.traceme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OldHealth extends AppCompatActivity {

    private SQLiteDatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_health);
        View background = findViewById(R.id.oldHealth_background);
        background.setBackgroundResource(R.drawable.background);
        background.getBackground().setAlpha(128);

        /**
         * Get the list of Records from the SQL database
         */
        db = new SQLiteDatabaseHandler(this);
        List<Record> records = db.allRecords();
        ArrayList<String> printouts = new ArrayList<>();
        /**
         * Finish the activity and display a Toast if there is no existing records
         */
        if(records.size()==0){
            Toast.makeText(getApplicationContext(),"No existing records", Toast.LENGTH_SHORT).show();
            finish();
        }
        /**
         * For each Record, call the custom toString function to get a String displaying all the
         * health information, and add it to an ArrayList.
         */
        for(int i = 0; i < records.size(); i++) {
            printouts.add(records.get(i).toString());
        }
        /**
         * Use an ArrayAdapter to display the strings in a ListView
         */
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(OldHealth.this, android.R.layout.simple_list_item_1, printouts){
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);
                        TextView text = (TextView) view.findViewById(android.R.id.text1);
                        Typeface typeface = ResourcesCompat.getFont(OldHealth.this, R.font.open_sans_light);
                        text.setTypeface(typeface);
                        return view;
                    }
                };
        ListView listView = findViewById(R.id.listView_records);
        listView.setAdapter(arrayAdapter);


    }
    /**
     * Finish the activity to return to MainActivity
     * @param v "submit" Button view that runs this method onclick
     */
    public void goBack(View v){
        finish();
    }

    /**
     * Deletes all the records from the SQL database and finishes the activity to return to
     * MainActivity
     * @param v "clear" Button view that runs this method onclick
     */
    public void deleteData(View v){
        db = new SQLiteDatabaseHandler(this);
        List<Record> records = db.allRecords();
        for(int i = 0; i < records.size(); i++) {
            db.deleteOne(records.get(i));
        }
        Toast.makeText(getApplicationContext(),"Records deleted", Toast.LENGTH_SHORT).show();
        finish();
    }

}
