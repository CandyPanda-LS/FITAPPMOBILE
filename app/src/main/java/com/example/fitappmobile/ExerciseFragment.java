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


public class ExerciseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_exercise, container, false);

        //addExerciseBtn
        Button addExerciseButtonFragment =  (Button) rootView.findViewById(R.id.addExerciseBtn);

        //Navigate button for add Exerciser
        addExerciseButtonFragment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_exercise_container, new AddExerciseFragment());
                fr.commit();
            }

        });

        //updateExerciseBtn
        Button editExerciseButtonFragment =  (Button) rootView.findViewById(R.id.editExerciseBtn);

        //Navigate button for edit Exercise
        editExerciseButtonFragment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_exercise_container, new EditWorkoutsFragment());
                fr.commit();
            }

        });


        //viewWorkout
        Button viewExerciseButtonFragment =  (Button) rootView.findViewById(R.id.viewWorkout);

        //Navigate button for view Exerciser
        viewExerciseButtonFragment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_exercise_container, new IndividualWorkout());
                fr.commit();
            }

        });


        return  rootView;
    }
}
