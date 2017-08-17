package com.gmail.ganeeva.d.homework.lesson9.presentation;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * Created by Diana on 16.08.2017 at 17:27.
 */

public class Lesson9ItemViewModel {
    public String imageUrl = "";


    @BindingAdapter({"bind:src"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
            .load(url)
            .listener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    return false;
                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    holder.progressBar.setVisibility(View.GONE);
                    holder.imageView.setVisibility(View.VISIBLE);
                    return false;
                }
            .into(view);
    }
}
