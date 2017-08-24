package com.example.diana.androidclasswork.lesson13;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diana.androidclasswork.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Lesson13FragmentSecond.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Lesson13FragmentSecond#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lesson13FragmentSecond extends Fragment {

    public static Lesson13Fragment newInstance() {
        return new Lesson13Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // here nothing to do woth interface - it's not created yet
        return inflater.inflate(R.layout.fragment_lesson13_second, container, false);
    }
}
