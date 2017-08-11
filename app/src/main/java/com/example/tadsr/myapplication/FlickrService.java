package com.example.tadsr.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrService {

    @GET("services/rest/")
    Call<RecentPhotosResponse> recentPhotos(@Query("method") String method, @Query("api_key") String apiKey,
                                            @Query("format") String format,
                                            @Query("extras") String extra,
                                            @Query("nojsoncallback") Boolean noCallback);
}
