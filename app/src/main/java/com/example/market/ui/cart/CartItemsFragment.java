package com.example.market.ui.cart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.market.Adapters.CartAdapter;
import com.example.market.Model.ProductsModel;
import com.example.market.R;
import com.example.market.databinding.FragmentCartBinding;
import com.example.market.databinding.FragmentCartItemsBinding;

import java.util.ArrayList;

public class CartItemsFragment extends Fragment implements CartAdapter.onClickItemListener {

    FragmentCartItemsBinding binding;

    ArrayList<ProductsModel> cartItems = new ArrayList<>();


    public CartItemsFragment() {
        // Required empty public constructor
    }


    public static CartItemsFragment newInstance() {
        CartItemsFragment fragment = new CartItemsFragment();
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
       // return inflater.inflate(R.layout.fragment_cart_items, container, false);
        binding = FragmentCartItemsBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cartItems.add(new ProductsModel(getActivity().getResources().getString(R.string.product_name),
                "",getActivity().getResources().getString(R.string.country),
                getActivity().getResources().getString(R.string.weight),
                getActivity().getResources().getString(R.string._20_50)));
        cartItems.add(new ProductsModel(getActivity().getResources().getString(R.string.product_name),
                "",getActivity().getResources().getString(R.string.country),
                getActivity().getResources().getString(R.string.weight),
                getActivity().getResources().getString(R.string._20_50)));

        CartAdapter adapter = new CartAdapter(cartItems,this,getActivity());
        binding.recyclerOrders.setAdapter(adapter);
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartFragment.setReachedStep(2);
                getActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.cart_container_fragment, new AddressToDeliverFragment(), null)
                        .commit();

            }
        });
    }

    @Override
    public void onClickItemListener(int position, int itemID) {

    }
}