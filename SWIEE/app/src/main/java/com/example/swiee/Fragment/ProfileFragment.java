package com.example.swiee.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.swiee.R;

public class ProfileFragment extends Fragment {

    private static final String PREF_NAME_KEY = "name";
    private static final String PREF_ADDRESS_KEY = "address";
    private static final String PREF_EMAIL_KEY = "email";
    private static final String PREF_PHONE_KEY = "phone";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        EditText nameEditText = rootView.findViewById(R.id.nameEditText);
        EditText addressEditText = rootView.findViewById(R.id.addressEditText);
        EditText emailEditText = rootView.findViewById(R.id.emailEditText);
        EditText phoneEditText = rootView.findViewById(R.id.phoneEditText);

        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", requireContext().MODE_PRIVATE);
        nameEditText.setText(sharedPreferences.getString(PREF_NAME_KEY, ""));
        addressEditText.setText(sharedPreferences.getString(PREF_ADDRESS_KEY, ""));
        emailEditText.setText(sharedPreferences.getString(PREF_EMAIL_KEY, ""));
        phoneEditText.setText(sharedPreferences.getString(PREF_PHONE_KEY, ""));

        Button saveButton = rootView.findViewById(R.id.button2);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(PREF_NAME_KEY, nameEditText.getText().toString());
                editor.putString(PREF_ADDRESS_KEY, addressEditText.getText().toString());
                editor.putString(PREF_EMAIL_KEY, emailEditText.getText().toString());
                editor.putString(PREF_PHONE_KEY, phoneEditText.getText().toString());
                editor.apply();
            }
        });

        return rootView;
    }
}
