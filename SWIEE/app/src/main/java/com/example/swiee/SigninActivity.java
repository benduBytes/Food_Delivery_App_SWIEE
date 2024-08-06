package com.example.swiee;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.SharedPreferences;

import com.example.swiee.databinding.ActivitySigninBinding;

public class SigninActivity extends AppCompatActivity {

    private ActivitySigninBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySigninBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.alreadyhavebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start LoginActivity when alreadyhavebutton is clicked
                Intent intent = new Intent(SigninActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        binding.createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get entered name, email, and password
                String enteredName = binding.name.getText().toString();
                String enteredEmail = binding.EmailAddress.getText().toString();
                String enteredPassword = binding.Password.getText().toString();

                if (areFieldsFilled(enteredName, enteredEmail, enteredPassword)) {
                    saveCredentials(enteredName, enteredEmail, enteredPassword);
                    // Start ChooseLocationActivity after creating an account
                    Intent intent = new Intent(SigninActivity.this, ChooseLocationActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SigninActivity.this, "Please fill all credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveCredentials(String name, String email, String password) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();
    }

    private boolean areFieldsFilled(String name, String email, String password) {
        return !name.isEmpty() && !email.isEmpty() && !password.isEmpty();
    }
}
