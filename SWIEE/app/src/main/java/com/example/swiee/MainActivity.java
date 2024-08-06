package com.example.swiee;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.swiee.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.swiee.Notification_Bottom_Fragment;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);

        // Connect the bottom navigation view with the NavController
        NavigationUI.setupWithNavController(bottomNav, navController);

        binding.notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification_Bottom_Fragment bottomSheetDialog = new Notification_Bottom_Fragment();
                bottomSheetDialog.show(getSupportFragmentManager(), "Test");
            }
        });
    }


}
