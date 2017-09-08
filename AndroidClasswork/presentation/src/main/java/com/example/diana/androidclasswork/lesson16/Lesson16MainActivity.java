package com.example.diana.androidclasswork.lesson16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.diana.androidclasswork.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmModel;

public class Lesson16MainActivity extends AppCompatActivity {
    @BindView(R.id.button) Button button;
    @BindView(R.id.editText) EditText editText;

    private Realm realm;
    private UserDB user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson16_main);
        ButterKnife.bind(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        realm = Realm.getDefaultInstance();
        loadData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        realm.close();
        if (user != null) user.removeAllChangeListeners();
    }

    private void loadData() {
        user = realm.where(UserDB.class)
                .equalTo("id", 10)
                .findFirst();
        if (user != null) {
            editText.setText(user.getName());

            user.addChangeListener(new RealmChangeListener<RealmModel>() {
                @Override
                public void onChange(RealmModel realmModel) {
                    // method invoked when user changed
                    // this resume must be unbounded in onPause()
                    editText.setText(user.getName());
                }
            });
        }
    }

    private void saveData() {
        if (user == null) {
            user = new UserDB();
            user.setId(10);
            realm.beginTransaction();
            user.setName(editText.getText().toString());
            realm.copyToRealmOrUpdate(user);
            realm.commitTransaction();
        }

        realm.beginTransaction();
        user.setName(editText.getText().toString());
        // this will work only if user loaded from realm or created by realm
        // if not, object not bound to db
        realm.commitTransaction();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                // asynchroniously
            }
        });
    }
}
