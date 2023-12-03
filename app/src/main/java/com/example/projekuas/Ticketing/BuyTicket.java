package com.example.projekuas.Ticketing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projekuas.R;

public class BuyTicket extends AppCompatActivity {

    private boolean isSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_ticket);
        Button button = findViewById(R.id.hour_sa);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected = !isSelected;

                if (isSelected) {
                    button.setBackgroundResource(R.drawable.rounded_hover);
                } else {
                    button.setBackgroundResource(R.drawable.rounded);
                }
            }
        });
    }

    public void gotoseat(View view) {
        if (isSelected) {
            // Jika hour_sa sudah dipilih, lakukan navigasi ke Seat.class
            Intent intent = new Intent(this, Seat.class);
            startActivity(intent);
        } else {
            // Jika hour_sa belum dipilih, tampilkan notifikasi
            Toast.makeText(this, "Pilih Jam terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
    }
    public void backtoprevious(View view) {
        onBackPressed();
    }
}
