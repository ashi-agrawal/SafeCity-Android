package com.example.ashi.safecityandroid.Models;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by ashi on 11/7/16.
 */

public class Report implements Parcelable {
    private String incident_title = "";
    private Location incident_location;
    //private ___ location (use Google Maps API to find correct formatting)
    private Calendar date;
    //private ______ time (what are we using?)
    private String incident_description = "";
    private int[] incident_category; //TODO: use an array of bools?
    private boolean isComplete = false;
    /* Variable: isEmpty
      * -----------------
     * isEmpty tracks if the report consists of any information (excluding location). This alerts the app to auto-populate information in the second swiping tab (if there was already information entered and the user swiped to another tab in between).
     */
    private boolean isEmpty = true;

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

    public Report() {};

    public String getDescription() {
        return incident_description;
    }

    public void setLocation (Location locale) {
        this.incident_location = locale;
    }

    public void setDescription(String incident_description) {
        this.incident_description = incident_description;
        isEmpty = false;
    }

    public String getTitle() {
        return incident_title;
    }

    public void setTitle(String incident_title) {
        this.incident_title = incident_title;
        isEmpty = false;
    }

    public int[] getCategories() {
        return incident_category;
    }

    public void setCategories(int[] incident_category) {
        this.incident_category = incident_category;
        isEmpty = false;
    }

    public boolean checkIfEmpty(){ return isEmpty; }

    public boolean checkIfComplete() {
        if (isComplete) return isComplete;
        else {
            if (getTitle() != "" && getDescription () != "") isComplete = true;
            return isComplete;
        }
    }

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
