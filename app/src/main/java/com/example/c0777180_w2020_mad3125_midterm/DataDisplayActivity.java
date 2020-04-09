package com.example.c0777180_w2020_mad3125_midterm;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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


    }
}
