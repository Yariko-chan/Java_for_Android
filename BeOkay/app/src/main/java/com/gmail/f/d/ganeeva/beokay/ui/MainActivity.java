package com.gmail.f.d.ganeeva.beokay.ui;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.gmail.f.d.ganeeva.beokay.R;

public class MainActivity extends AppCompatActivity implements
    DiaryFragment.OnFragmentInteractionListener,
    ScheduleFragment.OnFragmentInteractionListener,
    TrainingFragment.OnFragmentInteractionListener,
    SettingsFragment.OnFragmentInteractionListener{

    public static final String SETTINGS_FRAGMENT_NAME = SettingsFragment.class.getSimpleName();
    public static final String SCHEDULE_FRAGMENT_NAME = ScheduleFragment.class.getSimpleName();
    public static final String TRAINING_FRAGMENT_NAME = TrainingFragment.class.getSimpleName();
    public static final String DIARY_FRAGMENT_NAME = DiaryFragment.class.getSimpleName();

    private BottomNavigationView bottomNavigationView;;

    private boolean backToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final FragmentManager fragmentManager = getFragmentManager();

        // define your fragments here
        final Fragment scheduleFragment = new ScheduleFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(SCHEDULE_FRAGMENT_NAME)
            .replace(R.id.container, scheduleFragment).commit();

        bottomNavigationView = (BottomNavigationView)
            findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_schedule: {
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction
                                .replace(R.id.container, scheduleFragment).commit();
                            return true;
                        }
                        case R.id.action_diary: {
                            final Fragment diaryFragment = new DiaryFragment();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction
                                .replace(R.id.container, diaryFragment).commit();
                            return true;
                        }
                        case R.id.action_training: {
                            Fragment trainingFragment = new TrainingFragment();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction
                                .replace(R.id.container, trainingFragment).commit();
                            return true;
                        }
                        case R.id.action_settings: {
                            Fragment sttingsFragment = new SettingsFragment();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction
                                .replace(R.id.container, sttingsFragment).commit();
                            return true;
                        }

                    }
                    return true;
                }
            });
    }

    @Override
    public void onBackPressed() {
        if (backToExitPressedOnce) {
//                clearBackstack(fragmentManager);
//                super.onBackPressed(); // second BACK exits app
            this.finish();
        } else {
            Toast.makeText(this, R.string.exit_caution, Toast.LENGTH_SHORT).show();
            backToExitPressedOnce = true;
        };
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(this, uri.toString(), Toast.LENGTH_LONG).show();
    }
}
