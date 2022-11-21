package com.example.m_bora.ui.verification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.m_bora.R;
import com.example.m_bora.databinding.FragmentVerificationBinding;
public class verificationFragment extends Fragment {

    private @NonNull FragmentVerificationBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        VerificationViewModel VerificationViewModel  =
                new ViewModelProvider(this).get(VerificationViewModel.class);
        binding = FragmentVerificationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextView textView = root.findViewById(R.id.text_verification);
        VerificationViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}





