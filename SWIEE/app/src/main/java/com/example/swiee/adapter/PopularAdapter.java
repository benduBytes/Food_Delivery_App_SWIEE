// PopularAdapter.java

package com.example.swiee.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swiee.DetailsActivity;
import com.example.swiee.databinding.PopulerItemBinding;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {

    private ArrayList<String> items;
    private ArrayList<String> price;
    private ArrayList<Integer> image;
    private Context requireContext;

    public PopularAdapter(ArrayList<String> items, ArrayList<String> price, ArrayList<Integer> image, Context requireContext) {
        this.items = items;
        this.price = price;
        this.image = image;
        this.requireContext = requireContext;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PopulerItemBinding binding = PopulerItemBinding.inflate(inflater, parent, false);
        return new PopularViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {
        String item = items.get(position);
        String itemPrice = price.get(position);
        int imageResource = image.get(position);
        holder.bind(item, itemPrice, imageResource);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext, DetailsActivity.class);
                intent.putExtra("MenuItemName", item);
                intent.putExtra("MenuImage", imageResource);
                requireContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class PopularViewHolder extends RecyclerView.ViewHolder {
        private PopulerItemBinding binding;

        public PopularViewHolder(@NonNull PopulerItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String item, String price, int imageResource) {
            binding.foodNamePopuler.setText(item);
            binding.PricePopuler.setText(price);
            binding.imageView5.setImageResource(imageResource);
        }
    }
}
