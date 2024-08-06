package com.example.swiee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.swiee.databinding.ActivityChooseLocationBinding;

public class ChooseLocationActivity extends AppCompatActivity {

    private ActivityChooseLocationBinding binding;
    private boolean optionSelected = false; // Flag to track if an option is selected

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChooseLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] locationlist = new String[]{"Ernakulam", "Thrissur", "Kozhikode", "Malappuram"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, locationlist);
        binding.listOfLocation.setAdapter(adapter);

        binding.listOfLocation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                optionSelected = true; // Mark the option as selected
                binding.createAccountButton.setEnabled(true); // Enable the button
            }
        });

        binding.createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optionSelected) {
                    Intent intent = new Intent(ChooseLocationActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(ChooseLocationActivity.this, "Please select a location", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
