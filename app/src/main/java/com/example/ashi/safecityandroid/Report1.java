package com.example.ashi.safecityandroid;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Report1 extends AppCompatActivity {

    Button mToStep2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_report1);

        mToStep2 = (Button) findViewById(R.id.toStep2);

        View.OnClickListener toStep2Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Report1.this, Report2.class);
                startActivity(intent);
            }
        };

        mToStep2.setOnClickListener(toStep2Listener);
    }
}
