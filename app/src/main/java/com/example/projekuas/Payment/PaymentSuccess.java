package com.example.projekuas.Payment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projekuas.R;
import com.example.projekuas.Setting.Setting;

public class PaymentSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_success);

        // Delay navigasi ke Setting.java selama 5 detik
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(PaymentSuccess.this, Setting.class);
                startActivity(intent);
                finish();
            }
        }, 2500); // 5000 milliseconds = 5 detik
    }
}
