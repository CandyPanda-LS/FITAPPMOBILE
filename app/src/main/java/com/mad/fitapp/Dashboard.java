package com.mad.fitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        //addDiseaseBtn
        Button setGoalButtonFragment =  (Button) view.findViewById(R.id.setGoalButton);
        Button viewgoaloverviewButtonFragment =  (Button) view.findViewById(R.id.view_user_goal_btn);
        Button Set_daily_progress_fragment_btn =  (Button) view.findViewById(R.id.set_daily_progress_fragment_btn);
        Button set_signout_button = (Button)view.findViewById(R.id.signoutbutton);

        //Navigate button for set daily goal button
        set_signout_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
            }

        });

        //Navigate button for set daily goal button
        setGoalButtonFragment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.main_frame, new SetGoal());
                fr.commit();
            }

        });

        //Navigate button for set daily goal button
        viewgoaloverviewButtonFragment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.addToBackStack(null);
                fr.replace(R.id.main_frame, new GoalOverview());
                fr.commit();
            }

        });

        //Navigate button for set daily goal button
        Set_daily_progress_fragment_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.addToBackStack(null);
                fr.replace(R.id.main_frame, new Set_Progress());
                fr.commit();
            }

        });

        return view;
    }
}