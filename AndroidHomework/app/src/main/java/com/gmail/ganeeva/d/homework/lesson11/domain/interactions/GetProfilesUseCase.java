package com.gmail.ganeeva.d.homework.lesson11.domain.interactions;

import com.gmail.ganeeva.d.homework.lesson11.data.DataProfile;
import com.gmail.ganeeva.d.homework.lesson11.data.net.RestService;
import com.gmail.ganeeva.d.homework.lesson11.domain.entity.DomainProfile;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Diana on 11.08.2017.
 */

public class GetProfilesUseCase extends UseCase<String, List<DomainProfile>> {
    @Override
    public Observable<List<DomainProfile>> buildUseCase(String id) {

        return RestService.getInstance().getProfiles()
                .map(new Function<List<DataProfile>, List<DomainProfile>>() {
                    @Override
                    public List<DomainProfile> apply(@NonNull List<DataProfile> dataProfiles) throws Exception {
                        List<DomainProfile> domainProfiles = new ArrayList<DomainProfile>(dataProfiles.size());
                        for (DataProfile profile:dataProfiles) {
                            domainProfiles.add(convert(profile));
                        }
                        return domainProfiles;
                    }
                });
    }

    public static DomainProfile convert(DataProfile dataProfile) {
        DomainProfile domainProfile = new DomainProfile();
        domainProfile.setName(dataProfile.getName());
        domainProfile.setSurname(dataProfile.getSurname());
        domainProfile.setAge(dataProfile.getAge());
        domainProfile.setId(dataProfile.getId());
        return domainProfile;
    }
}