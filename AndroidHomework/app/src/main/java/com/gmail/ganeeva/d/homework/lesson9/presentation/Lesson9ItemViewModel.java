package com.gmail.ganeeva.d.homework.lesson9.presentation;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Diana on 16.08.2017 at 17:27.
 */

public class Lesson9ItemViewModel {
    public String imageUrl = "";


    @BindingAdapter({"bind:src"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
            .load(url)
            .into(view);
    }
}
