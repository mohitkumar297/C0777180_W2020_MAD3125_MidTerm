package com.example.c0777180_w2020_mad3125_midterm;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_information);
        ButterKnife.inject(this);
    }
}
