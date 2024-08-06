package com.example.swiee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.swiee.databinding.ActivityPayOutBinding;
import com.example.swiee.databinding.FragmentCongratsBottomSheetBinding;

public class PayOutActivity extends AppCompatActivity {

    private ActivityPayOutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityPayOutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.PlaceMyOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CongratsBottomSheet bottomSheetDialog = new CongratsBottomSheet();
                bottomSheetDialog.show(getSupportFragmentManager(), "Test");
            }
        });

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Dismiss the bottom sheet
            }
        });

    }
}