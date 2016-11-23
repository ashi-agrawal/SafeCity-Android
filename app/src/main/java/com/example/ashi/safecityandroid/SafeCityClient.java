package com.example.ashi.safecityandroid;

import android.location.Location;
import android.preference.PreferenceActivity;
import android.util.Log;

import com.example.ashi.safecityandroid.Models.Report;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.Calendar;

import cz.msebera.android.httpclient.Header;

/**
 * Created by ashi on 11/21/16.
 */

public class SafeCityClient {
    public static final String PUBLIC_BASE_URL = "http://maps.safecity.in/api?task=";
    AsyncHttpClient client = new AsyncHttpClient();
    JsonHttpResponseHandler handler;

    public void getReport() {
        String get = "incidents";
        //TODO: determine use cases for getting reports & write associated methods
    }

    public void postReport(Report report) {
        String post = "report";
        RequestParams params = new RequestParams();
        params.put("incident_title", report.getTitle());
        params.put("incident_description", report.getDescription());
        Location incident_location = report.getLocation();
        params.put("longitude", incident_location.getLongitude());
        params.put("latitude", incident_location.getLatitude());
        Calendar incident_time = report.getTime();
        handler = new JsonHttpResponseHandler();

        /*
        CATEGORIES: map location (coords & name), time/date, category
        OPTIONAL: name, email
        location_name
        incident_minute
        incident_hour
        incident_date
        incident_category
        incident_ampm
        OPTIONAL
        person_first
        person_last
        person_email
         */

        client.post(PUBLIC_BASE_URL + post, params, handler);
    }

}
