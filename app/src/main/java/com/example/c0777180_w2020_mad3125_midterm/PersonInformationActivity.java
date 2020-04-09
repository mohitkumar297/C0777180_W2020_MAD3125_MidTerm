package com.example.c0777180_w2020_mad3125_midterm;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class PersonInformationActivity extends AppCompatActivity {

    PersonInformation personInformation;

    @InjectView(R.id.txtSIN)
    EditText txtSIN;
    @InjectView(R.id.txtFirstName)
    TextInputEditText txtFirstName;
    @InjectView(R.id.txtLastName)
    TextInputEditText txtLastName;
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

    private RadioButton radio1;

    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
    int age = 0;

    DatePickerDialog datePickerDialog;
    @InjectView(R.id.txtTaxFilingDate)
    TextView txtTaxFilingDate;
    @InjectView(R.id.txtDOB)
    EditText txtDOB;
    @InjectView(R.id.btnSubmit)
    Button btnSubmit;
    @InjectView(R.id.btnClear)
    Button btnClear;
    @InjectView(R.id.inputLayoutSIN)
    TextInputLayout inputLayoutSIN;
    @InjectView(R.id.inputLayoutDOB)
    TextInputLayout inputLayoutDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_information);
        ButterKnife.inject(this);

        int selectedRadio = radio.getCheckedRadioButtonId();
        radio1 = (RadioButton) findViewById(selectedRadio);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        String today = sdf.format(new Date());
        txtTaxFilingDate.setText(today);

        txtDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(PersonInformationActivity.this, datePickerListener, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                datePickerDialog.show();
            }
        });

//        txtDOB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calendar = Calendar.getInstance();
//                year= calendar.get(Calendar.YEAR);
//                month = calendar.get(Calendar.MONTH);
//                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
//                datePickerDialog = new DatePickerDialog(PersonInformationActivity.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        txtDOB.setText(dayOfMonth + "-" + month + "-" + year);
//                    }
//
//                }, year,month,dayOfMonth );
//                datePickerDialog.show();
//            }
//        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateSIN()){
                    String dob = txtDOB.getText().toString();
                    Double gi=Double.parseDouble(txtGrossIncome.getText().toString());
                    Double rc=Double.parseDouble(txtRRSPContributed.getText().toString());
                    personInformation = new PersonInformation(txtSIN.getText().toString(),txtFirstName.getText().toString(),txtLastName.getText().toString(),dob,radio1.getText().toString(),gi,rc,age);

                    Intent intent = new Intent(PersonInformationActivity.this,DataDisplayActivity.class);
                    intent.putExtra("DATA",personInformation);
                    startActivity(intent);
                }
            }
        });
    }



    public int calculateAge(long date) {
        Calendar dob = Calendar.getInstance();
        dob.setTimeInMillis(date);

        Calendar today = Calendar.getInstance();

        age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        return age;

    }

     DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            String format = new SimpleDateFormat("dd-MM-YYYY").format(c.getTime());
            if (calculateAge(c.getTimeInMillis())<18){
                inputLayoutDOB.setError("NOT ELIGIBLE");
            }
            else{
                txtDOB.setText(format);
                inputLayoutDOB.setError(null);
                inputLayoutDOB.setErrorEnabled(false);}
            //FOR AGE DISPLAY txtTaxFilingDate.setText(Integer.toString(calculateAge(c.getTimeInMillis())));
        }


    };


    public boolean validateSIN() {
        if (txtSIN.length() != 9) {
            inputLayoutSIN.setError("INVALID SIN");
            return false;
        } else {
            inputLayoutSIN.setError(null);
            return true;
        }
    }


    public void maleClick(View view) {
        radioMale.setTextColor(Color.GREEN);
        radioFemale.setTextColor(Color.BLACK);
        radioOther.setTextColor(Color.BLACK);
    }
    public void femaleClick(View view) {
        radioFemale.setTextColor(Color.GREEN);
        radioMale.setTextColor(Color.BLACK);
        radioOther.setTextColor(Color.BLACK);
    }
    public void other(View view) {
        radioMale.setTextColor(Color.BLACK);
        radioFemale.setTextColor(Color.BLACK);
        radioOther.setTextColor(Color.GREEN);
    }
}
