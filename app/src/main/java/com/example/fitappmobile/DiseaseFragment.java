package com.example.fitappmobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class DiseaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_disease, container, false);

        //addDiseaseBtn
        Button addDiseaseButtonFragment =  (Button) rootView.findViewById(R.id.addDiseaseBtn);

        //Navigate button for add diseases
        addDiseaseButtonFragment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_disease_container, new AddDiseasesFragment());
                fr.commit();
            }

        });

        //UpdateDailyGoalBtn
        Button updateDiseaseButtonFragment =  (Button) rootView.findViewById(R.id.editExerciseBtn);

        //Navigate button for update disease
        updateDiseaseButtonFragment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_disease_container, new UpdateDiseaseFragment());
                fr.commit();
            }

        });




        return rootView;
    }
}
