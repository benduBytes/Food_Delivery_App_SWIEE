package com.example.swiee.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swiee.databinding.BuyAgainItemBinding;
import com.example.swiee.databinding.PopulerItemBinding;

import java.util.ArrayList;

public class BuyAgainAdapter extends RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder> {

    private ArrayList<String> buyAgainFoodName;
    private ArrayList<String> buyAgainFoodPrice;
    private ArrayList<Integer> buyAgainFoodImage;

    public BuyAgainAdapter(ArrayList<String> buyAgainFoodName, ArrayList<String> buyAgainFoodPrice, ArrayList<Integer> buyAgainFoodImage) {
        this.buyAgainFoodName = (ArrayList<String>) buyAgainFoodName;
        this.buyAgainFoodPrice = (ArrayList<String>) buyAgainFoodPrice;
        this.buyAgainFoodImage = (ArrayList<Integer>) buyAgainFoodImage;
    }


    public BuyAgainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        BuyAgainItemBinding binding = BuyAgainItemBinding.inflate(inflater, parent, false);
        return new BuyAgainViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull BuyAgainViewHolder holder, int position) {
        String item = buyAgainFoodName.get(position);
        String itemPrice = buyAgainFoodPrice.get(position);
        int imageResource = buyAgainFoodImage.get(position);
        holder.bind(item, itemPrice, imageResource);
    }

    @Override
    public int getItemCount() {
        return buyAgainFoodName.size();
    }

    public class BuyAgainViewHolder extends RecyclerView.ViewHolder {

        private BuyAgainItemBinding binding;

        public BuyAgainViewHolder(BuyAgainItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String item, String price, int imageResourse) {
            binding.buyAgainFoodName.setText(item);
            binding.buyAgainFoodPrice.setText(price);
            binding.buyAgainFoodImage.setImageResource(imageResourse);
        }

    }
}
