package com.gmail.ganeeva.d.homework.lesson11.domain.interactions;

import com.gmail.ganeeva.d.homework.base.interactions.UseCase;
import com.gmail.ganeeva.d.homework.lesson11.data.DataProfile;
import com.gmail.ganeeva.d.homework.lesson11.data.net.RestService;
import com.gmail.ganeeva.d.homework.lesson11.domain.entity.DomainProfile;

import io.reactivex.Observable;

/**
 * Created by Diana on 21.08.2017 at 12:08.
 */

public class SaveProfileUseCase extends UseCase<DomainProfile, DataProfile> {
    @Override
    public Observable<DataProfile> buildUseCase(DomainProfile domainProfile) {
        return RestService.getInstance().saveOldProfile(convert(domainProfile));
    }

    public static DataProfile convert(DomainProfile domainProfile) {
        DataProfile dataProfile = new DataProfile();
        dataProfile.setName(domainProfile.getName());
        dataProfile.setSurname(domainProfile.getSurname());
        dataProfile.setAge(domainProfile.getAge());
        dataProfile.setId(domainProfile.getId().getStringValue());
        return dataProfile;
    }
}
