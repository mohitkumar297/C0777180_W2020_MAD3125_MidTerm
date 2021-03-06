package com.example.c0777180_w2020_mad3125_midterm;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PersonInformationActivity extends AppCompatActivity {

    CRACustomer personInformation;

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
    @InjectView(R.id.inputLayoutrrsp)
    TextInputLayout inputLayoutRRSP;

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
    String checkedBox = "";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_information);
        ButterKnife.inject(this);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        String today = sdf.format(new Date());
        txtTaxFilingDate.setText(today);


        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int checkedRadio = radio.getCheckedRadioButtonId();
                RadioButton checkedRadioButton = findViewById(checkedRadio);
                checkedBox = checkedRadioButton.getText().toString();
            }
        });

        inputLayoutRRSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputLayoutRRSP.setHelperText("Maximum Amount : "+(Double.valueOf(txtGrossIncome.getText().toString()))*0.18);
                inputLayoutRRSP.setHelperTextColor(ColorStateList.valueOf(Color.RED));
            }
        });

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


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateSIN()) {
                    String dob = txtDOB.getText().toString();
                    if (txtFirstName.getText().toString().length() == 0 || txtLastName.getText().toString().length() == 0 || dob.length() == 0 || txtGrossIncome.getText().toString().length() == 0 || txtRRSPContributed.getText().toString().length() == 0) {
                        Toast.makeText(PersonInformationActivity.this, "COMPLETE THE FORM", Toast.LENGTH_SHORT).show();
                    } else if (age < 18) {

                        btnSubmit.setTextColor(Color.RED);
                        showToast();
                    } else {
                        Double gi = Double.parseDouble(txtGrossIncome.getText().toString());
                        Double rc = Double.parseDouble(txtRRSPContributed.getText().toString());
                        personInformation = new CRACustomer(txtSIN.getText().toString(), txtFirstName.getText().toString(), txtLastName.getText().toString(), dob, checkedBox, gi, rc, age);
                        btnSubmit.setTextColor(Color.WHITE);
                        Intent intent = new Intent(PersonInformationActivity.this, DataDisplayActivity.class);
                        intent.putExtra("DATA", personInformation);
                        startActivity(intent);

                    }
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSIN.setText("");
                txtFirstName.setText("");
                txtLastName.setText("");
                txtDOB.setText("");
                txtGrossIncome.setText("");
                txtRRSPContributed.setText("");
                inputLayoutSIN.setError(null);
                inputLayoutDOB.setError(null);
            }
        });
    }


    public int calculateAge(long date) {
        Calendar dob = Calendar.getInstance();
        dob.setTimeInMillis(date);

        Calendar today = Calendar.getInstance();

        age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR) - 1;
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
            if (calculateAge(c.getTimeInMillis()) < 18) {
                txtDOB.setText(format);
                inputLayoutDOB.setError("NOT ELIGIBLE");
            } else {
                txtDOB.setText(format);
                inputLayoutDOB.setError(null);
                inputLayoutDOB.setErrorEnabled(false);
            }
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
        radioFemale.setTextColor(Color.WHITE);
        radioOther.setTextColor(Color.WHITE);
    }

    public void femaleClick(View view) {
        radioFemale.setTextColor(Color.GREEN);
        radioMale.setTextColor(Color.WHITE);
        radioOther.setTextColor(Color.WHITE);
    }

    public void other(View view) {
        radioMale.setTextColor(Color.WHITE);
        radioFemale.setTextColor(Color.WHITE);
        radioOther.setTextColor(Color.GREEN);
    }

    public void showToast() {
        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_root));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
