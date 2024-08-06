package com.example.swiee.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.swiee.R;
import com.example.swiee.adapter.BuyAgainAdapter;
import com.example.swiee.databinding.BuyAgainItemBinding;
import com.example.swiee.databinding.FragmentHistoryBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class HistoryFragment extends Fragment {

    private FragmentHistoryBinding binding;
    private BuyAgainAdapter buyAgainAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        ArrayList<String> buyAgainFoodName = new ArrayList<>(Arrays.asList("Burger", "sandwich", "momo", "item"));
        ArrayList<String> buyAgainFoodPrice = new ArrayList<>(Arrays.asList("₹5", "₹7", "₹8", "₹10"));
        ArrayList<Integer> buyAgainFoodImages = new ArrayList<>(Arrays.asList(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3, R.drawable.menu4));

        buyAgainAdapter = new BuyAgainAdapter(buyAgainFoodName, buyAgainFoodPrice, buyAgainFoodImages);
        binding.BuyAgainRecyclerView.setAdapter(buyAgainAdapter);
        binding.BuyAgainRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }
}
