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

    public String getSin() {
        return sin;
    }

    public void setSin(String sin) {
        this.sin = sin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(float grossIncome) {
        this.grossIncome = grossIncome;
    }

    public float getRRSPContributed() {
        return RRSPContributed;
    }

    public void setRRSPContributed(float RRSPContributed) {
        this.RRSPContributed = RRSPContributed;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getTaxFilingDate() {
        return taxFilingDate;
    }

    public float getFederalTax() {
        return federalTax;
    }

    public float getProvincialTax() {
        return provincialTax;
    }

    public float getCPP() {
        return CPP;
    }

    public float getEI() {
        return EI;
    }

    public float getCarryForwardRRSP() {
        return carryForwardRRSP;
    }

    public float getTotalTaxableIncome() {
        return totalTaxableIncome;
    }

    public float getTotalTaxPayed() {
        return totalTaxPayed;
    }

    public PersonInformation(String sin, String firstName, String lastName, String dateOfBirth, String gender, float grossIncome, float RRSPContributed) {
        this.sin = sin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.grossIncome = grossIncome;
        this.RRSPContributed = RRSPContributed;
    }

    protected PersonInformation(Parcel in) {
        sin = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        dateOfBirth = in.readString();
        gender = in.readString();
        grossIncome = in.readFloat();
        RRSPContributed = in.readFloat();
        fullName = in.readString();
        age = in.readInt();
        taxFilingDate = in.readString();
        federalTax = in.readFloat();
        provincialTax = in.readFloat();
        CPP = in.readFloat();
        EI = in.readFloat();
        carryForwardRRSP = in.readFloat();
        totalTaxableIncome = in.readFloat();
        totalTaxPayed = in.readFloat();
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
        dest.writeString(sin);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(dateOfBirth);
        dest.writeString(gender);
        dest.writeFloat(grossIncome);
        dest.writeFloat(RRSPContributed);
        dest.writeString(fullName);
        dest.writeInt(age);
        dest.writeString(taxFilingDate);
        dest.writeFloat(federalTax);
        dest.writeFloat(provincialTax);
        dest.writeFloat(CPP);
        dest.writeFloat(EI);
        dest.writeFloat(carryForwardRRSP);
        dest.writeFloat(totalTaxableIncome);
        dest.writeFloat(totalTaxPayed);
    }
}
