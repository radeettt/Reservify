package com.example.projekuas.Upcoming;

import android.content.Context;

public class MyComing {
    ComingApi comingApi;
    public MyComing(Context context) {
        comingApi = RetrofitBuilderUp
                .builder(context)
                .create(ComingApi.class);
    }
    public ComingApi getInstance() {return comingApi;}
}
