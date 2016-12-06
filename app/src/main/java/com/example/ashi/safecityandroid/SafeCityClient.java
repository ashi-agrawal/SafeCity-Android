package com.example.ashi.safecityandroid;

import android.preference.PreferenceActivity;
import android.util.Log;

import com.example.ashi.safecityandroid.Models.Report;
import com.google.android.gms.location.places.Place;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Calendar;

import cz.msebera.android.httpclient.Header;

/**
 * Created by ashi on 11/21/16.
 */

public class SafeCityClient {
    public static final String PUBLIC_BASE_URL = "http://maps.safecity.in/api?task=";
    AsyncHttpClient client = new AsyncHttpClient();

    public void getReport() {
        String get = "incidents";
        //TODO: determine use cases for getting reports & write associated methods -> may need to push this to 2.0 since it may not be necessary for 1.0
    }

    public void postReport(Report report) {
        String post = "report";
        RequestParams params = new RequestParams();
        params.put("incident_title", report.getTitle());
        params.put("incident_description", report.getDescription());
        Place incident_location = report.getLocation();
        params.put("location_name", incident_location.getName());
        params.put("longitude", incident_location.getLatLng().longitude);
        params.put("latitude", incident_location.getLatLng().latitude);
        Calendar incident_time = report.getTime();
        params.put("incident_minute", incident_time.MINUTE);
        params.put("incident_hour", incident_time.HOUR);
        params.put("incident_date", report.getDate());
        params.put("incident_category", report.getCategories());
        params.put("incident_ampm", report.getAMPM());
        params.put("task", "report");
        if (report.getName() != "") {
            String fullName = report.getName();
            String[] firstLast = fullName.split(" ");
            params.put("person_first", firstLast[0]);
            params.put("person_last", firstLast[1]);
        }
        if (report.getEmail() != "") {
            params.put("person_email", report.getEmail());
        }
        Log.d("what", "is going onnnnn");
        client.post(PUBLIC_BASE_URL + post, params, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d("success", response.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d("help", errorResponse.toString());
            }
        });
    }

}
