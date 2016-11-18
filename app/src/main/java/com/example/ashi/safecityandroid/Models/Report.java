package com.example.ashi.safecityandroid.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by ashi on 11/7/16.
 */

public class Report implements Parcelable {

    public String getDescription() {
        return incident_description;
    }

    public void setDescription(String incident_description) {
        this.incident_description = incident_description;
    }

    /*
    public String getDate(String incident_date) {
        return incident_date;
    }
    */

    public String getTitle() {
        return incident_title;
    }

    public void setTitle(String incident_title) {
        this.incident_title = incident_title;
    }

    public int[] getCategories() {
        return incident_category;
    }

    public void setCategories(int[] incident_category) {
        this.incident_category = incident_category;
    }

    private String incident_title;
    //private ___ location (use Google Maps API to find correct formatting)
    //private Calendar date; this is hard to do because calendar sux but we will figure it out
    private String incident_description;
    private int[] incident_category;
    //could use boolean to store each of categories or think of something else
    //private ArrayList<Integer> categories;

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(incident_title);
        out.writeString(incident_description);
        out.writeIntArray(incident_category);
    }

    private Report(Parcel in) {
        incident_title = in.readString();
        incident_description = in.readString();
        //create array
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
