package com.example.domain.interactions

import com.example.data.entity.DataProfile
import com.example.data.net.RestService
import com.example.domain.entity.DomainProfile
import com.example.domain.interactions.base.UseCase

import java.util.ArrayList

import io.reactivex.Observable
import io.reactivex.annotations.NonNull
import io.reactivex.functions.Function

/**
 * Created by Diana on 18.08.2017.
 */

class Lesson12GetProfilesUseCase : UseCase<Void, List<DomainProfile>>() {
    override fun buildUseCase(param: Void?): Observable<List<DomainProfile>> {
        return RestService.getInstance()
                .profiles
                .map {
                    it.map{convert(it)}
                }
    }

    private fun convert(dataProfile: DataProfile) : DomainProfile {
        val domainProfile = DomainProfile();
        domainProfile.name = dataProfile.name;
        domainProfile.surname = dataProfile.surname;
        domainProfile.age = dataProfile.age;
        return domainProfile
    }
}
