package com.example.ashi.safecityandroid.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;

/**
 * Created by ashi on 11/7/16.
 */

public class Report implements Parcelable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;
    private String name;
    //private ___ location (use Google Maps API to find correct formatting)
    //private Calendar date; this is hard to do because calendar sux but we will figure it out
    private String description;
    private int number;
    private String email;
    //could use boolean to store each of categories or think of something else

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(title);
        out.writeString(name);
        out.writeString(description);
        out.writeInt(number);
        out.writeString(email);
    }

    private Report(Parcel in) {
        title = in.readString();
        name = in.readString();
        description = in.readString();
        number = in.readInt();
        email = in.readString();
    }

    public Report() {}

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Report> CREATOR
            = new Parcelable.Creator<Report>() {

        public Report createFromParcel(Parcel in) {
            return new Report(in);
        }

        @Override
        public Report[] newArray(int size) {
            return new Report[size];
        }
    };


}
