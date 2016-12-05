package com.example.ashi.safecityandroid.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ashi.safecityandroid.Models.Report;
import com.example.ashi.safecityandroid.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ashi on 11/7/16.
 */

public class StepTwoFragment extends Fragment {
    @BindView(R.id.etTitle) EditText etTitle;
    @BindView(R.id.etDescription) EditText etDescription;
    @BindView(R.id.etAM) EditText etAM;
    @BindView(R.id.etDay) EditText etDay;
    @BindView(R.id.etMonth) EditText etMonth;
    @BindView(R.id.etYear) EditText etYear;
    @BindView(R.id.etHour) EditText etHour;
    @BindView(R.id.etMinute) EditText etMinute;
    @BindView(R.id.catcalls) CheckBox cbCatcalls;
    @BindView(R.id.ogling) CheckBox cbOgling;
    @BindView(R.id.takingPics) CheckBox cbTakingPics;
    @BindView(R.id.indecent) CheckBox cbIndecent;
    @BindView(R.id.lighting) CheckBox cbLighting;
    @BindView(R.id.chain) CheckBox cbChain;
    @BindView(R.id.LGBT) CheckBox cbLGBT;
    @BindView(R.id.commenting) CheckBox cbCommenting;
    @BindView(R.id.stalking) CheckBox cbStalking;
    @BindView(R.id.touching) CheckBox cbTouching;
    @BindView(R.id.invites) CheckBox cbInvites;
    @BindView(R.id.rape) CheckBox cbRape;
    @BindView(R.id.ethnicity) CheckBox cbEthnicity;
    @BindView(R.id.other) CheckBox cbOther;
    Report current;
    private Unbinder unbinder;

    public static StepTwoFragment newInstance (Report currentReport){
        StepTwoFragment frag = new StepTwoFragment();
        Bundle args = new Bundle();
        args.putParcelable("report", currentReport);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        current = getArguments().getParcelable("report");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_steptwo, parent, false);
        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        current.setTitle(etTitle.getText().toString());
        current.setDescription(etDescription.getText().toString());
        Calendar time = Calendar.getInstance();
        String year = etYear.getText().toString();
        String month = etMonth.getText().toString();
        String date = etDay.getText().toString();
        String hour = etHour.getText().toString();
        String minutes = etMinute.getText().toString();
        String AM = etAM.getText().toString();
        if (!year.equals("") && !month.equals("") && !date.equals("") && !hour.equals("") && !minutes.equals("") && !AM.equals("")) {
            int hour_of_day = Integer.parseInt(hour);
            if (AM.toLowerCase().equals("pm")) hour_of_day += 12;
            time.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(date), hour_of_day, Integer.parseInt(minutes));
        } else {
            if (year.equals("") || month.equals("") || date.equals("") || hour.equals("") || minutes.equals("") || AM.equals("")){
                Toast.makeText(getContext(), "Make sure to fill out all fields of the date and time!", Toast.LENGTH_SHORT).show();
            }
        }
        current.setTime(time);
        String categories = " ";
        if (cbCatcalls.isChecked()) categories = "1 " + categories;
        if (cbCommenting.isChecked()) categories = "2 " + categories;
        if (cbOgling.isChecked()) categories = "6 " + categories;
        if (cbStalking.isChecked()) categories = "20 " + categories;
        if (cbTakingPics.isChecked()) categories = "3 " + categories;
        if (cbTouching.isChecked()) categories = "8 " + categories;
        if (cbIndecent.isChecked()) categories = "9 " + categories;
        if (cbInvites.isChecked()) categories = "10 " + categories;
        if (cbRape.isChecked()) categories = "11 " + categories;
        if (cbLighting.isChecked()) categories = "18 " + categories;
        if (cbChain.isChecked()) categories = "17 " + categories;
        if (cbEthnicity.isChecked()) categories = "19 " + categories;
        if (cbOther.isChecked()) categories = "15 " + categories;
        categories.replace(" ", ",");
        categories = categories.substring(0, categories.length() - 1);
        current.setCategories(categories);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
