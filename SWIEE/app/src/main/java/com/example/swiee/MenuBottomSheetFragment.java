package com.example.swiee;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.swiee.adapter.MenuAdapter;
import com.example.swiee.databinding.FragmentMenuBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuBottomSheetFragment extends BottomSheetDialogFragment implements MenuAdapter.OnClickListener {

    private FragmentMenuBottomSheetBinding binding;

    ArrayList<String> menuFoodName = new ArrayList<>(Arrays.asList("Burger", "sandwich", "momo", "item", "sandwich", "momo"));
    ArrayList<String> menuPrice = new ArrayList<>(Arrays.asList("₹5", "₹7", "₹8", "₹10", "₹9", "₹10"));
    ArrayList<Integer> menuFoodImages = new ArrayList<>(Arrays.asList(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3, R.drawable.menu4, R.drawable.menu5, R.drawable.menu6));

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false);

        MenuAdapter adapter = new MenuAdapter(menuFoodName, menuPrice, menuFoodImages, requireContext());
        binding.menuRecyclerVIew.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.menuRecyclerVIew.setAdapter(adapter);

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(); // Dismiss the bottom sheet
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onItemClick(int position) {
        String clickedItemName = menuFoodName.get(position);
        int clickedItemImage = menuFoodImages.get(position);

        Intent intent = new Intent(requireContext(), DetailsActivity.class);
        intent.putExtra("MenuItemName", clickedItemName);
        intent.putExtra("MenuImage", clickedItemImage);
        startActivity(intent);
    }


}