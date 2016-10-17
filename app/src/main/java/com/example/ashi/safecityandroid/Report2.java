package com.example.ashi.safecityandroid;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Report2 extends AppCompatActivity {

    Button mToStep3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_report2);

        mToStep3 = (Button) findViewById(R.id.toStep3);

        View.OnClickListener toStep3Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Report2.this, Report3.class);
                startActivity(intent);
            }
        };

        mToStep3.setOnClickListener(toStep3Listener);
    }
}
