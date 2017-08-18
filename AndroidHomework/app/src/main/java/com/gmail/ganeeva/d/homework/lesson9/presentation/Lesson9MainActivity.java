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
import com.gmail.ganeeva.d.homework.databinding.ItemLesson9Binding;
import com.gmail.ganeeva.d.homework.lesson10.Lesson10ViewModel;
import com.gmail.ganeeva.d.homework.lesson9.domain.GetImageCountUseCase;

public class Lesson9MainActivity extends AppCompatActivity {
    private Lesson10ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLesson9MainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson9_main);

        binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        binding.recyclerView.setAdapter(new Lesson9MainActivity.ImagesAdapter());
    }

    private class ImagesAdapter extends RecyclerView.Adapter<Lesson9MainActivity.ImageHolder> {

        public ImagesAdapter() {
        }

        @Override
        public Lesson9MainActivity.ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            ItemLesson9Binding itemBinding = ItemLesson9Binding.inflate(layoutInflater, parent, false);
            return new ImageHolder(itemBinding);
        }

        @Override
        public void onBindViewHolder(final Lesson9MainActivity.ImageHolder holder, int position) {
            Lesson9ItemViewModel model = new Lesson9ItemViewModel(position);
            holder.bind(model);
        }

        @Override
        public int getItemCount() {
            return new GetImageCountUseCase().execute(null);
        }
    }

    public static class ImageHolder extends RecyclerView.ViewHolder{
        private final ItemLesson9Binding binding;

        public ImageHolder(ItemLesson9Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Lesson9ItemViewModel viewModel) {
            binding.setViewModel(viewModel);
            binding.executePendingBindings();
        }
    }
}
