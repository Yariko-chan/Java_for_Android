package com.gmail.ganeeva.d.homework.lesson11;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.gmail.ganeeva.d.homework.R;
import com.gmail.ganeeva.d.homework.databinding.ActivityLesson10MainBinding;
import com.gmail.ganeeva.d.homework.databinding.ActivityLesson11MainBinding;
import com.gmail.ganeeva.d.homework.databinding.ItemLesson9Binding;
import com.gmail.ganeeva.d.homework.lesson9.presentation.Lesson9ItemViewModel;

public class Lesson11MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLesson11MainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson11_main);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(new ProfilesListAdapter());
    }

    private class ProfilesListAdapter extends RecyclerView.Adapter<ProfileHolder> {
        @Override
        public ProfileHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(ProfileHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    public static class ProfileHolder extends RecyclerView.ViewHolder{
        private final ItemLesson11Binding binding;

        public ProfileHolder(ItemLesson11Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Lesson9ItemViewModel viewModel) {
            binding.setViewModel(viewModel);
            binding.executePendingBindings();
        }
    }
}
