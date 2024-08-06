package com.example.swiee;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.swiee.Fragment.CartFragment;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Get data from intent
        String menuItemName = getIntent().getStringExtra("MenuItemName");
        int menuImageResource = getIntent().getIntExtra("MenuImage", 0); // Default value 0

        // Initialize views
        TextView itemNameTextView = findViewById(R.id.detailFoodName);
        ImageView menuImageView = findViewById(R.id.detailFoodImage);
        ImageButton backButton = findViewById(R.id.imageButton);
        Button addToCartButton = findViewById(R.id.addToCartButton);

        // Set item name
        itemNameTextView.setText(menuItemName);

        // Set menu image
        if (menuImageResource != 0) {
            menuImageView.setImageResource(menuImageResource);
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        /*
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform fragment transaction to add CartFragment
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerView, new CartFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

         */
    }
}
