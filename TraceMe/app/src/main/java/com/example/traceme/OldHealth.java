package com.example.traceme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class OldHealth extends AppCompatActivity {

    private SQLiteDatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_health);

        final EditText editDate = findViewById(R.id.editText_date);
        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog picker = new DatePickerDialog(OldHealth.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                editDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        db = new SQLiteDatabaseHandler(this);

        List<Record> records = db.allRecords();
        ArrayList<String> printouts = new ArrayList<>();

        for(int i = 0; i < records.size(); i++) {
            printouts.add(records.get(i).toString());
        }


        ArrayAdapter arrayAdapter =
                new ArrayAdapter(OldHealth.this, android.R.layout.simple_list_item_1, printouts);
        ListView listView = findViewById(R.id.listView_records);
        listView.setAdapter(arrayAdapter);

        Button searchButton = findViewById(R.id.button_search);
//        searchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(editDate.getText().toString().isEmpty()){
//                    Toast.makeText(getApplicationContext(),"Please select date", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                Record record = db.getRecord(editDate.getText().toString());
//                if (record.getDate() != null){
//                    Toast.makeText(getApplicationContext(),record.getDate(), Toast.LENGTH_SHORT).show();
//                } else{
//                    Toast.makeText(getApplicationContext(),"No record found", Toast.LENGTH_SHORT).show();
//                }



//        });


    }





}
