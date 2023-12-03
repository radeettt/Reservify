package com.example.projekuas.Payment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projekuas.R;

public class TransactionReceipt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaction_receipt);
    }
    public void backtohistory(View view) {
        Intent intent = new Intent(this, PurchaseHistory.class);
        startActivity(intent);
    }
}