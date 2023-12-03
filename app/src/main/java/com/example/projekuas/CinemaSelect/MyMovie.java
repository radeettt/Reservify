package com.example.projekuas.CinemaSelect;

import android.content.Context;

public class MyMovie {
    FilmApi filmApi;
    public MyMovie(Context context) {
        filmApi = RetrofitBuilder
                .builder(context)
                .create(FilmApi.class);
    }
    public FilmApi getInstance() {return filmApi;}
}
