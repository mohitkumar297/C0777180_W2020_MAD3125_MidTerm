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

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTaxFilingDate() {
        return taxFilingDate;
    }

    public void setTaxFilingDate(String taxFilingDate) {
        this.taxFilingDate = taxFilingDate;
    }

    public float getFederalTax() {
        return federalTax;
    }

    public void setFederalTax(float federalTax) {
        this.federalTax = federalTax;
    }

    public float getProvincialTax() {
        return provincialTax;
    }

    public void setProvincialTax(float provincialTax) {
        this.provincialTax = provincialTax;
    }

    public float getCPP() {
        return CPP;
    }

    public void setCPP(float CPP) {
        this.CPP = CPP;
    }

    public float getEI() {
        return EI;
    }

    public void setEI(float EI) {
        this.EI = EI;
    }

    public float getCarryForwardRRSP() {
        return carryForwardRRSP;
    }

    public void setCarryForwardRRSP(float carryForwardRRSP) {
        this.carryForwardRRSP = carryForwardRRSP;
    }

    public float getTotalTaxableIncome() {
        return totalTaxableIncome;
    }

    public void setTotalTaxableIncome(float totalTaxableIncome) {
        this.totalTaxableIncome = totalTaxableIncome;
    }

    public float getTotalTaxPayed() {
        return totalTaxPayed;
    }

    public void setTotalTaxPayed(float totalTaxPayed) {
        this.totalTaxPayed = totalTaxPayed;
    }

    public static Creator<PersonInformation> getCREATOR() {
        return CREATOR;
    }

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
