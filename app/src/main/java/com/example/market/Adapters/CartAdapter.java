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
import com.example.market.databinding.CartItemBinding;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {


    List<ProductsModel> CartItemsArray;
    private onClickItemListener itemListener;
    CartItemBinding binding;
    Context context;
    int amount;

    public CartAdapter(List<ProductsModel> CartItemsArray, onClickItemListener listener, Context context) {
        this.CartItemsArray = CartItemsArray;
        this.itemListener = listener;
        this.context = context;
    }

    @NonNull

    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       return new CartViewHolder(CartItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));


        //  View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.partial_item, parent, false);
        //  CartViewHolder = new PartialCartViewHolder(view2, itemListener);


    }

    private static final String TAG = "CartAdapter";

    public void onBindViewHolder(@NonNull final CartViewHolder holder, int position) {
        ProductsModel currentItem = CartItemsArray.get(position);

        holder.binding.originTxt.setText(currentItem.getProduct_origin());
        holder.binding.tvProductName.setText(currentItem.getProduct_name());
        holder.binding.priceTxt.setText(currentItem.getProduct_price());
        amount =Integer.parseInt(holder.binding.tvCount.getText().toString());
        holder.binding.weightTxt.setText(currentItem.getProduct_weight());
        holder.binding.tvPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount++;
                holder.binding.tvCount.setText(String.valueOf(amount));
            }
        });

        holder.binding.tvMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount = Integer.parseInt(holder.binding.tvCount.getText().toString());
                if (amount == 0)
                    return;
                amount--;
                holder.binding.tvCount.setText(String.valueOf(amount));
            }
        });

    }


    class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

         CartItemBinding binding;

        public CartViewHolder(CartItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


        @Override
        public void onClick(View v) {
        }
    }

    public void setCartItemsArray(List<ProductsModel> ArrayList) {
        ArrayList = ArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return CartItemsArray == null ? 0 : CartItemsArray.size();
    }

    public interface onClickItemListener {
        void onClickItemListener(int position, int itemID);

    }
}



