package com.gmail.ganeeva.d.homework.lesson11.presentation;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.gmail.ganeeva.d.homework.lesson11.domain.entity.DomainProfileId;
import com.gmail.ganeeva.d.homework.lesson11.presentation.profile_details.Lesson11ProfileActivity;
import com.gmail.ganeeva.d.homework.lesson11.presentation.profile_details.Lesson11ProfileViewModel;

/**
 * Created by Diana on 19.08.2017 at 17:45.
 */

public class ClickHandler {
    private Context context;

    public ClickHandler(Context context) {
        this.context = context;
    }

    public void onItemClick(DomainProfileId id) {
        Intent intent = new Intent(context, Lesson11ProfileActivity.class);
        intent.putExtra("ID", id.getStringValue());
        context.startActivity(intent);
    }

    public void onProfileEdit(Lesson11ProfileViewModel profile) {
        profile.state.set(Lesson11ProfileViewModel.STATE.EDIT);
    }

    public void onSaveProfile(Lesson11ProfileViewModel profile) {
        profile.saveProfile();
    }
}
