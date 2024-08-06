package com.example.swiee.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.swiee.PayOutActivity;
import com.example.swiee.R;
import com.example.swiee.adapter.CartAdapter;
import com.example.swiee.databinding.FragmentCartBinding;

import java.util.ArrayList;
import java.util.Arrays;


public class CartFragment extends Fragment {

    private FragmentCartBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<String> cartFoodName = new ArrayList<>(Arrays.asList("Burger", "sandwich", "momo", "item", "sandwich", "momo"));
        ArrayList<String> CartItemPrice = new ArrayList<>(Arrays.asList("₹5", "₹7", "₹8", "₹10", "₹9", "₹10"));
        ArrayList<Integer> cartimage = new ArrayList<>(Arrays.asList(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3, R.drawable.menu4, R.drawable.menu5, R.drawable.menu6));

        CartAdapter adapter = new CartAdapter(cartFoodName, CartItemPrice, cartimage ,requireContext());
        binding.cartRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.cartRecyclerView.setAdapter(adapter);

        binding.proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), PayOutActivity.class);
                startActivity(intent);
            }
        });

    }

}



