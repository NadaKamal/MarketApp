package com.example.market.ui.cart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.market.Adapters.AddressAdapter;
import com.example.market.Model.AddressModel;
import com.example.market.R;
import com.example.market.databinding.FragmentAddressToDeliverBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddressToDeliverFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddressToDeliverFragment extends Fragment implements AddressAdapter.onClickItemListener{

    FragmentAddressToDeliverBinding binding;
    ArrayList<AddressModel> addressModelArrayList = new ArrayList<>();

    public AddressToDeliverFragment() {
        // Required empty public constructor
    }

    public static AddressToDeliverFragment newInstance() {
        AddressToDeliverFragment fragment = new AddressToDeliverFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAddressToDeliverBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return  view;
       // return inflater.inflate(R.layout.fragment_address_to_deliver, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        boolean isFromSetting;
        if(getArguments() != null) {
            isFromSetting = getArguments().getBoolean("isFromSetting");
            if (isFromSetting) {
                binding.btnNext.setVisibility(View.GONE);
                binding.btnBack.setVisibility(View.GONE);
            }
        }
        Navigation.findNavController(view);
        addressModelArrayList.add(new AddressModel(getActivity().getResources().getString(R.string.address_to_deliver),
                getActivity().getResources().getString(R.string.governorate)));
        AddressAdapter addressAdapter= new AddressAdapter(addressModelArrayList,this,getActivity());
        binding.recyclerAddresses.setAdapter(addressAdapter);


        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartFragment.setReachedStep(3);
                getActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.cart_container_fragment, new ConfirmOrderFragment(), null)
                        .commit();


            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartFragment.setReachedStep(1);
                Navigation.createNavigateOnClickListener(R.id.navigation_cart).onClick(v);

            }
        });
    }

    @Override
    public void onClickItemListener(int position, int itemID) {

    }
}