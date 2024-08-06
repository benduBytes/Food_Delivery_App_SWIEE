package com.example.swiee.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swiee.DetailsActivity;
import com.example.swiee.databinding.MenuItemBinding;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private OnClickListener itemClickListener;
    private ArrayList<String> menuItemsName;
    private ArrayList<String> menuPrice;
    private ArrayList<Integer> menuImage;

    private Context requireContext;

    public MenuAdapter(ArrayList<String> menuItems, ArrayList<String> menuPrice, ArrayList<Integer> menuImage, Context requireContext) {
        this.menuItemsName = menuItems;
        this.menuPrice = menuPrice;
        this.menuImage = menuImage;
        this.requireContext = requireContext;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        MenuItemBinding binding = MenuItemBinding.inflate(inflater, parent, false);
        return new MenuViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        String item = menuItemsName.get(position);
        String itemPrice = menuPrice.get(position);
        int imageResource = menuImage.get(position);
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
        return menuItemsName.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        private MenuItemBinding binding;

        public MenuViewHolder(MenuItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String item, String price, int imageResource) {
            binding.menuFoodName.setText(item);
            binding.menuPrice.setText(price);
            binding.menuImage.setImageResource(imageResource);
        }
    }

    public interface OnClickListener {
        void onItemClick(int position);
    }
}
