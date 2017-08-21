package com.example.diana.androidclasswork.lesson13;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diana.androidclasswork.R;

/**
 * Created by Diana on 21.08.2017.
 */

public class Lesson13Fragment extends Fragment {

    public static final String TEXT_KEY = "TEXT_KEY";
    private String text = "";

    // only one constructor without parameters!

    //this is how to pass arguments to Fragment (for example)
    public static Lesson13Fragment newInstance(FragmentManager manager, String text) {

        Lesson13Fragment lesson13Fragment;
        Fragment fragment = manager.findFragmentByTag(Lesson13Fragment.class.getName());

        if (null != fragment && fragment instanceof Lesson13Fragment) {
            lesson13Fragment = (Lesson13Fragment) fragment;
        } else {
            lesson13Fragment = new Lesson13Fragment();
            Bundle bundle = new Bundle(); // guarantees that data will be saved after restarting fragment (orientation change)
            bundle.putString(TEXT_KEY, text);
            lesson13Fragment.setArguments(bundle);
        }

        return lesson13Fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (null != bundle) {
            text = bundle.getString(TEXT_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // here nothing to do woth interface - it's not created yet
        return inflater.inflate(R.layout.fragment_lesson13, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // fragment already created, all onclick setting and else here

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // here able to invoke methods on activity
        // but getActivity may return null because fragment created and activity not
        // here activity alwways created
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // 99% would be invoked (in activity 50/50)
    }
}
