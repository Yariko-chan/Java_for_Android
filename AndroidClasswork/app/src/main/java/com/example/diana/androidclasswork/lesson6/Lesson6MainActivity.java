package com.example.diana.androidclasswork.lesson6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.diana.androidclasswork.R;

import java.util.ArrayList;

public class Lesson6MainActivity extends AppCompatActivity {

    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson6_main);

        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");
        list.add("Sunday");
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");
        list.add("Sunday");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);

        LinearLayoutManager llManager = new LinearLayoutManager(this);
        // GridLayout
        // StaggeredGridLayout
        // also cutom LayoutManagers
        recyclerView.setLayoutManager(llManager);
        recyclerView.setAdapter(new Lesson6Adapter(list));
    }
}
