package com.example.swiee.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swiee.databinding.CartItemBinding;
import com.example.swiee.databinding.NotificationItemBinding;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private ArrayList<String> notification;
    private ArrayList<Integer> notificationImage;

    public NotificationAdapter(ArrayList<String> notification, ArrayList<Integer> notificationImage) {
        this.notification = notification;
        this.notificationImage = notificationImage;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        NotificationItemBinding binding = NotificationItemBinding.inflate(inflater, parent, false);
        return new NotificationViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        String item = notification.get(position);
        int imageResource = notificationImage.get(position);
        holder.bind(item, imageResource);
    }

    @Override
    public int getItemCount() {
        return notification.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {

        private NotificationItemBinding binding;

        public NotificationViewHolder(NotificationItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String item, int imageResource) {
            binding.notificationTextView.setText(item);
            binding.notificationImageView.setImageResource(imageResource);
        }
    }
}
