package com.gmail.ganeeva.d.homework.lesson11.domain.interactions;

import com.example.data.entity.DataProfile;
import com.example.data.net.RestService;
import com.example.domain.entity.DomainProfile;
import com.example.domain.entity.ProfileId;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Diana on 11.08.2017.
 */

public class ProfileUseCase extends UseCase<ProfileId, DomainProfile> {
    @Override
    public Observable<DomainProfile> buildUseCase(ProfileId id) {

        return RestService.getInstance().getProfiles()
                .map(new Function<List<DataProfile>, DomainProfile>() {
                    @Override
                    public DomainProfile apply(@NonNull List<DataProfile> dataProfiles) throws Exception {
                        DataProfile dataProfile = dataProfiles.get(0);
                        DomainProfile domainProfile = new DomainProfile();
                        domainProfile.setName(dataProfile.getName());
                        domainProfile.setSurname(dataProfile.getSurname());
                        domainProfile.setAge(dataProfile.getAge());

                        domainProfile.setPatronymic("none");
                        domainProfile.setGender(true);

                        return domainProfile;
                    }
                });
    }
}

/*
new Function<DataProfile, DomainProfile>() {
                    // map modifies data from one class to other
                    @Override
                    public DomainProfile apply(@NonNull DataProfile dataProfile) throws Exception {

                    }
                }
 */