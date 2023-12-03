package com.example.projekuas.Payment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projekuas.R;
import com.example.projekuas.Ticketing.Seat;

public class PaymentMethods extends AppCompatActivity {
    private TextView ticketsTextView;
    private TextView priceTextView;
    private TextView totalPriceTextView;
    private ImageButton imageButtonDana;
    private ImageButton btnBuyTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_methods);

        // Inisialisasi TextViews
        ticketsTextView = findViewById(R.id.tickets);
        priceTextView = findViewById(R.id.price);
        totalPriceTextView = findViewById(R.id.total);

        // Terima data dari Seat.java
        Intent intent = getIntent();
        if (intent != null) {
            String[] selectedSeats = intent.getStringArrayExtra("selected_seats");
            int ticketPrice = intent.getIntExtra("ticket_price", 0);

            // Perbarui TextViews dengan data yang diterima
            if (selectedSeats != null) {
                StringBuilder ticketValue = new StringBuilder();
                for (String seat : selectedSeats) {
                    if (ticketValue.length() > 0) {
                        ticketValue.append(", ");
                    }
                    ticketValue.append(seat);
                }
                ticketsTextView.setText("        " + ticketValue.toString());
            }

            int amount = selectedSeats.length;
            String priceText = "        Rp. 25.000 x " + amount;
            priceTextView.setText(priceText);

            String totalPriceText = "        Rp. " + ticketPrice; // Ganti dengan logika perhitungan total harga
            totalPriceTextView.setText(totalPriceText);
        }

        // Inisialisasi ImageButton
        imageButtonDana = findViewById(R.id.imageButtonDana);
        btnBuyTicket = findViewById(R.id.btn_buyticket);

        // Set onClickListener pada tombol "Purchase"
        btnBuyTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Periksa apakah salah satu metode pembayaran telah dipilih
                if (!imageButtonDana.isSelected()) {
                    Toast.makeText(PaymentMethods.this, "Pilih Metode Pembayaran Terlebih Dahulu", Toast.LENGTH_SHORT).show();
                } else {
                    proceedToPayment();
                }
            }
        });

        // Set onClickListener untuk setiap ImageButton
        imageButtonDana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleImageButtonSelection(imageButtonDana);
            }
        });
    }

    private void toggleImageButtonSelection(ImageButton imageButton) {
        imageButton.setSelected(!imageButton.isSelected());
    }

    private void proceedToPayment() {
        Intent intent = new Intent(this, PaymentSuccess.class);
        startActivity(intent);
    }

    public void paymentsuccess(View view) {
    }

    public void backtoseat(View view) {
        Intent intent = new Intent(this, Seat.class);
        startActivity(intent);
    }
}
