package com.example.ashi.safecityandroid;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button mReport;
    private Button mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_home);

        mReport = (Button) findViewById(R.id.report);
        mMap = (Button) findViewById(R.id.map);

        View.OnClickListener toReportListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ReportWelcome.class);
                startActivity(intent);
            }
        };

        mReport.setOnClickListener(toReportListener);

        View.OnClickListener toMapListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MapMain.class);
                startActivity(intent);
            }
        };

        mMap.setOnClickListener(toMapListener);
    }
}
