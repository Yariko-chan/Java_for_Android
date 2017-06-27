package patterns.adapter;

import java.util.ArrayList;

/**
 * Created by user on 26.06.2017.
 */
public class Main {
    private ArrayList<Man> list = new ArrayList<>();

    public void main(String[] args) {

        ListView lv = new ListView();
        lv.setAdapter(new ListViewAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public int getView() {
                return 0;
            }
        });
    }
}
