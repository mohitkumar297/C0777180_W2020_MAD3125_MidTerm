package com.example.c0777180_w2020_mad3125_midterm;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PersonInformationActivity extends AppCompatActivity {

    @InjectView(R.id.txtSIN)
    TextInputEditText txtSIN;
    @InjectView(R.id.txtFirstName)
    TextInputEditText txtFirstName;
    @InjectView(R.id.txtLastName)
    TextInputEditText txtLastName;
    @InjectView(R.id.btnDOB)
    Button btnDOB;
    @InjectView(R.id.radioMale)
    RadioButton radioMale;
    @InjectView(R.id.radioFemale)
    RadioButton radioFemale;
    @InjectView(R.id.radioOther)
    RadioButton radioOther;
    @InjectView(R.id.radio)
    RadioGroup radio;
    @InjectView(R.id.txtGrossIncome)
    TextInputEditText txtGrossIncome;
    @InjectView(R.id.txtRRSPContributed)
    TextInputEditText txtRRSPContributed;

    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;

    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_information);
        ButterKnife.inject(this);

        btnDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                year= calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(PersonInformationActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        btnDOB.setText(dayOfMonth + "/" + month + "/" + year);
                    }

                }, year,month,dayOfMonth );
                datePickerDialog.show();
            }
        }) ;
    }
}
