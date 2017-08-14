package com.example.domain.interactions;

import com.example.data.entity.DataProfile;
import com.example.domain.entity.DomainProfile;
import com.example.domain.entity.ProfileId;
import com.example.domain.interactions.base.UseCase;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Diana on 11.08.2017.
 */

public class ProfileUseCase extends UseCase<ProfileId, DomainProfile> {
    @Override
    public Observable<DomainProfile> buildUseCase() {

        // emulating query to data layer (which gets data from server or somewhere else)
        DataProfile profile = new DataProfile();
        profile.setName("Name");
        profile.setSurname("Surname");
        profile.setPatronymic("Patronymic");
        profile.setAge(20);
        profile.setGender(true);

        return Observable
                .just(profile) // just returns observable entity
                // .filter() exclude some data
                // .flatMap() implement another Observable
                // .flat
                // .subscribeWith
                .delay(5, TimeUnit.SECONDS)
                .map(new Function<DataProfile, DomainProfile>() {
                    // map modifies data from one class to other
                    @Override
                    public DomainProfile apply(@NonNull DataProfile dataProfile) throws Exception {
                        DomainProfile domainProfile = new DomainProfile();
                        domainProfile.setName(dataProfile.getName());
                        domainProfile.setSurname(dataProfile.getSurname());
                        domainProfile.setPatronymic(dataProfile.getPatronymic());
                        domainProfile.setAge(dataProfile.getAge());
                        domainProfile.setGender(dataProfile.getGender());

                        return domainProfile;
                    }
                });
    }
}
