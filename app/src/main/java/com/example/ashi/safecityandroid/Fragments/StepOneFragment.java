package com.example.ashi.safecityandroid.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import com.example.ashi.safecityandroid.Models.Report;
import com.example.ashi.safecityandroid.R;

/**
 * Created by ashi on 11/7/16.
 */

public class StepOneFragment extends Fragment {
    Report current;

    private static final String TAG = StepOneFragment.class.getSimpleName();

    public static StepOneFragment newInstance (Report currentReport){
        StepOneFragment frag = new StepOneFragment();
        Bundle args = new Bundle();
        args.putParcelable("report", currentReport);
        frag.setArguments(args);
        return frag;
    }

    //TODO: embed a MapFragment here

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        current = getArguments().getParcelable("report");
        //TODO: if the current report has a location, autopopulate this fragment with a location

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.i(TAG, "Place: " + place.getName());
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stepone, parent, false);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
