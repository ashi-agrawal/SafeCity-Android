package com.example.ashi.safecityandroid;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReportWelcome extends AppCompatActivity {

    Button mStartReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_report_welcome);

        mStartReport = (Button) findViewById(R.id.startReport);

        View.OnClickListener toStep1Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportWelcome.this, Report1.class);
                startActivity(intent);
            }
        };

        mStartReport.setOnClickListener(toStep1Listener);
    }
}
