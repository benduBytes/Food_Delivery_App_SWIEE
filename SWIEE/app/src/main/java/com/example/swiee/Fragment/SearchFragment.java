package com.example.swiee.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.swiee.R;
import com.example.swiee.adapter.MenuAdapter;
import com.example.swiee.databinding.FragmentSearchBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchFragment extends Fragment implements MenuAdapter.OnClickListener {

    private FragmentSearchBinding binding;
    private MenuAdapter adapter;

    private ArrayList<String> originalMenuFoodName = new ArrayList<>(Arrays.asList("Burger", "sandwich", "momo", "item","Burger", "sandwich", "momo", "item"));
    private ArrayList<String> originalMenuItemPrice = new ArrayList<>(Arrays.asList("₹5", "₹7", "₹8", "₹10","₹5", "₹7", "₹8", "₹10"));
    private ArrayList<Integer> originalMenuImage = new ArrayList<>(Arrays.asList(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3, R.drawable.menu4,R.drawable.menu1, R.drawable.menu2, R.drawable.menu3, R.drawable.menu4));

    private ArrayList<String> filterMenuFoodName = new ArrayList<>();
    private ArrayList<String> filterMenuItemPrice = new ArrayList<>();
    private ArrayList<Integer> filterMenuImage = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater, container, false);

        adapter = new MenuAdapter(filterMenuFoodName, filterMenuItemPrice, filterMenuImage, requireContext());
        binding.menuRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.menuRecyclerView.setAdapter(adapter);

        // Set up search view
        setupSearchView();

        // Show all menu items
        showAllMenu();

        return binding.getRoot();
    }

    private void setupSearchView() {
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterMenuItems(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterMenuItems(newText);
                return true;
            }
        });
    }

    private void filterMenuItems(String query) {
        filterMenuFoodName.clear();
        filterMenuItemPrice.clear();
        filterMenuImage.clear();

        for (int index = 0; index < originalMenuFoodName.size(); index++) {
            String foodName = originalMenuFoodName.get(index);
            if (foodName.toLowerCase().contains(query.toLowerCase())) {
                filterMenuFoodName.add(foodName);
                filterMenuItemPrice.add(originalMenuItemPrice.get(index));
                filterMenuImage.add(originalMenuImage.get(index));
            }
        }

        adapter.notifyDataSetChanged();
    }

    private void showAllMenu() {
        filterMenuFoodName.addAll(originalMenuFoodName);
        filterMenuItemPrice.addAll(originalMenuItemPrice);
        filterMenuImage.addAll(originalMenuImage);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        // Handle item click here, if needed
    }
}
