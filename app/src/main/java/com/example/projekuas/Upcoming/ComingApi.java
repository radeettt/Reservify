package com.example.projekuas.Upcoming;

import retrofit2.Call;
import retrofit2.http.GET;
public interface ComingApi {
    @GET("Upcoming.json")
    Call<ComingResponse<ComingItem>> getComing();
}
