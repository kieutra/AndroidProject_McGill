package com.teaching.myyelp;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YelpAPI {
    @GET("businesses/search")
    Call<YelpResponse>getUser(@Query("term") String term,
                              @Query("location") String location);


}
