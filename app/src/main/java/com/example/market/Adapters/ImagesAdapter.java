package com.example.market.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.adapters.CardViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.market.Model.CategoriesModel;
import com.uis.stackviewlayout.StackViewLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ImagesAdapter extends StackViewLayout.StackViewAdapter {


    List<CategoriesModel> CategoriesArrayList;

    Context context;

    public ImagesAdapter(List<CategoriesModel> categoriesArrayList, Context context) {
        CategoriesArrayList = categoriesArrayList;
        this.context = context;
    }

    @Override
    public View onCreateView(ViewGroup parent, int viewType) {
        return null;

    }

    @Override
    public void onBindView(View view, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}



