package com.example.fitappmobile;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View  rootView = inflater.inflate(R.layout.fragment_profile, container, false);


        //Bar Chart
        BarChart barChart =  (BarChart) rootView.findViewById(R.id.barChart);

        ArrayList<BarEntry> visitors = new ArrayList<>();
        visitors.add(new BarEntry(1,420));
        visitors.add(new BarEntry(2,440));
        visitors.add(new BarEntry(3,460));
        visitors.add(new BarEntry(4,470));
        visitors.add(new BarEntry(5,490));

        BarDataSet barDataSet = new BarDataSet(visitors,"Days");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(10f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Daily Steps");
        barChart.animateY(2000);


        //Pie Chart
        PieChart pieChart =  (PieChart) rootView.findViewById(R.id.pieChart);

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


        return rootView;

    }
}
