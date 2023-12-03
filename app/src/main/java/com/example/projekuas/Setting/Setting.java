package com.example.projekuas.Setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projekuas.Login.Login;
import com.example.projekuas.Payment.PurchaseHistory;
import com.example.projekuas.R;
import com.example.projekuas.Ticketing.Cinema;
import com.example.projekuas.Ticketing.Home;
import com.example.projekuas.Upcoming.Upcoming;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        
    }

    public void gotohistory(View view) {
        Intent intent = new Intent(this, PurchaseHistory.class);
        startActivity(intent);
    }

    public void goToHome(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void goToCinema(View view) {
        Intent intent = new Intent(this, Cinema.class);
        startActivity(intent);
    }
    public void goToUpcoming(View view) {
        Intent intent = new Intent(this, Upcoming.class);
        startActivity(intent);
    }
    public void goToLogin(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        Toast.makeText(this, "Anda Berhasil Log Out", Toast.LENGTH_SHORT).show();
    }



}