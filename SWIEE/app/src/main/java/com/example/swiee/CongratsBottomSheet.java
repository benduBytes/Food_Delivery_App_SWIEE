package com.example.swiee;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.swiee.databinding.FragmentCongratsBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class CongratsBottomSheet extends BottomSheetDialogFragment {

    private FragmentCongratsBottomSheetBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCongratsBottomSheetBinding.inflate(getLayoutInflater(),container,false);
        binding.goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(requireContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        return binding.getRoot();
    }
}