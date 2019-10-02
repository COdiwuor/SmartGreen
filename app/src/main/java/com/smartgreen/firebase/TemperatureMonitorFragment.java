package com.smartgreen.firebase;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goodiebag.protractorview.ProtractorView;


public class TemperatureMonitorFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_temperature_monitor, container, false);
        //ProtractorView protractorView = rootview.findViewById(R.id.protractorView);
        //protractorView.setTickIntervals(15);
        //protractorView.setArcColor(getResources().getColor(R.color.colorAccent));
        //protractorView.setProgressColor(getResources().getColor(R.color.colorPrimary));
        return rootview;
    }
}
