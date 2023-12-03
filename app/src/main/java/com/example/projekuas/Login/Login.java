package com.example.projekuas.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projekuas.Ticketing.Home;
import com.example.projekuas.R;
import com.example.projekuas.Register.Register;
import com.example.projekuas.Register.db.databases;

public class Login extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private databases database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.editTextUsername);
        etPassword = findViewById(R.id.editTextPassword);
        database = new databases(this);
    }

    public void goToHomeScreen(View view) {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if (database.checkLogin(username, password)) {
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }

    public void goToRegister(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}
