package com.example.projekuas.CinemaSelect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projekuas.Setting.Setting;
import com.example.projekuas.Ticketing.BuyTicket;
import com.example.projekuas.Ticketing.Cinema;
import com.example.projekuas.Ticketing.Home;
import com.example.projekuas.R;
import com.example.projekuas.Upcoming.Upcoming;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CinemaSelect extends AppCompatActivity {
    MyMovie myMovie;
    MovieAdapter adapter;
    RecyclerView rv_movie;

    protected void onCreate(Bundle savedInstancState) {
        super.onCreate(savedInstancState);
        setContentView(R.layout.cinemaselect_activity);
        rv_movie = findViewById(R.id.rv_movie);
        myMovie = new MyMovie(this);
        rv_movie.setHasFixedSize(true);
        rv_movie.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MovieAdapter(myMovie);
        rv_movie.setAdapter(adapter);
        getDataMovie();
    }
        public void getDataMovie(){
        myMovie.getInstance().getMovie().enqueue(new Callback<MovieResponse<MovieItem>>() {
            @Override
            public void onResponse(Call<MovieResponse<MovieItem>> call, Response<MovieResponse<MovieItem>>response){
                MovieResponse<MovieItem> resp = response.body();
                if (resp.getResult() != null && resp.getResult().size() > 0){
                    adapter = new MovieAdapter(resp.getResult(),CinemaSelect.this);
                    rv_movie.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<MovieResponse<MovieItem>> call, Throwable t) {
                Toast.makeText(CinemaSelect.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        }
    public void goToCinema(View view) {
        Intent intent = new Intent(this, Cinema.class);
        startActivity(intent);
    }
    public void goToHome(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    public void goToUpcoming(View view) {
        Intent intent = new Intent(this, Upcoming.class);
        startActivity(intent);
    }
    public void goToSetting(View view) {
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
    }
    public void gotobuyticket(View view) {
        Intent intent = new Intent(this, BuyTicket.class);
        startActivity(intent);
    }
}