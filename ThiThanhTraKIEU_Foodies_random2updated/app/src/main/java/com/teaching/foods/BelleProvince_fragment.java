package com.teaching.foods;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BelleProvince_fragment extends Fragment {

     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_belle_province_fragment, container, false);;
        return v;
    }
    public BelleProvince_fragment(){}
}