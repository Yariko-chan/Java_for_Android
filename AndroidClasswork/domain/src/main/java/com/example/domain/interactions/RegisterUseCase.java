package com.example.domain.interactions;


import com.example.data.entity.AccessTokenDataModel;
import com.example.data.entity.RegisterDataModel;
import com.example.data.net.RestService;
import com.example.domain.entity.RegisterDomainModel;
import com.example.domain.entity.OkHttp;
import com.example.domain.interactions.base.UseCase;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Diana on 19.09.2017.
 */

public class RegisterUseCase extends UseCase<RegisterDomainModel, OkHttp> {

    private AuthService authService;

    @Inject
    public RegisterUseCase (AuthService authService) {
        this.authService = authService;
    }

    @Override
    public Observable<OkHttp> buildUseCase(RegisterDomainModel registerDomainModel) {
        return RestService.getInstance()
                .register(convert(registerDomainModel)) // get access token
                .doOnNext(new Consumer<AccessTokenDataModel>() {
                    @Override // промежуточные действия используя источник данных (но не меняя его - void)
                    public void accept(AccessTokenDataModel accessTokenDataModel) throws Exception {
                        authService // save token
                                .saveAccessToken(accessTokenDataModel.getToken());
                    }
                })
                .map(new Function<AccessTokenDataModel, OkHttp>() { // return everything ok
                    @Override
                    public OkHttp apply(@NonNull AccessTokenDataModel accessTokenDataModel) throws Exception {
                        return new OkHttp();
                    }
                });
    }

    private RegisterDataModel convert(RegisterDomainModel registerDomainModel) {
        return new RegisterDataModel(
                registerDomainModel.getUserName(),
                registerDomainModel.getPassword()
        );
    }
}
