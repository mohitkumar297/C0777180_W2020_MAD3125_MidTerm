package com.example.c0777180_w2020_mad3125_midterm;

import android.content.Intent;
import android.graphics.Color;
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
    @InjectView(R.id.carryforward)
    TextView carryforward;
    @InjectView(R.id.taxableincome)
    TextView taxableincome;
    @InjectView(R.id.federaltax)
    TextView federaltax;
    @InjectView(R.id.provincialtax)
    TextView provincialtax;
    @InjectView(R.id.totaltaxpayed)
    TextView totaltaxpayed;
    @InjectView(R.id.maxrrsp)
    TextView maxrrsp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);
        ButterKnife.inject(this);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        String today = sdf.format(new Date());

        Intent i = getIntent();
        CRACustomer personInformation = i.getParcelableExtra("DATA");

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
        double l = personInformation.getCarryForwardRRSP();
        double m = personInformation.getTotalTaxableIncome();
        double n = personInformation.getFederalTax();
        double o = personInformation.getProvincialTax();
        double p = personInformation.getTotalTaxPayed();
        double q = personInformation.getMaxRRSP();


        SIN.setText(a);
        fullname.setText(b);
        gender.setText(c);
        dob.setText(e);
        taxdate.setText(today);
        grossincome.setText("$ " + String.format("%.2f", f));
        rrspcontributed.setText("$ " + String.format("%.2f", g));
        age.setText("" + d);
        ccpcontribution.setText("$ " + String.format("%.2f", j));
        employmentinsurance.setText("$ " + String.format("%.2f", k));
        if (l > 0) {
            carryforward.setText("$ " + String.format("%.2f", l));
        } else {
            carryforward.setText("$ " + String.format("%.2f", l));
            carryforward.setTextColor(Color.RED);
        }
        taxableincome.setText("$ " + String.format("%.2f", m));
        federaltax.setText("$ " + String.format("%.2f", n));
        provincialtax.setText("$ " + String.format("%.2f", o));
        totaltaxpayed.setText("$ " + String.format("%.2f", p));
        maxrrsp.setText("$ "+String.format("%.2f", q));
    }
}
