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
    JsonHttpResponseHandler handler = new JsonHttpResponseHandler();

    public void getReport() {
        String get = "incidents";
        //TODO: determine use cases for getting reports & write associated methods -> may need to push this to 2.0 since it may not be necessary for 1.0
    }

    public void postReport(Report report) {
        String post = "report";
        RequestParams params = new RequestParams();
        params.put("incident_title", report.getTitle());
        params.put("incident_description", report.getDescription());
        Location incident_location = report.getLocation();
        //TODO: params.put("location_name", ___________);
        params.put("longitude", incident_location.getLongitude());
        params.put("latitude", incident_location.getLatitude());
        Calendar incident_time = report.getTime();
        //TODO: params.put("incident_minute", _____________);
        params.put("incident_hour", incident_time.HOUR);
        params.put("incident_date", report.getDate());
        //TODO: params.put("incident_category", _____________);
        //TODO: params.put("incident_ampm", _____________);
        /*TODO:
        if (the name or the email is not empty...)
        params.put("person_first", ___________);
        params.put("person_last", _________);
        params.put("person_email", __________);
        */

        client.post(PUBLIC_BASE_URL + post, params, handler);
    }

}
