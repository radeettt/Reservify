package com.example.projekuas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.example.projekuas.Login.Login;
import com.example.projekuas.Register.Register;

public class Splash extends AppCompatActivity {
    private int waktu_loading=3000;

    //4000=4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent home=new Intent(Splash.this, Login.class);
                startActivity(home);
                finish();
            }
        },waktu_loading);

        ImageView imageView = findViewById(R.id.gif_image);

        Glide.with(this)
                .load(R.drawable.progress_bar)
                .into(imageView);
    }
}