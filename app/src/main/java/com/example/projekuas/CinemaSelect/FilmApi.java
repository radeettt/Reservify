package com.example.projekuas.CinemaSelect;
import retrofit2.Call;
import retrofit2.http.GET;
public interface FilmApi {
    @GET("DataMovie.json")
    Call<MovieResponse<MovieItem>> getMovie();
}
