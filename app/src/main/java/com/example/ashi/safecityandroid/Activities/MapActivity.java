package com.example.ashi.safecityandroid.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ashi.safecityandroid.R;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_map_main);
        //TODO: embed a MapFragment here
        //Tara, 11-26: Have embedded a static MapFragment by adding a fragment to activity_map_main.xml.
        //Will embed MapFragment dynamically once the static version is working.
    }
}
