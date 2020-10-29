package com.example.market.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.market.Model.ProductsModel;
import com.example.market.databinding.ProductItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {


    List<ProductsModel> ProductsArrayList;
    private onClickItemListener itemListener;
    Context context;
    int amount;
    public ProductsAdapter(List<ProductsModel> ProductsArrayList, onClickItemListener listener, Context context) {
        this.ProductsArrayList = ProductsArrayList;
        this.itemListener = listener;
        this.context = context;
    }

    @NonNull

    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        return new ProductViewHolder(ProductItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));


        //  View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.partial_item, parent, false);
        //  ProductViewHolder = new PartialProductViewHolder(view2, itemListener);


    }

    private static final String TAG = "ProductsAdapter";

    public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {
        ProductsModel currentItem = ProductsArrayList.get(position);

        holder.binding.tvProductName.setText(currentItem.getProduct_name());
        holder.binding.originTxt.setText(currentItem.getProduct_origin());
        holder.binding.priceTxt.setText(currentItem.getProduct_price());
        holder.binding.weightTxt.setText(currentItem.getProduct_weight());
        amount = Integer.parseInt(holder.binding.tvItemCount.getText().toString());
        holder.binding.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.binding.btnAddToCart.setVisibility(View.GONE);
                holder.binding.tvItemCount.setVisibility(View.VISIBLE);
                holder.binding.btnAdd.setVisibility(View.VISIBLE);
                holder.binding.btnDn.setVisibility(View.VISIBLE);
                holder.binding.btnRemove.setVisibility(View.VISIBLE);
            }
        });

        holder.binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount++;
                holder.binding.tvItemCount.setText(String.valueOf(amount));
            }
        });

        holder.binding.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount = Integer.parseInt(holder.binding.tvItemCount.getText().toString());
                if (amount == 0)
                    return;
                amount--;
                holder.binding.tvItemCount.setText(String.valueOf(amount));
            }
        });

    }
    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ProductItemBinding binding;
        public ProductViewHolder(@NonNull ProductItemBinding binding ) {
            super(binding.getRoot());
            this.binding = binding; }


        @Override
        public void onClick(View v) {
//            itemListener.onClickItemListener(getAdapterPosition(),MessagesArrayList.get(getAdapterPosition()).getId());

        }
    }

    public void setProductsArrayList(List<ProductsModel> ArrayList) {
        ArrayList = ArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return ProductsArrayList == null ? 0 : ProductsArrayList.size();
    }

    public interface onClickItemListener {
        void onClickItemListener(int position, int itemID);

    }
}



