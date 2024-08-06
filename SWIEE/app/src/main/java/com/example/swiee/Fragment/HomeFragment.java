// HomeFragment.java

package com.example.swiee.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.swiee.MenuBottomSheetFragment;
import com.example.swiee.R;
import com.example.swiee.adapter.PopularAdapter;
import com.example.swiee.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        binding.viewAllmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuBottomSheetFragment bottomSheetDialog = new MenuBottomSheetFragment();
                bottomSheetDialog.show(getParentFragmentManager(), bottomSheetDialog.getTag());
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner3, ScaleTypes.FIT));

        ImageSlider imageSlider = binding.imageSlider;
        imageSlider.setImageList(imageList);
        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void doubleClick(int i) {
                // Handle double click
            }

            @Override
            public void onItemSelected(int position) {
                SlideModel selectedItem = imageList.get(position);
                String itemMessage = "Selected Image " + position;
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show();
            }
        });

        ArrayList<String> foodName = new ArrayList<>(Arrays.asList("Burger", "sandwich", "momo", "item"));
        ArrayList<String> price = new ArrayList<>(Arrays.asList("₹5", "₹7", "₹8", "₹10"));
        ArrayList<Integer> popularFoodImages = new ArrayList<>(Arrays.asList(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3, R.drawable.menu4));
        PopularAdapter adapter = new PopularAdapter(foodName, price, popularFoodImages, requireContext());
        binding.PopulerRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.PopulerRecyclerView.setAdapter(adapter);
    }
}
