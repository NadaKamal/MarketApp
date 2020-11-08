package com.example.market.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.market.ui.categories.CategoryFragment;
import com.example.market.ui.Products.VegetablesFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    Context context;
    public PagerAdapter(@NonNull FragmentManager fm) {

        super(fm );
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       Fragment fragment = null;
        if (position == 0) fragment = CategoryFragment.newInstance();
        if (position == 1) fragment = VegetablesFragment.newInstance(position);
        if (position == 2) fragment = VegetablesFragment.newInstance(position);
        if (position == 3) fragment = VegetablesFragment.newInstance(position);
        if (position == 4) fragment = VegetablesFragment.newInstance(position);
        if (position == 5) fragment = VegetablesFragment.newInstance(position);
        if (position == 6) fragment = VegetablesFragment.newInstance(position);
        if (position == 7) fragment = VegetablesFragment.newInstance(position);
        if (position == 8) fragment = VegetablesFragment.newInstance(position);
        if (position == 9) fragment = VegetablesFragment.newInstance(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return 9;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        Context context = this.context;
        if (position == 0) title = "الكل";
        if (position == 1) title = "Tab";
        if (position == 2) title = "Tab";
        if (position == 3) title = "Tab";
        if (position == 4) title = "Tab";
        if (position == 5) title = "Tab";
        if (position == 6) title = "Tab";
        if (position == 7) title = "Tab";
        if (position == 8) title = "Tab";
        if (position == 9) title = "Tab";
        return title;
    }
}