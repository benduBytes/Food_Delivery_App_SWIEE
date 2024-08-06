package com.example.swiee;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.swiee.adapter.MenuAdapter;
import com.example.swiee.adapter.NotificationAdapter;
import com.example.swiee.databinding.FragmentNotificationBottomBinding;
import com.example.swiee.databinding.FragmentSearchBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;


public class Notification_Bottom_Fragment extends BottomSheetDialogFragment {

    private FragmentNotificationBottomBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificationBottomBinding.inflate(inflater, container, false);

        ArrayList<String> notificationTextView = new ArrayList<>(Arrays.asList("Your order has been Canceled", "Order has been taken by the driver", "Congrats Your Order Placed"));
        ArrayList<Integer> notificationImageView = new ArrayList<>(Arrays.asList(R.drawable.sademoji, R.drawable.icontruck, R.drawable.illustration));
        NotificationAdapter adapter = new NotificationAdapter(notificationTextView, notificationImageView);

        binding.notificationRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.notificationRecyclerView.setAdapter(adapter);


        return binding.getRoot();
    }
}