package com.example.ashi.safecityandroid.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.example.ashi.safecityandroid.Models.Report;
import com.example.ashi.safecityandroid.R;
import com.example.ashi.safecityandroid.SafeCityClient;
import com.example.ashi.safecityandroid.SmartFragmentStatePagerAdapter;
import com.example.ashi.safecityandroid.Fragments.StepOneFragment;
import com.example.ashi.safecityandroid.Fragments.StepThreeFragment;
import com.example.ashi.safecityandroid.Fragments.StepTwoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ashi on 10/21/16.
 */

/* Class: ReportActivity
 * -------------------
 * This activity allows a user to create and submit a report to the SafeCity backend. The Report
 * activity is styled using the StateFragmentStatePagerAdapter which allows users to swipe in
 * between fragments.
 */
public class ReportActivity extends AppCompatActivity{
    Report currentReport = new Report();
    StepsPagerAdapter adapterViewPager;
    SafeCityClient client = new SafeCityClient();
    @BindView(R.id.viewpager) ViewPager vpPager;
    @BindView(R.id.btnsubmit) Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_report);
        ButterKnife.bind(this);
        adapterViewPager = new StepsPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabStrip.setViewPager(vpPager);

        //This block is used to link the Submit button to either submit the report or show an error.
        View.OnClickListener submitReportListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentReport.checkIfComplete()) {
                    client.postReport(currentReport);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), R.string.incomplete_report_toast, Toast.LENGTH_LONG).show();
                }
            }
        };
        submit.setOnClickListener(submitReportListener);
    }

    public class StepsPagerAdapter extends SmartFragmentStatePagerAdapter {
        private String tabTitles[] = {"Step One", "Step Two", "Step Three"};

        public StepsPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case (0):
                    return StepOneFragment.newInstance(currentReport);
                case (1):
                    return StepTwoFragment.newInstance(currentReport);
                case (2):
                    return StepThreeFragment.newInstance(currentReport);
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }
    }
}
