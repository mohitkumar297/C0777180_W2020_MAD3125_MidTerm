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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);
        ButterKnife.inject(this);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        String today = sdf.format(new Date());
        taxdate.setText(today);
        Intent i = getIntent();
        PersonInformation personInformation = i.getParcelableExtra("DATA");

        String a = personInformation.getSin();
        String b = personInformation.getFullName();
        String c = personInformation.getGender();
        int d = personInformation.getAge();
        String e = personInformation.getDateOfBirth();
        float f = personInformation.getGrossIncome();
        float g = personInformation.getRRSPContributed();

        SIN.setText(a);
        fullname.setText(b);
        gender.setText(c);
        taxdate.setText(e);
        grossincome.setText(String.valueOf("$ "+ f));
        rrspcontributed.setText("$ "+ g);

    }
}
