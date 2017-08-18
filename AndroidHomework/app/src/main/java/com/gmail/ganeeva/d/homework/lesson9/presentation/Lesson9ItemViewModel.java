package com.gmail.ganeeva.d.homework.lesson9.presentation;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.gmail.ganeeva.d.homework.lesson9.domain.GetImageUrlUseCase;

import io.reactivex.Observable;

/**
 * Created by Diana on 16.08.2017 at 17:27.
 */

public class Lesson9ItemViewModel {
    public ObservableField<String> imageUrl = new ObservableField<>("");

    public Lesson9ItemViewModel(int position) {
        imageUrl.set(new GetImageUrlUseCase().execute(position));
    }

    public void bind(int i) {

    }

    @BindingAdapter({"bind:src"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
            .load(url)
            .into(view);
    }
}
