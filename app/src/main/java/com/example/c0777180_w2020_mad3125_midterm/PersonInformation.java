package com.example.c0777180_w2020_mad3125_midterm;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonInformation implements Parcelable {
    private String sin;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private float grossIncome;
    private float RRSPContributed;
    private String fullName;
    private int age;
    private String taxFilingDate;
    private float federalTax;
    private float provincialTax;
    private float CPP;
    private float EI;
    private float carryForwardRRSP;
    private float totalTaxableIncome;
    private float totalTaxPayed;


    protected PersonInformation(Parcel in) {
    }

    public static final Creator<PersonInformation> CREATOR = new Creator<PersonInformation>() {
        @Override
        public PersonInformation createFromParcel(Parcel in) {
            return new PersonInformation(in);
        }

        @Override
        public PersonInformation[] newArray(int size) {
            return new PersonInformation[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
