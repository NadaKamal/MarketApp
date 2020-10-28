package com.example.market.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import com.example.market.Model.CategoriesModel;
import com.example.market.R;
import com.example.market.databinding.CategoryItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {


    List<CategoriesModel> CategoriesArrayList;
    private onClickItemListener itemListener;
    Context context;

    public CategoriesAdapter(List<CategoriesModel> CategoriesArrayList, Context context) {
        this.CategoriesArrayList = CategoriesArrayList;
        this.context = context;
    }

    @NonNull

    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     return new CategoriesViewHolder(CategoryItemBinding
             .inflate(LayoutInflater.from(parent.getContext())
                     ,parent,false)
              );


        //  View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.partial_item, parent, false);
        //  CategoriesViewHolder = new PartialCategoriesViewHolder(view2, itemListener);


    }

    private static final String TAG = "CategoriesAdapter";

    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        CategoriesModel currentItem = CategoriesArrayList.get(position);

        holder.binding.tvCategoryName.setText(currentItem.getCategoryName());
        holder.binding.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_vegetablesFragment);
            }
        });

    }


    class CategoriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CategoryItemBinding binding;

        public CategoriesViewHolder(@NonNull @NotNull CategoryItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }


        @Override
        public void onClick(View v) {

        }
    }

    public void setCategoriesArrayList(List<CategoriesModel> ArrayList) {
        ArrayList = ArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return CategoriesArrayList == null ? 0 : CategoriesArrayList.size();
    }

    public interface onClickItemListener {
        void onClickItemListener(int position, int itemID);

    }
}



