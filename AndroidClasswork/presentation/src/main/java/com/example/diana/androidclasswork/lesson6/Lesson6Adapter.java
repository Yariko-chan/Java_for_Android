package com.example.diana.androidclasswork.lesson6;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diana.androidclasswork.R;

import java.util.ArrayList;

/**
 * Created by Diana on 04.08.2017.
 */

public class Lesson6Adapter extends RecyclerView.Adapter<Lesson6Adapter.Holder> {
    private ArrayList<String> items = new ArrayList<>();

    private OnItemClickListener listener;

    public Lesson6Adapter(ArrayList<String> items) {
        this.items = items;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lesson6_recycleview, parent, false);
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.textView.setText(items.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // повесили клик!
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    listener.onItemClick(position);
                    // here no buiseness logic, because it should be in activity
                    // only some interface changes in item like checkboxes

                    // clickListener may be on some parts of item, not on whole item
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public Holder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    interface OnItemClickListener {
        public void onItemClick(int position);
    }
}
