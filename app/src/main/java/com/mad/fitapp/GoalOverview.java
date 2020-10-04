package com.mad.fitapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class GoalOverview extends Fragment {

    public String targetHeartPoints;
    public String targetSteps;
    public String completedSteps;
    public String completedHeartPoints;

    public String progressId;
    public String progressHeartPoints;
    public String progress_steps;
    public Update_Progress updateProgress;

    private ImageView userProfilePicture;
    private TextView userName;
    private TextView heartRate;
    private TextView steps;
    private TextView progressHeartRate;
    private TextView progressSteps;
    private  TextView progressoverview;
    private Button deleteProgressButton;
    private Button updateProgressButton;

//    private FirebaseAuth auth;
//    private FirebaseDatabase database = FirebaseDatabase.getInstance();
//    private DatabaseReference userReference = database.getReference().child("Users");
//    private DatabaseReference goalReference = database.getReference().child("Goals");
//    private DatabaseReference progressReference = database.getReference().child("Progress");



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goaloverview, container, false);

//
//
//        userProfilePicture = view.findViewById(R.id.goal_user_image);
//        userName = view.findViewById(R.id.goal_user_name);
//        heartRate = view.findViewById(R.id.goal_target_heart_points);
//        steps = view.findViewById(R.id.goal_target_steps);
//        progressHeartRate = view.findViewById(R.id.progress_heartpoints_text);
//        progressSteps = view.findViewById(R.id.progress_steps_text);
//        progressoverview = view.findViewById(R.id.progress_overview);
//        deleteProgressButton = view.findViewById(R.id.delete_progress_button);
//        updateProgressButton = view.findViewById(R.id.update_progress_button);
//        auth = FirebaseAuth.getInstance();
//        updateProgress = new Update_Progress();
//
//        displayGoalData();
//
//        //Update Progress
//        updateProgressButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                progressReference.child(auth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        progressId = snapshot.child("progressId").getValue().toString();
//                        progressHeartPoints = snapshot.child("completedHeartPoints").getValue().toString();
//                        progress_steps = snapshot.child("completedSteps").getValue().toString();
//                        Bundle bundle = new Bundle();
//                        bundle.putString("progressId", progressId);
//                        bundle.putString("progressSteps", progress_steps);
//                        bundle.putString("progressHeartPoints", progressHeartPoints);
//                        updateProgress.setArguments(bundle);
//
//                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                        transaction.replace(R.id.main_frame, updateProgress);
//                        transaction.addToBackStack(null);
//                        transaction.commit();
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) { }
//                });
//            }
//        });
//
//
//        //Delete Disease
//        deleteProgressButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
//                alertDialog.setCancelable(false);
//                alertDialog.setTitle("Delete Item");
//                alertDialog.setMessage("Do you want to delete this item ?");
//                alertDialog.setButton("Yes", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        progressDelete();
//                    }
//                });
//                alertDialog.setButton2("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.dismiss();
//                    }
//                });
//                alertDialog.show();
//            }
//
//            private void progressDelete() {
//                progressReference.child(auth.getCurrentUser().getUid()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(getContext(), "Progress Deleted", Toast.LENGTH_SHORT).show();
//                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                            transaction.replace(R.id.main_frame, new Dashboard());
//                            transaction.addToBackStack(null);
//                            transaction.commit();
//                        } else {
//                            Toast.makeText(getContext(), "Progress Delete Failed", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//            }
//
//
//        });

        return view;
    }



//    private void displayGoalData() {
//        userReference.child(auth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                userName.setText(snapshot.child("name").getValue().toString());
//                Picasso.get().load(snapshot.child("imageUrl").getValue().toString()).into(userProfilePicture);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) { }
//        });
//
//        goalReference.child(auth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                heartRate.setText(snapshot.child("heartRate").getValue().toString());
//                steps.setText(snapshot.child("steps").getValue().toString());
//
//
//                targetSteps = snapshot.child("steps").getValue().toString();
//                targetHeartPoints = snapshot.child("heartRate").getValue().toString();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) { }
//        });
//
//        progressReference.child(auth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                completedHeartPoints = snapshot.child("completedHeartPoints").getValue().toString();
//                completedSteps = snapshot.child("completedSteps").getValue().toString();
//
//                progressHeartRate.setText(snapshot.child("completedHeartPoints").getValue().toString());
//                progressSteps.setText(snapshot.child("completedSteps").getValue().toString());
//
//                //int finalSteps = Integer.parseInt(completedSteps) - Integer.parseInt(targetSteps);
//                int finalSteps = calculateStepProgress(Integer.parseInt(completedSteps),Integer.parseInt(targetSteps));
//                //int finalHeartPoints = Integer.parseInt(completedHeartPoints) - Integer.parseInt(targetHeartPoints);
//                int finalHeartPoints = calculateHeartPointsProgress(Integer.parseInt(completedHeartPoints),Integer.parseInt(targetHeartPoints));
//
//
//                String msgOne = "";
//                String msgTwo = "";
//
//                if(finalSteps > 0){
//                    msgOne = "You are above " + finalSteps + " steps";
//                }
//                else if( finalSteps < 0 ){
//                    msgOne = "You have another " +  Math.abs(finalSteps) + " steps to complete";
//                }
//                else if(finalSteps == 0){
//                    msgOne = "You have another " + finalSteps + " steps to complete";
//                }
//
//                if(finalHeartPoints > 0){
//                    msgTwo = "You are above " + finalHeartPoints + " heart points";
//                }
//                else if( finalHeartPoints < 0 ){
//                    msgTwo = "You have another " + Math.abs(finalHeartPoints) + " heart points to complete";
//                }
//                else if(finalHeartPoints == 0){
//                    msgTwo = "You have another " + finalHeartPoints + " heart points to complete";
//                }
//
//                progressoverview.setText(msgOne + " " + msgTwo);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) { }
//        });
//
//
//
//
//    }


    public static int  calculateStepProgress(int completedSteps,int targetSteps){

        int outputSteps = completedSteps - targetSteps;

        return  Math.abs(outputSteps);

    }

    public static int  calculateHeartPointsProgress(int completedHeartPoints,int targetHeartPoints){

        int outputHeartpoints = completedHeartPoints - targetHeartPoints;

        return  Math.abs(outputHeartpoints);

    }

}