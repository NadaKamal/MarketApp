package com.example.market.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.market.databinding.FragmentAboutAppBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link aboutAppFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class aboutAppFragment extends Fragment {

 FragmentAboutAppBinding binding;
    public aboutAppFragment() {
        // Required empty public constructor
    }


    public static aboutAppFragment newInstance() {
        aboutAppFragment fragment = new aboutAppFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAboutAppBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.aboutUsWebView.getSettings().setJavaScriptEnabled(true);
        binding.aboutUsWebView.loadUrl("https://www.google.com");
    }
}