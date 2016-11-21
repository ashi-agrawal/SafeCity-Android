package com.example.ashi.safecityandroid.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ashi.safecityandroid.Models.Report;
import com.example.ashi.safecityandroid.R;

/**
 * Created by ashi on 11/7/16.
 */

public class StepOneFragment extends Fragment {

    public static StepOneFragment newInstance (Report currentReport){
        StepOneFragment frag = new StepOneFragment();
        Bundle args = new Bundle();
        args.putParcelable("report", currentReport);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Report current = getArguments().getParcelable("report");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stepone, parent, false);
        return v;
    }
}
