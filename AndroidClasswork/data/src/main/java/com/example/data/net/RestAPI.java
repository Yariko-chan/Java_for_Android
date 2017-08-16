package com.example.data.net;

import com.example.data.entity.DataModel;
import com.example.data.entity.DataProfile;

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

    @GET("data/profile") //make a GET query to base url with that parameters
    Observable<List<DataProfile>> getProfiles(); // answer in format Observable

    @POST("data/profile")
    Observable<Void> saveProfile(@Body DataProfile profile); // @body - profile will be coverted to json and put into body of post
}
