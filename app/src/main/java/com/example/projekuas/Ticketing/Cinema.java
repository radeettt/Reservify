package com.example.projekuas.Ticketing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projekuas.R;
import com.example.projekuas.Setting.Setting;
import com.example.projekuas.Upcoming.Upcoming;

public class Cinema extends AppCompatActivity {

    String[] items = {"JAKARTA", "DEPOK"};

    AutoCompleteTextView autoCompleteTxt;

    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstancState){
        super.onCreate(savedInstancState);
        setContentView(R.layout.activity_cinema);

        autoCompleteTxt = findViewById(R.id.auto_complete_txt);

        adapterItems = new ArrayAdapter<String>(this, R.layout.dropdown_item, items);

        autoCompleteTxt.setAdapter(adapterItems);

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String item = parent.getItemAtPosition(position).toString();

                if (item.equals("JAKARTA")) {
                    // Jika item yang dipilih adalah "JAKARTA", buat Intent untuk Activity baru
                    Intent intent = new Intent(Cinema.this, JakartaActivity.class);
                    startActivity(intent);
                }
                else if (item.equals("DEPOK")) {
                    // Jika item yang dipilih adalah "DEPOK", buat Intent untuk Activity baru
                    Intent intent = new Intent(Cinema.this, DepokActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void goToHome(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void goToSetting(View view) {
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
    }
    public void goToUpcoming(View view) {
        Intent intent = new Intent(this, Upcoming.class);
        startActivity(intent);
    }
}