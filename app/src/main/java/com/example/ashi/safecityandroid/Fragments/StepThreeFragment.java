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

public class StepThreeFragment extends Fragment {

    public static StepThreeFragment newInstance (Report currentReport){
        StepThreeFragment frag = new StepThreeFragment();
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
        //TODO: autopopulate this fragment with information to confirm
        //TODO: include an optional EditText for name & email
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stepthree, parent, false);
        return v;
    }
}
