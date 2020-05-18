package com.example.traceme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class NewHealth extends AppCompatActivity {

    private SQLiteDatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_health);

        final EditText editTime = findViewById(R.id.editText_time);
        editTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minutes = calendar.get(Calendar.MINUTE);
                TimePickerDialog picker = new TimePickerDialog(NewHealth.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                editTime.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                picker.show();
            }
        });

        final EditText editDate = findViewById(R.id.editText_date);
        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog picker = new DatePickerDialog(NewHealth.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                editDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        final RadioGroup wellness = findViewById(R.id.radioGroup_wellness);
        final TableLayout signs = findViewById(R.id.tableLayout_signs);
        final TextView signs_text = findViewById(R.id.textView_signs);
        signs.setVisibility(View.GONE);
        signs_text.setVisibility(View.GONE);
        wellness.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioButton_well) {
                    signs.setVisibility(View.GONE);
                    signs_text.setVisibility(View.GONE);
                }else if(checkedId==R.id.radioButton_unwell){
                    signs.setVisibility(View.VISIBLE);
                    signs_text.setVisibility(View.VISIBLE);
                }
            }
        });

        db = new SQLiteDatabaseHandler(this);

        Button submitButton = findViewById(R.id.button_submit);
        final EditText editTemp = findViewById(R.id.editText_temp);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editDate.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please fill up required fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(editTime.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please fill up required fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(editTemp.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please fill up required fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(wellness.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(),"Please fill up required fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                Record record = new Record();
                record.setDate(editDate.getText().toString());
                record.setTime(editTime.getText().toString());
                record.setTemperature((Float.parseFloat(editTemp.getText().toString())));

                if(wellness.getCheckedRadioButtonId()==R.id.radioButton_well) {
                    record.setWellness(1);
                }else if(wellness.getCheckedRadioButtonId()==R.id.radioButton_unwell){
                    record.setWellness(0);
                }

                String signs = new String();

                if(((CheckBox) findViewById(R.id.checkBox_fever)).isChecked())
                    signs = signs + "Fever, ";
                if(((CheckBox) findViewById(R.id.checkBox_fatigue)).isChecked())
                    signs = signs + "Fatigue, ";
                if(((CheckBox) findViewById(R.id.checkBox_chills)).isChecked())
                    signs = signs + "Chills, ";
                if(((CheckBox) findViewById(R.id.checkBox_pain)).isChecked())
                    signs = signs + "Muscle Pain, ";
                if(((CheckBox) findViewById(R.id.checkBox_taste)).isChecked())
                    signs = signs + "Lost of Taste or Smell, ";
                if(((CheckBox) findViewById(R.id.checkBox_breath)).isChecked())
                    signs = signs + "Difficulty Breathing, ";
                if(((CheckBox) findViewById(R.id.checkBox_headache)).isChecked())
                    signs = signs + "Headache, ";
                if(((CheckBox) findViewById(R.id.checkBox_throat)).isChecked())
                    signs = signs + "Sore Throat, ";

                record.setSigns(signs);

                db.addRecord(record);

                Toast.makeText(getApplicationContext(),"Submitted!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });

    }
}
