package com.mad.fitapp;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Update_Progress extends Fragment {

    private EditText progressHeartRate;
    private EditText progressSteps;
    private Button updateProgressButton;
    private Bundle bundle;
    private ProgressDialog dialog;

    private FirebaseAuth auth;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference = database.getReference().child("Progress");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_update__progress, container, false);

        bundle = getArguments();
        auth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(getContext());
        progressHeartRate = view.findViewById(R.id.update_completed_heartpoints_text);
        progressSteps = view.findViewById(R.id.update_completed_steps_text);
        updateProgressButton = view.findViewById(R.id.update_progress_btn);

        displayProgressData();

        updateProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateProgressDetails();
            }
        });

        return view;
    }

    private void displayProgressData() {
        progressHeartRate.setText(bundle.getString("progressHeartPoints"));
        progressSteps.setText((bundle.getString("progressSteps")));
    }

    private void updateProgressDetails() {
        String updateHeartRate = progressHeartRate.getText().toString().trim();
        String updateSteps = progressSteps.getText().toString().trim();
        String progressId = bundle.getString("progressId");

        dialog.setMessage("Updating Progress Data...");
        dialog.show();

        UserProgress updateProgress = new UserProgress(progressId, updateSteps, updateHeartRate);

        reference.child(auth.getCurrentUser().getUid()).setValue(updateProgress).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    dialog.dismiss();
                    Toast.makeText(getContext(), "Progress Updated", Toast.LENGTH_LONG).show();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_frame, new GoalOverview());
                    transaction.addToBackStack(null);
                    transaction.commit();
                } else {
                    dialog.dismiss();
                    Toast.makeText(getContext(), "Progress Update Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}