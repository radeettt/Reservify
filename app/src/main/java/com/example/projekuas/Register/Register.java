package com.example.projekuas.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projekuas.Login.Login;
import com.example.projekuas.R;
import com.example.projekuas.Register.db.databases;

public class Register extends AppCompatActivity {
    private databases database;
    private EditText etUsername, etFullname, etEmail, etPassword, etConfirmPassword;
    private Button btnRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        database = new databases(this);

        etUsername = findViewById(R.id.NewUsername);
        etFullname = findViewById(R.id.NewFullName);
        etEmail = findViewById(R.id.NewEmail);
        etPassword = findViewById(R.id.NewPassword);
        etConfirmPassword = findViewById(R.id.ConfirmPassword); // New EditText for confirm password

        // Set password and confirm password fields to use PasswordTransformationMethod
        etPassword.setTransformationMethod(new PasswordTransformationMethod());
        etConfirmPassword.setTransformationMethod(new PasswordTransformationMethod());

        btnRegist = findViewById(R.id.buttonSignUp);

        btnRegist.setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            String fullname = etFullname.getText().toString();
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            String confirmPassword = etConfirmPassword.getText().toString();

            if (username.isEmpty() || fullname.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(Register.this, "Error: Harus diisi!", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPassword)) {
                Toast.makeText(Register.this, "Error: Password tidak sesuai.", Toast.LENGTH_SHORT).show();
            } else {
                database.addUserDetail(username, fullname, email, password);
                etUsername.setText("");
                etFullname.setText("");
                etEmail.setText("");
                etPassword.setText("");
                etConfirmPassword.setText("");
                Toast.makeText(Register.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void goToLoginBack(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void goToLoginAfterSign(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
