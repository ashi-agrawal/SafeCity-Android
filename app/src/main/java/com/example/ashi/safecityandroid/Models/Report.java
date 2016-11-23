package com.example.ashi.safecityandroid.Models;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by ashi on 11/7/16.
 */

/* Class: Report
 * -------------------
 * The Report class is a model to store and to pass information related to a particular report. At
 * current, the class stores all variables relevant to interface with the API (exempting the
 * optional variables /*TODO: include optional variables as well*/ /*as well as flags to aid in
 * usage of the model.
 */
public class Report implements Parcelable {
    private String incident_title = "";
    private Location incident_location;
    private Calendar incident_date;
    private String incident_description = "";
    private int[] incident_category;
    private String name = "";
    private String email = "";
    private boolean isComplete = false;
    //TODO: when isComplete is false, the Submit button should be greyed out; it should regain color
    //TODO: when isComplete becomes true
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
        //TODO: finish with the other private variables
    }

    private Report(Parcel in) {
        incident_title = in.readString();
        incident_description = in.readString();
        in.readIntArray(incident_category);
        //TODO: finish with the other private variables
    }

    public Report() {};

    public Location getLocation() { return incident_location; }

    public void setLocation (Location locale) {
        this.incident_location = locale;
    }

    public Calendar getTime() { return incident_date; }

    public String getDate() {
        int month = incident_date.MONTH;
        String string_month = Integer.toString(month);
        if (month < 10) string_month = "0" + string_month;
        int date = incident_date.DATE;
        String string_day = Integer.toString(date);
        if (date < 10) string_day = "0" + string_day;
        String year = Integer.toString(incident_date.YEAR);
        return string_month + "/" + string_day + "/" + year;
    }

    public void setTime (Calendar date) {
        this.incident_date = date;
    }

    public String getDescription() {
        return incident_description;
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
            //TODO: edit to include the rest of the private variables
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
