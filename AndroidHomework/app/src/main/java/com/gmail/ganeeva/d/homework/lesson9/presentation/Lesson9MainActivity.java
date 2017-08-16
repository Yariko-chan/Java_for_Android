package com.gmail.ganeeva.d.homework.lesson9.presentation;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.gmail.ganeeva.d.homework.R;
import com.gmail.ganeeva.d.homework.databinding.ActivityLesson9MainBinding;
import com.gmail.ganeeva.d.homework.lesson10.Lesson10ViewModel;

public class Lesson9MainActivity extends AppCompatActivity {
    private Lesson10ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLesson9MainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson9_main);
        binding.setModel(viewModel);

        binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        binding.recyclerView.setAdapter(new Lesson9MainActivity.ImagesAdapter(this));
    }

    private class ImagesAdapter extends RecyclerView.Adapter<Lesson9MainActivity.ImageHolder> {
        private Context context;
        private ProgressBar pb;

        public ImagesAdapter(Context context) {
            this.context = context;
        }

        @Override
        public Lesson9MainActivity.ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lesson6, parent, false);
            return new Lesson9MainActivity.ImageHolder(root);
        }

        @Override
        public void onBindViewHolder(final Lesson9MainActivity.ImageHolder holder, int position) {
            Glide.with(context)
                .load(urls[position])
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
                })
                .into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return urls.length;
        }
    }

    public static class ImageHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        ProgressBar progressBar;

        public ImageHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
        }
    }
}
