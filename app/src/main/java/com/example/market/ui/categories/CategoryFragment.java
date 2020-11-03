package com.example.market.ui.categories;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.market.Adapters.CategoriesAdapter;
import com.example.market.Model.CategoriesModel;
import com.example.market.databinding.FragmentCategoryBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {

    ArrayList<CategoriesModel> CategoriesArrayList = new ArrayList<>();
    FragmentCategoryBinding binding;

    public CategoryFragment() {
        // Required empty public constructor
    }

    public static CategoryFragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCategoryBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CategoriesAdapter adapter = new CategoriesAdapter(CategoriesArrayList,getContext());
        CategoriesArrayList.clear();
        CategoriesArrayList.add(new CategoriesModel("", "Category"));
        CategoriesArrayList.add(new CategoriesModel("", "Category"));
        CategoriesArrayList.add(new CategoriesModel("", "Category"));


        binding.recyclerOffers.setAdapter(adapter);

    }
}