package com.example.fitappmobile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserRequirementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateDiseaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_update_diseases, container, false);
        // Inflate the layout for this fragment
        return view;
    }
}