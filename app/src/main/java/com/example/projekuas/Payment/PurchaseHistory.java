package com.example.projekuas.Payment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projekuas.R;
import com.example.projekuas.Setting.Setting;

public class PurchaseHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_history);
    }
    public void backtosetting(View view) {
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
    }

    public void gotoreceipt(View view) {
        Intent intent = new Intent(this, TransactionReceipt.class);
        startActivity(intent);
    }
}