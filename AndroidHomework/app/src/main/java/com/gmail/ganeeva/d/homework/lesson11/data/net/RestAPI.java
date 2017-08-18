package com.gmail.ganeeva.d.homework.lesson11.data.net;

import com.gmail.ganeeva.d.homework.lesson11.data.DataProfile;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Diana on 16.08.2017.
 */

public interface RestAPI {

    @GET("data/profile")
    Observable<List<DataProfile>> getProfiles();

    @GET("data/profile/{id}")
    Observable<DataProfile> getProfile(@Path("id") Integer id);

    @POST("data/profile")
    Observable<Void> saveProfile(@Body DataProfile profile); // @body - profile will be coverted to json and put into body of post
}
