package com.example.domain.interactions;

import com.example.data.entity.DataProfile;
import com.example.data.net.RestService;
import com.example.domain.entity.DomainProfile;
import com.example.domain.entity.ProfileId;
import com.example.domain.interactions.base.UseCase;

import io.reactivex.Observable;

/**
 * Created by Diana on 16.08.2017.
 */

public class SaveProfileUseCase extends UseCase<DomainProfile, Void> {
    @Override
    public Observable<Void> buildUseCase(DomainProfile profile) {

        DataProfile dataProfile = new DataProfile();
        dataProfile.setName(profile.getName());
        dataProfile.setSurname(profile.getSurname());
        dataProfile.setAge(profile.getAge());

        return RestService.getInstance().saveProfile(dataProfile);
    }
}
