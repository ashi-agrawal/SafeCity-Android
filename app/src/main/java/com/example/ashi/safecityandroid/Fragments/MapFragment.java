package com.example.ashi.safecityandroid.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by ashi on 11/20/16.
 * Check out the following StackOverflow resources for additional help:
 * http://stackoverflow.com/questions/13733299/initialize-mapfragment-programmatically-with-maps-api-v2
 * http://stackoverflow.com/questions/31371865/replace-getmap-with-getmapasync
 */

public class MapFragment extends SupportMapFragment implements OnMapReadyCallback {

    private LatLng home;
    private GoogleMap map;
    private final Handler handler = new Handler();

    public MapFragment() {
        super();
    }

    public static MapFragment newInstance(){
        MapFragment frag = new MapFragment();
        return frag;
    }

    private void setHome(LatLng home){
        this.home = home;
        //TODO: set the zoom to encompass a certain radius around this location; alternatively, set the zoom to encompass a certain percent of trips AND home
    }

    @Override
    public View onCreateView(LayoutInflater arg0, ViewGroup arg1, Bundle arg2) {
        View v = super.onCreateView(arg0, arg1, arg2);
        getMapAsync(this);
        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                //TODO: implement intelligent zoom; use the location of different pins to do this
                //TODO: use markers as pins for the areas with maximal reports
            }
        });
    }
}