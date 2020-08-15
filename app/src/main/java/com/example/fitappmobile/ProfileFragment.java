package com.example.fitappmobile;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View  rootView = inflater.inflate(R.layout.fragment_profile, container, false);


        //Pie Chart Steps
        PieChart pieChart =  (PieChart) rootView.findViewById(R.id.pieChartSteps);

        ArrayList<PieEntry> visitorsPieChart = new ArrayList<>();
        visitorsPieChart.add(new PieEntry(60,"Completed"));
        visitorsPieChart.add(new PieEntry(40,"Incomplete"));


        PieDataSet pieDataSet = new PieDataSet(visitorsPieChart,"");
        pieDataSet.setColors(Color.rgb(5, 101, 255), Color.rgb(39, 76, 135));
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(10f);


        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Steps");
        pieChart.setHoleRadius(73f);
        pieChart.setDrawSliceText(false);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setEntryLabelTextSize(15);
        pieChart.animate();

        //Pie Chart HeartPoints
        PieChart pieChartHeartPoints =  (PieChart) rootView.findViewById(R.id.pieChartHeartPoints);

        ArrayList<PieEntry> visitorsPieChartHeartPoints = new ArrayList<>();
        visitorsPieChartHeartPoints.add(new PieEntry(70,"Completed"));
        visitorsPieChartHeartPoints.add(new PieEntry(30,"Incomplete"));


        PieDataSet pieDataSetHeartPoints = new PieDataSet(visitorsPieChartHeartPoints,"");
        pieDataSetHeartPoints.setColors(Color.rgb(219, 15, 0), Color.rgb(250, 110, 100));
        pieDataSetHeartPoints.setValueTextColor(Color.WHITE);
        pieDataSetHeartPoints.setValueTextSize(10f);


        PieData pieDataHeartPoints = new PieData(pieDataSetHeartPoints);

        pieChartHeartPoints.setData(pieDataHeartPoints);
        pieChartHeartPoints.getDescription().setEnabled(false);
        pieChartHeartPoints.setCenterText("Heart Points");
        pieChartHeartPoints.setHoleRadius(73f);
        pieChartHeartPoints.setDrawSliceText(false);
        pieChartHeartPoints.setEntryLabelColor(Color.BLACK);
        pieChartHeartPoints.setEntryLabelTextSize(15);
        pieChartHeartPoints.animate();

        //setDailyGoalBtn
     Button setDailyGoalButtonFragment =  (Button) rootView.findViewById(R.id.setDailyGoalBtn);

     //UpdateDailyGoalBtn
     Button updateDailyGoalButtonFragment =  (Button) rootView.findViewById(R.id.editExerciseBtn);

     //setProgressBtn
        Button setProgressBtnFragment =  (Button) rootView.findViewById(R.id.setProgressBtn);

     //Navigate button for set daily goals
     setDailyGoalButtonFragment.setOnClickListener(new View.OnClickListener(){
       @Override
      public void onClick(View v){
        FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.replace(R.id.fragment_profile_container, new UserRequirementFragment());
        fr.commit();
       }

     });

     //Navigate button for update daily goals
        updateDailyGoalButtonFragment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentTransaction frDailyGoalUpdate = getFragmentManager().beginTransaction();
                frDailyGoalUpdate.replace(R.id.fragment_profile_container, new UpdateDailyGoal());
                frDailyGoalUpdate.commit();
            }

        });

        //Navigate button for set daily progress
        setProgressBtnFragment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentTransaction frDailyProgress = getFragmentManager().beginTransaction();
                frDailyProgress.replace(R.id.fragment_profile_container, new SetProgressFragment());
                frDailyProgress.commit();
            }

        });


        return rootView;

    }
}
