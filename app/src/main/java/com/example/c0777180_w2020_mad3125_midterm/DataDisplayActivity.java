package com.example.c0777180_w2020_mad3125_midterm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DataDisplayActivity extends AppCompatActivity {

    @InjectView(R.id.SIN)
    TextView SIN;
    @InjectView(R.id.age)
    TextView age;
    @InjectView(R.id.fullname)
    TextView fullname;
    @InjectView(R.id.gender)
    TextView gender;
    @InjectView(R.id.taxdate)
    TextView taxdate;
    @InjectView(R.id.grossincome)
    TextView grossincome;
    @InjectView(R.id.rrspcontributed)
    TextView rrspcontributed;
    @InjectView(R.id.dob)
    TextView dob;
    @InjectView(R.id.ccpcontribution)
    TextView ccpcontribution;
    @InjectView(R.id.employmentinsurance)
    TextView employmentinsurance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);
        ButterKnife.inject(this);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        String today = sdf.format(new Date());

        Intent i = getIntent();
        PersonInformation personInformation = i.getParcelableExtra("DATA");

        String a = personInformation.getSin();
        String b = personInformation.getFullName();
        String c = personInformation.getGender();
        int d = personInformation.getAge();
        String e = personInformation.getDateOfBirth();
        double f = personInformation.getGrossIncome();
        double g = personInformation.getRRSPContributed();
        String h = personInformation.getTaxFilingDate();
        double j = personInformation.getCPP();
        double k = personInformation.getEI();


        SIN.setText(a);
        fullname.setText(b);
        gender.setText(c);
        dob.setText(e);
        taxdate.setText(today);
        grossincome.setText("$ "+f);
        rrspcontributed.setText(("$ " + g));
        age.setText("" + d);
        ccpcontribution.setText("$ " + j);
        employmentinsurance.setText("$ "+k);

    }
}
