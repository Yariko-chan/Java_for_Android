package com.gmail.ganeeva.d.homework.lesson13;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.ganeeva.d.homework.R;
import com.gmail.ganeeva.d.homework.databinding.FragmentLesson13Binding;

public class Lesson13Fragment extends Fragment {

    private Lesson13User user;

    public Lesson13Fragment() {
    }


    public static Lesson13Fragment newInstance() {
        Lesson13Fragment fragment = new Lesson13Fragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createRandomUser();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("", "");
        FragmentLesson13Binding binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_lesson13, container, false);
        binding.setUser(user);

        return binding.getRoot();
    }

    private void createRandomUser() {
        user = new Lesson13User("Oleh", 30, true);
        user.surname = "Alexeev";
        user.patronymic = "Sergeyevich";
        user.imageUrl = "http://img10.deviantart.net/32d6/i/2015/109/0/5/random_man_by_taeef-d6swsj3.jpg";
    }
}
