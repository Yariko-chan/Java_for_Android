package com.gmail.ganeeva.d.homework.lesson11.presentation.profile_details;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.widget.EditText;

import com.gmail.ganeeva.d.homework.lesson11.data.DataProfile;
import com.gmail.ganeeva.d.homework.lesson11.domain.entity.DomainProfile;
import com.gmail.ganeeva.d.homework.lesson11.domain.entity.DomainProfileId;
import com.gmail.ganeeva.d.homework.lesson11.domain.interactions.GetProfileUseCase;
import com.gmail.ganeeva.d.homework.lesson11.domain.interactions.SaveProfileUseCase;
import com.gmail.ganeeva.d.homework.base.BaseViewModel;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Diana on 21.08.2017 at 9:37.
 */

public class Lesson11ProfileViewModel implements BaseViewModel{
    private static final String TAG = Lesson11ProfileViewModel.class.getSimpleName();
    private final DomainProfileId id;

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> surname = new ObservableField<>("");;
    public ObservableInt age = new ObservableInt();

    public enum STATE {PROGRESS, DATA, ERROR, EDIT}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private GetProfileUseCase getProfileUseCase = new GetProfileUseCase();
    private SaveProfileUseCase saveProfileUseCase = new SaveProfileUseCase();

    public Lesson11ProfileViewModel(DomainProfileId id) {
        this.id = id;
    }

    public Lesson11ProfileViewModel(String id) {
        this.id = new DomainProfileId(id);
    }

    @Override
    public void init() {
        getProfileUseCase.execute(id, new DisposableObserver<DomainProfile>() {
            @Override
            public void onNext(@NonNull DomainProfile domainProfile) {
                name.set(domainProfile.getName());
                surname.set(domainProfile.getSurname());
                age.set(domainProfile.getAge());
                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                state.set(STATE.ERROR);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void release() {

    }

    public void saveProfile() {
        DomainProfile domainProfile = new DomainProfile();
        domainProfile.setId(id);
        domainProfile.setName(name.get());
        domainProfile.setSurname(surname.get());
        domainProfile.setAge(age.get());
        saveProfileUseCase.execute(domainProfile, new DisposableObserver<DataProfile>() {
            @Override
            public void onNext(@NonNull DataProfile aVoid) {
                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                state.set(STATE.ERROR);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @BindingAdapter("android:text")
    public static void setText(EditText view, int value) {
        view.setText(String.valueOf(value));
    }

    @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
    public static int getText(EditText view) {
        try {
            return Integer.valueOf(view.getText().toString());
        } catch (NumberFormatException e) {
            Log.e(TAG, "Wrong number format: " + e.getMessage());
            return 0;
        }

    }
}
