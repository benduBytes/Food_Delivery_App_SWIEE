package com.example.swiee;

import android.content.SharedPreferences;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.swiee.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;


    private static final String PREF_NAME_KEY = "name";
    private static final String PREF_EMAIL_KEY = "email";
    private static final String PREF_PASSWORD_KEY = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Button loginButton = binding.createAccountButton;
        binding.createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get entered email and password
                String enteredEmail = binding.EmailAddress.getText().toString();
                String enteredPassword = binding.Password.getText().toString();

                // Get stored credentials from SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                String storedEmail = sharedPreferences.getString(PREF_EMAIL_KEY, "");
                String storedPassword = sharedPreferences.getString(PREF_PASSWORD_KEY, "");

                // Check if the entered credentials match the stored ones
                if (enteredEmail.equals(storedEmail) && enteredPassword.equals(storedPassword)) {
                    // Start MainActivity when login is successful
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    //finish();
                    startActivity(intent);
                } else {
                    // Show a toast message for invalid credentials
                    Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        TextView dontHaveButton = binding.alreadyhavebutton;
        dontHaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start SigninActivity when donthavebutton is clicked
                Intent intent = new Intent(LoginActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });

        // Call the method to check stored credentials
        //checkStoredCredentials();
    }

    /*
    private void checkStoredCredentials() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String storedEmail = sharedPreferences.getString("email", "");
        String storedPassword = sharedPreferences.getString("password", "");

        // Perform login authentication using storedEmail and storedPassword
        // Here, you can compare the stored credentials with the entered ones
    }
    */

}


