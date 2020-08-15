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


public class MealFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_meal, container, false);


        //addMealBtn
        Button addMealButtonFragment =  (Button) rootView.findViewById(R.id.addMealBtn);

        //Navigate button for update Meal
        addMealButtonFragment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_meal_container, new AddMealFragment());
                fr.commit();
            }

        });

        //editMealBtn
        Button editMealButtonFragment =  (Button) rootView.findViewById(R.id.viewWorkout);

        //Navigate button for update Meal
        editMealButtonFragment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_meal_container, new UpdateMealFragment());
                fr.commit();
            }

        });
        return rootView;
    }
}
