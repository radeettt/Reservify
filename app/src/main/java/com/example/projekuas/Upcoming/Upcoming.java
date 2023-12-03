package com.example.projekuas.Upcoming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projekuas.Setting.Setting;
import com.example.projekuas.Ticketing.Cinema;
import com.example.projekuas.Ticketing.Home;
import com.example.projekuas.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class Upcoming extends AppCompatActivity{
    MyComing myComing;
    ComingAdapter adapter;
    RecyclerView rv_coming;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
        rv_coming = findViewById(R.id.rv_coming);
        myComing = new MyComing(this);
        rv_coming.setHasFixedSize(true);
        rv_coming.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ComingAdapter(myComing);
        rv_coming.setAdapter(adapter);
        getDataComing();
    }
    public void getDataComing(){
        myComing.getInstance().getComing().enqueue(new Callback<ComingResponse<ComingItem>>() {
            @Override
            public void onResponse(Call<ComingResponse<ComingItem>> call, Response<ComingResponse<ComingItem>>response){
                ComingResponse<ComingItem> resp = response.body();
                if (resp.getResult() != null && resp.getResult().size() > 0){
                    adapter = new ComingAdapter(resp.getResult(), Upcoming.this);
                    rv_coming.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<ComingResponse<ComingItem>> call, Throwable t) {
                Toast.makeText(Upcoming.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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
    public void goToSetting(View view) {
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
    }
}
