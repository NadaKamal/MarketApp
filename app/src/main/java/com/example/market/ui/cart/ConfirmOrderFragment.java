package com.example.market.ui.cart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.market.R;
import com.example.market.databinding.FragmentConfirmOrderBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConfirmOrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConfirmOrderFragment extends Fragment {

    FragmentConfirmOrderBinding binding;

    public ConfirmOrderFragment() {
        // Required empty public constructor
    }

    public static ConfirmOrderFragment newInstance() {
        ConfirmOrderFragment fragment = new ConfirmOrderFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentConfirmOrderBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartFragment.setReachedStep(2);

                getActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.cart_container_fragment, new AddressToDeliverFragment(), null)
                        .commit();
            }
        });
    }
}