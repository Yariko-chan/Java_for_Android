package com.gmail.ganeeva.d.homework.lesson14.presenation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.gmail.ganeeva.d.homework.databinding.ItemSpinnerLesson14Binding;
import com.gmail.ganeeva.d.homework.lesson14.domain.entity.AssetCountry;

import java.util.ArrayList;

/**
 * Created by Diana on 05.09.2017 at 15:50.
 */

public class Lesson14CountrySpinnerAdapter extends BaseAdapter {

    private ArrayList<AssetCountry> countryList = new ArrayList<>();

    public void setCountryList(ArrayList<AssetCountry> countryList) {
        this.countryList = countryList;
    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int position) {
        if (position >= countryList.size()) return countryList.get(0);
        return countryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            // create new holder
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            Lesson14ItemViewModel viewModel = new Lesson14ItemViewModel(countryList.get(position));
            holder = ViewHolder.create(inflater, parent, viewModel);
            convertView = holder.dataBinding.getRoot();

            convertView.setTag(holder);
        } else {
            // update model for old holder
            holder = (ViewHolder) convertView.getTag();
            holder.bind(countryList.get(position));
        }

        return convertView;
    }


    static class ViewHolder {

        ItemSpinnerLesson14Binding dataBinding;
        Lesson14ItemViewModel viewModel;

        public ViewHolder(ItemSpinnerLesson14Binding dataBinding, Lesson14ItemViewModel viewModel) {
            this.dataBinding = dataBinding;
            this.viewModel = viewModel;
            dataBinding.setViewModel(viewModel);
        }

        public void bind(AssetCountry country) {
            viewModel.setCountry(country);
            dataBinding.executePendingBindings(); // refresh layout
        }

        public static ViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                        Lesson14ItemViewModel viewModel) {
            ItemSpinnerLesson14Binding binding = ItemSpinnerLesson14Binding.inflate(inflater, parent, false);
            return new ViewHolder(binding, viewModel);
        }
    }

}
