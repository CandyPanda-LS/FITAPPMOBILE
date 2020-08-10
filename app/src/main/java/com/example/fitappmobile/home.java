package com.example.fitappmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
          new BottomNavigationView.OnNavigationItemSelectedListener() {
              @Override
              public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                  Fragment selectedFragment = null;

                  switch (item.getItemId())
                  {
                      case R.id.nav_profile:
                          selectedFragment = new ProfileFragment();
                          break;
                      case R.id.nav_exercise:
                          selectedFragment = new ExerciseFragment();
                          break;
                      case R.id.nav_meal:
                          selectedFragment = new MealFragment();
                          break;
                      case R.id.nav_disease:
                          selectedFragment = new DiseaseFragment();
                          break;
                      case R.id.nav_journal:
                          selectedFragment = new JournalFragment();
                          break;
                  }

                  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                return true;
              }
          };

}