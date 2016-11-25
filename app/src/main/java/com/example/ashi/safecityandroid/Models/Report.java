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
 * optional variables as well as flags to aid in usage of the model.
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
        out.writeValue(incident_date);
        out.writeValue(incident_location);
        out.writeString(name);
        out.writeString(email);
    }

    private Report(Parcel in) {
        incident_title = in.readString();
        incident_description = in.readString();
        in.readIntArray(incident_category);
        incident_date = in.readParcelable(incident_date.getClass().getClassLoader());
        incident_location = in.readParcelable(incident_location.getClass().getClassLoader());
        name = in.readString();
        email = in.readString();
    }

    public Report() {};

    public Location getLocation() { return incident_location; }

    public void setLocation (Location locale) {
        this.incident_location = locale;
    }

    public Calendar getTime() { return incident_date; }

    public String getDate() {
        int month = incident_date.get(Calendar.MONTH) + 1; //months are 0-indexed
        String string_month = Integer.toString(month);
        if (month < 10) string_month = "0" + string_month;
        int date = incident_date.get(Calendar.DATE);
        String string_day = Integer.toString(date);
        if (date < 10) string_day = "0" + string_day;
        String year = Integer.toString(incident_date.get(Calendar.YEAR));
        return string_month + "/" + string_day + "/" + year;
    }

    public String getAMPM() {
        int am_pm = incident_date.get(Calendar.AM_PM);
        if (am_pm == Calendar.AM) {
            return "am";
        } else {
            return "pm";
        }
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

    public String getCategories() {
        return incident_category.toString().replace("[", "").replace("]", "").replace(" ", "");
    }

    public void setCategories(int[] incident_category) {
        this.incident_category = incident_category;
        isEmpty = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean checkIfEmpty(){ return isEmpty; }

    public boolean checkIfComplete() {
        if (isComplete) return isComplete;
        else {
            if (getTitle() != "" && getDescription () != "" && getDate() != "" && getCategories() != "" && getLocation() != null) isComplete = true;
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
