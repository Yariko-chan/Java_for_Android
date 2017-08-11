package com.example.diana.androidclasswork.lesson6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.diana.androidclasswork.R;

import java.util.ArrayList;

public class Lesson6MainActivity extends AppCompatActivity {

    private static final String TAG = Lesson6MainActivity.class.getSimpleName();
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
        Lesson6Adapter adapter = new Lesson6Adapter(list);
        adapter.setListener(new Lesson6Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // better solution to track click events
                // because here able to open new Activity
                // (in Adapter it would be harder and not elegant)
                // also not so dependent!
                Log.d(TAG, "Clicked");
            }
        });

        recyclerView.setAdapter(adapter);
    }
}
