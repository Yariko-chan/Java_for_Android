package com.example.domain.interactions;

import com.example.domain.entity.Profile;
import com.example.domain.entity.ProfileId;
import com.example.domain.interactions.base.UseCase;

/**
 * Created by Diana on 11.08.2017.
 */

public class ProfileUseCase extends UseCase<ProfileId, Profile> {
    @Override
    public Profile buildUseCase() {

        Profile profile = new Profile();
        profile.setName("Name");
        profile.setSurname("Surname");
        profile.setPatronymic("Patronymic");
        profile.setAge(20);
        profile.setGender(true);

        return profile;
    }
}
