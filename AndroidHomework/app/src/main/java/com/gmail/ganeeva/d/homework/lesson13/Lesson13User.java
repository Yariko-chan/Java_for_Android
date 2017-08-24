package com.gmail.ganeeva.d.homework.lesson13;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Diana on 09.08.2017 at 14:28.
 */

public class Lesson13User {
    public String name;
    public String surname;
    public String patronymic;

    public int age;
    public boolean gender; // male = true

    public String imageUrl;

    public Lesson13User(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @BindingAdapter({"bind:src"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
            .load(url)
            .into(view);
    }
}
