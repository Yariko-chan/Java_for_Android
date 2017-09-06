package com.gmail.ganeeva.d.homework.lesson11.domain.interactions;

import com.gmail.ganeeva.d.homework.base.interactions.UseCase;
import com.gmail.ganeeva.d.homework.lesson11.data.DataProfile;
import com.gmail.ganeeva.d.homework.lesson11.data.net.RestService;
import com.gmail.ganeeva.d.homework.lesson11.domain.entity.DomainProfile;
import com.gmail.ganeeva.d.homework.lesson11.domain.entity.DomainProfileId;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Diana on 21.08.2017 at 8:45.
 */

public class GetProfileUseCase extends UseCase<DomainProfileId, DomainProfile> {

    @Override
    public Observable<DomainProfile> buildUseCase(DomainProfileId domainProfileId) {
        return RestService.getInstance()
            .getProfile(domainProfileId.getStringValue())
            .map(new Function<DataProfile, DomainProfile>() {
                @Override
                public DomainProfile apply(@NonNull DataProfile dataProfile) throws Exception {
                    return GetProfilesUseCase.convert(dataProfile);
                }
            });
    }
}
