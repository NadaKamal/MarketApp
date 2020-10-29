package com.example.market.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.market.Adapters.ProductsAdapter;
import com.example.market.Model.ProductsModel;
import com.example.market.R;
import com.example.market.databinding.FragmentVegetablesBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VegetablesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VegetablesFragment extends Fragment implements  ProductsAdapter.onClickItemListener{

    FragmentVegetablesBinding binding;
    ProductsAdapter adapter;
    ArrayList<ProductsModel> products = new ArrayList<>();
    public VegetablesFragment() {
        // Required empty public constructor
    }

    public static VegetablesFragment newInstance() {
        VegetablesFragment fragment = new VegetablesFragment();

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
        binding = FragmentVegetablesBinding.inflate(inflater,container,false);
         View view = binding.getRoot();
         return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        products.add(new ProductsModel("product", "", "County", "20kg", "30 EGP"));
        products.add(new ProductsModel("product", "", "County", "20kg", "30 EGP"));
        products.add(new ProductsModel("product", "", "County", "20kg", "30 EGP"));
        products.add(new ProductsModel("product", "", "County", "20kg", "30 EGP"));
        products.add(new ProductsModel("product", "", "County", "20kg", "30 EGP"));
        products.add(new ProductsModel("product", "", "County", "20kg", "30 EGP"));
        products.add(new ProductsModel("product", "", "County", "20kg", "30 EGP"));

        adapter = new ProductsAdapter(products, this, getActivity());
        binding.recyclerVegetables.setAdapter(adapter);
    }

    @Override
    public void onClickItemListener(int position, int itemID) {

    }
}