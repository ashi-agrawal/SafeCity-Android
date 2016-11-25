package com.example.ashi.safecityandroid.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.ashi.safecityandroid.Models.Report;
import com.example.ashi.safecityandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ashi on 11/7/16.
 */

public class StepTwoFragment extends Fragment {
    @BindView(R.id.etTitle) EditText etTitle;
    @BindView(R.id.etDescription) EditText etDescription;
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
        if (!current.checkIfEmpty()) {
            //TODO: autopopulate info
        }
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
        //TODO: move these setter calls to when the title and description boxes are filled in so that a submission can occur when on the step2fragment
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
