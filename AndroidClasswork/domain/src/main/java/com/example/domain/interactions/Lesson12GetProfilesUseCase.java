package com.example.domain.interactions;

import com.example.data.entity.DataProfile;
import com.example.data.net.RestService;
import com.example.domain.entity.DomainProfile;
import com.example.domain.entity.ProfileId;
import com.example.domain.interactions.base.UseCase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Diana on 19.08.2017 at 12:22.
 */

public class Lesson12GetProfilesUseCase extends UseCase<ProfileId, List<DomainProfile>> {

    @Override
    public Observable<List<DomainProfile>> buildUseCase(ProfileId param) {
        return RestService.getInstance().getProfiles().map(new Function<List<DataProfile>, List<DomainProfile>>() {
            @Override
            public List<DomainProfile> apply(@NonNull List<DataProfile> profiles) throws Exception {
                List<DomainProfile> list = new ArrayList<>();
                for(DataProfile profile: profiles) {
                    list.add(convert(profile));
                }
                return list;
            }
        });

    }

    private DomainProfile convert(DataProfile dataModel) {
        DomainProfile profileModel = new DomainProfile();
        profileModel.setName(dataModel.getName());
        profileModel.setSurname(dataModel.getSurname());
        profileModel.setAge(dataModel.getAge());
        return profileModel;
    }
}
