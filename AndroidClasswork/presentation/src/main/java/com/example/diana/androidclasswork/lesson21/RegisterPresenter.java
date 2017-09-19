package com.example.diana.androidclasswork.lesson21;

import com.example.diana.androidclasswork.ThisApplication;
import com.example.domain.entity.AuthState;
import com.example.domain.entity.OkHttp;
import com.example.domain.entity.RegisterDomainModel;
import com.example.domain.interactions.AuthService;
import com.example.domain.interactions.RegisterUseCase;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Diana on 19.09.2017.
 */

public class RegisterPresenter implements RegisterBasePresenter{
    @Inject
    RegisterUseCase useCase;
    private AuthService authService;
    private RegisterView view;

    public RegisterPresenter(RegisterView view) {
        ThisApplication.appComponent.inject(this);
        this.view = view;
    }

    @Override
    public void init() {

    }

    @Override
    public void resume() {
        authService.observeState().subscribeWith(new DisposableObserver<AuthState>() {
            @Override
            public void onNext(@NonNull AuthState authState) {
                // check out state
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        })
    }

    @Override
    public void pause() {

    }

    @Override
    public void release() {
        useCase.dispose();
    }

    @Override
    public void onRegisterButtonClick(String username, String password) {
        RegisterDomainModel model = new RegisterDomainModel(username, password);
        useCase.execute(model, new DisposableObserver<OkHttp>() {
            @Override
            public void onNext(@NonNull OkHttp okHttp) {
                view.dismissProgress();
                view.goToMainActivity();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                view.showError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
