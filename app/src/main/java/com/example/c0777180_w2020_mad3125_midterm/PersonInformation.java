package com.example.c0777180_w2020_mad3125_midterm;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonInformation implements Parcelable {
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
