package com.example.thomas.letsgo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class Events extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener{

     EditText Title,Description;

   // private Button Send;
    Button Pick;
     TextView Result;
    int day,month,year,hour,minuter;
    int dayFinal,monthFinal,yearFinal,hourFinal,minuterFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        // initialisation
        Title= findViewById(R.id.title);
        Description= findViewById(R.id.description);
       // Send= findViewById(R.id.send);
        Result= findViewById(R.id.result);
        Pick= findViewById(R.id.time);
        Pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Calendar c= Calendar.getInstance();
                year=c.get(Calendar.YEAR);
                month=c.get(Calendar.MONTH);
                day=c.get(Calendar.DAY_OF_MONTH);
                hour=c.get(Calendar.HOUR);
                minuter=c.get(Calendar.MINUTE);

                DatePickerDialog datePickerDialog =new DatePickerDialog(Events.this,Events.this,year,month,day);
                datePickerDialog.show();

            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
       yearFinal=i;
        monthFinal=i1+1;
       dayFinal=i2;
       Calendar c=Calendar.getInstance();
        hour= c.get(Calendar.HOUR_OF_DAY);
           minuter=c.get(Calendar.MINUTE);
           TimePickerDialog timePickerDialog= new TimePickerDialog(Events.this,Events.this,hour,minuter, android.text.format.DateFormat.is24HourFormat(this));
           timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        hourFinal=i;
        minuterFinal=i1;

        Result.setText("your event is on"+ " " + dayFinal + "th / "  + monthFinal +" / " +yearFinal +" at" +" " + hourFinal +" :" + minuterFinal);
    }
}
