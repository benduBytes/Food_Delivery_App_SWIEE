package com.example.swiee.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swiee.DetailsActivity;
import com.example.swiee.databinding.CartItemBinding;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private int[] itemQuantities;
    private ArrayList<String> cartitems;
    private ArrayList<String> cartitemprice;
    private ArrayList<Integer> cartimage;

    private Context requireContext;

    /*
    public void updateItemQuantity(int position, int quantity) {
        itemQuantities[position] = quantity;
        notifyDataSetChanged();
    }

     */

    public CartAdapter(ArrayList<String> items, ArrayList<String> price, ArrayList<Integer> image, Context requireContext) {
        this.cartitems = items;
        this.cartitemprice = price;
        this.cartimage = image;
        this.itemQuantities = new int[cartitems.size()]; // Initialize the itemQuantities array

        // Initialize the itemQuantities array with default value 1
        for (int i = 0; i < itemQuantities.length; i++) {
            itemQuantities[i] = 1;
        }
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CartItemBinding binding = CartItemBinding.inflate(inflater, parent, false);
        return new CartViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        String item = cartitems.get(position);
        String itemPrice = cartitemprice.get(position);
        int imageResource = cartimage.get(position);
        int quantity = itemQuantities[position];
        holder.bind(item, itemPrice, imageResource, quantity, position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context requireContext = v.getContext(); // Get context from the clicked view
                Intent intent = new Intent(requireContext, DetailsActivity.class);
                intent.putExtra("MenuItemName", item);
                intent.putExtra("MenuImage", imageResource);
                requireContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartitems.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        private CartItemBinding binding;

        public CartViewHolder(CartItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String item, String price, int imageResource, int quantity, int position) {
            binding.cartFoodName.setText(item);
            binding.CartItemPrice.setText(price);
            binding.cartimage.setImageResource(imageResource);
            binding.cartItemquantity.setText(String.valueOf(quantity));

            binding.minusbutton.setOnClickListener(view -> {
                decreaseQuantity(position);
            });

            binding.plusebutton.setOnClickListener(view -> {
                increaseQuantity(position);
            });

            binding.deleteButton.setOnClickListener(view -> {
                deleteItem(position);
            });
        }

        private void decreaseQuantity(int position) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--;
                binding.cartItemquantity.setText(String.valueOf(itemQuantities[position]));
            }
        }

        private void increaseQuantity(int position) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++;
                binding.cartItemquantity.setText(String.valueOf(itemQuantities[position]));
            }
        }

        private void deleteItem(int position) {
            if (position >= 0 && position < cartitems.size()) {
                cartitems.remove(position);
                cartimage.remove(position);
                cartitemprice.remove(position);
                // Update the itemQuantities array by removing the quantity at the deleted position
                int[] updatedQuantities = new int[cartitems.size()];
                for (int i = 0; i < cartitems.size(); i++) {
                    // If the current index is greater than or equal to the deleted position,
                    // we need to skip the quantity at that position in the itemQuantities array
                    updatedQuantities[i] = itemQuantities[i + (i >= position ? 1 : 0)]; // Skip the deleted item's quantity
                }
                itemQuantities = updatedQuantities;
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, cartitems.size() - position);
            }
        }
        /*
        private int[] updateQuantitiesArray() {
            int[] updatedQuantities = new int[cartitems.size()];
            for (int i = 0; i < cartitems.size(); i++) {
                updatedQuantities[i] = itemQuantities[i];
            }
            return updatedQuantities;
        }

         */
    }
}
