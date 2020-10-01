package com.mad.fitapp;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
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


public class Set_Progress extends Fragment {

    private EditText completedSteps;
    private EditText completedHeartPoints;
    private Button setProgressButton;
    private ProgressDialog dialog;

    private FirebaseAuth auth;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference = database.getReference().child("Progress");

    public Set_Progress() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_set__progress, container, false);

        dialog = new ProgressDialog(getContext());
        auth = FirebaseAuth.getInstance();

        completedSteps = view.findViewById(R.id.completed_steps_input);
        completedHeartPoints = view.findViewById(R.id.completed_heartpoints_input);
        setProgressButton = view.findViewById(R.id.set_progress_button);


        setProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUserProgress();
            }
        });

        return view;
    }

    private void addUserProgress() {
        String CompletedSteps = completedSteps.getText().toString().trim();
        String CompletedHeartPoints = completedHeartPoints.getText().toString().trim();
        String ProgressId = reference.push().getKey();

//        if (TextUtils.isEmpty(goalDate)) {
//            currentDate.setError("Date is required");
//            return;
//        }

        dialog.setMessage("Adding Progress...");
        dialog.show();

        UserProgress newProgress = new UserProgress(ProgressId, CompletedSteps, CompletedHeartPoints);
        reference.child(auth.getCurrentUser().getUid()).setValue(newProgress).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    dialog.dismiss();
                    Toast.makeText(getContext(), "Progress Added", Toast.LENGTH_SHORT).show();

                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_frame, new Dashboard());
                    transaction.addToBackStack(null);
                    transaction.commit();
                } else {
                    dialog.dismiss();
                    Toast.makeText(getContext(), "Progress Add Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}