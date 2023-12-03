package com.example.projekuas.Ticketing;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projekuas.Payment.PaymentMethods;
import com.example.projekuas.R;

import java.util.HashSet;
import java.util.Set;

public class Seat extends AppCompatActivity {

    private TextView ticketValueTextView;
    private TextView priceValueTextView;
    private TextView totalpriceValueTextView;
    private boolean isFirstClick = true;
    private String lastSeatClicked = "";
    private static final int DOUBLE_CLICK_DELAY = 100; // in milliseconds
    private Set<String> selectedSeats = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seat);

        // Initialize your TextView
        ticketValueTextView = findViewById(R.id.ticket_value);
        priceValueTextView = findViewById(R.id.price_value);
        totalpriceValueTextView = findViewById(R.id.total_price_value);

        // Find and set click listeners for each seat button
        Button seatA1 = findViewById(R.id.seat_a1);
        Button seatA2 = findViewById(R.id.seat_a2);
        Button seatA3 = findViewById(R.id.seat_a3);
        Button seatA4 = findViewById(R.id.seat_a4);

        Button seatB1 = findViewById(R.id.seat_b1);
        Button seatB2 = findViewById(R.id.seat_b2);
        Button seatB3 = findViewById(R.id.seat_b3);
        Button seatB4 = findViewById(R.id.seat_b4);

        Button seatC1 = findViewById(R.id.seat_c1);
        Button seatC2 = findViewById(R.id.seat_c2);
        Button seatC3 = findViewById(R.id.seat_c3);
        Button seatC4 = findViewById(R.id.seat_c4);

        Button seatD1 = findViewById(R.id.seat_d1);
        Button seatD2 = findViewById(R.id.seat_d2);
        Button seatD3 = findViewById(R.id.seat_d3);
        Button seatD4 = findViewById(R.id.seat_d4);

        seatA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSeatButtonClick("A1", seatA1);
            }
        });

        seatA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSeatButtonClick("A2", seatA2);
            }
        });

        seatA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSeatButtonClick("A3", seatA3);
            }
        });

        seatA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSeatButtonClick("A4", seatA4);
            }
        });

        seatB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSeatButtonClick("B1", seatB1);
            }
        });

        seatB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSeatButtonClick("B2", seatB2);
            }
        });

        seatB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSeatButtonClick("B3", seatB3);
            }
        });

        seatB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSeatButtonClick("B4", seatB4);
            }
        });

        seatC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSeatButtonClick("C1", seatC1);
            }
        });

        seatC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSeatButtonClick("C2", seatC2);
            }
        });

        seatC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSeatButtonClick("C3", seatC3);
            }
        });

        seatC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSeatButtonClick("C4", seatC4);
            }
        });

        seatD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSeatButtonClick("D1", seatD1);
            }
        });

        seatD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSeatButtonClick("D2", seatD2);
            }
        });

        seatD3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSeatButtonClick("D3",seatD3);
            }
        });

        seatD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSeatButtonClick("D4", seatD4);
            }
        });

    }

    private void onSeatButtonClick(String seatId, Button seatButton) {
        // Handle double click logic
        if (!isFirstClick && seatId.equals(lastSeatClicked)) {
            // Double click detected
            toggleSeatSelection(seatId);
            isFirstClick = true;
            Log.d("SeatClick", "Double click detected. Toggling seat selection.");
        } else {
            // Single click, update the ticket_value TextView
            toggleSeatSelection(seatId);

            // Set flags for the first click and the last seat clicked
            isFirstClick = false;
            lastSeatClicked = seatId;

            // Set a delayed handler to reset flags after a double-click delay
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    isFirstClick = true;
                    lastSeatClicked = "";
                    Log.d("SeatClick", "Resetting click flags.");
                }
            }, DOUBLE_CLICK_DELAY);
        }

        // Update the price_value TextView and total_price_value TextView
        updatePriceValueTextView();
        updateTotalPriceValueTextView();

        // Change the button color
        changeButtonColor(seatId, seatButton);
    }
    private void toggleSeatSelection(String seatId) {
        // Toggle seat selection logic
        if (selectedSeats.contains(seatId)) {
            // If seat is already selected, remove it
            selectedSeats.remove(seatId);
        } else {
            // If seat is not selected, add it
            selectedSeats.add(seatId);
        }

        // Update the ticket_value TextView based on the selected seats
        updateTicketValueTextView();
    }

    private void updateTicketValueTextView() {
        StringBuilder ticketValue = new StringBuilder();

        for (String seat : selectedSeats) {
            if (ticketValue.length() > 0) {
                ticketValue.append(", ");
            }
            ticketValue.append(seat);
        }

        ticketValueTextView.setText(ticketValue.toString());
        Log.d("SeatClick", "Updating ticket value: " + ticketValue.toString());
    }

    private void updatePriceValueTextView() {
        int totalPrice = selectedSeats.size() * 25000; // Assuming the price is 25000 per seat
        String priceText = "Rp. 25,000 x " + selectedSeats.size();
        priceValueTextView.setText(priceText);
        Log.d("SeatClick", "Updating price value: " + priceText);
    }

    private void updateTotalPriceValueTextView() {
        int totalPrice = selectedSeats.size() * 25000;
        String priceText = "Rp. " + totalPrice;
        totalpriceValueTextView.setText(priceText);
        Log.d("SeatClick", "Updating total price value: " + priceText);
    }
    private void changeButtonColor(String seatId, Button seatButton) {
        ColorStateList defaultColor = ColorStateList.valueOf(Color.parseColor("#6750A4"));
        ColorStateList selectedColor = ColorStateList.valueOf(Color.parseColor("#9266CB"));

        if (selectedSeats.contains(seatId)) {
            // If seat is selected, change the background tint color to #9266CB
            seatButton.setBackgroundTintList(selectedColor);
        } else {
            // If seat is not selected, change the background tint color back to #A5A5A5
            seatButton.setBackgroundTintList(defaultColor);
        }
    }

    public void gotomethods(View view) {
        if (selectedSeats.isEmpty()) {
            // Jika tidak ada kursi yang dipilih, tampilkan notifikasi
            Toast.makeText(this, "Pilih Seat terlebih dahulu", Toast.LENGTH_SHORT).show();
        } else {
            // Jika ada kursi yang dipilih, navigasi ke PaymentMethods.class
            Intent intent = new Intent(this, PaymentMethods.class);

            // Kirim data ke PaymentMethods
            intent.putExtra("selected_seats", selectedSeats.toArray(new String[0]));
            intent.putExtra("ticket_price", calculateTicketPrice()); // Ganti ini dengan logika perhitungan harga tiket

            startActivity(intent);
        }
    }

    private int calculateTicketPrice() {
        return selectedSeats.size() * 25000; // Ganti dengan logika perhitungan harga tiket
    }
    public void backtobuyticket(View view) {
        Intent intent = new Intent(this, BuyTicket.class);
        startActivity(intent);
    }

}
