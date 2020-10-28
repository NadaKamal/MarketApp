package com.example.market.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.market.MainActivity;
import com.example.market.Model.CategoriesModel;
import com.example.market.R;
import com.example.market.databinding.CategoryCardBinding;
import com.example.market.databinding.CategoryItemBinding;

import java.util.ArrayList;
import java.util.List;

public class CardsAdapter extends PagerAdapter {

    private List<CategoriesModel> categoriesModel;
    private Context context;
    CategoryCardBinding binding;

    public CardsAdapter(List<CategoriesModel> categoriesModel, Context context) {
        this.categoriesModel = categoriesModel;
        this.context = context;
    }

    @Override
    public int getCount() {
        return categoriesModel.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (CardView) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, int position) {
        binding = CategoryCardBinding.inflate(LayoutInflater.from(container.getContext()),container,false);
        View view = binding.getRoot();
        container.addView(view);

        binding.tvItemName.setText(categoriesModel.get(position).getCategoryName());
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_mainActivity);
            }
        });
      //  binding.ivCategoryImg.setImageURI(categoriesModel.get(position).getCategoryImg());
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}