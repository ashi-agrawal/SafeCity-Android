package com.example.ashi.safecityandroid.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ashi.safecityandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/* Class: HomeActivity
 * -------------------
 * SafeCity-Android automatically launches into this activity. HomeActivity is a screen with the
 * SafeCity logo and two buttons: a Report button to allow users to report an incident and a Map
 * button to allow users to view a hotspot map of incidents.
 * TODO: Include a button that links to statistics and change the Map Fragment to allow users to
 * TODO: set a beginning and an end destination.
 */
public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.report) Button report;
    @BindView(R.id.map) Button map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        //This block is used to link the Report button to launching the report flow.
        View.OnClickListener toReportListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ReportActivity.class);
                startActivity(intent);
            }
        };
        report.setOnClickListener(toReportListener);

        //This block is used to link the Map button to launching the map flow.
        View.OnClickListener toMapListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MapActivity.class);
                startActivity(intent);
            }
        };
        map.setOnClickListener(toMapListener);
    }
}
