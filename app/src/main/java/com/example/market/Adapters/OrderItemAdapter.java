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


import com.example.market.Model.OrderItemsModel;
import com.example.market.Model.OrderModel;
import com.example.market.databinding.OrderItemBinding;

import java.util.ArrayList;
import java.util.List;

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.OrderItemViewHolder> {


    List<OrderItemsModel> OrderItemArrayList;
    private onClickItemListener itemListener;
    Context context;

    public OrderItemAdapter(List<OrderItemsModel> OrderItemArrayList,  Context context) {
        this.OrderItemArrayList = OrderItemArrayList;

        this.context = context;
    }

    @NonNull

    @Override
    public OrderItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       return new OrderItemViewHolder(OrderItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));


        //  View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.partial_item, parent, false);
        //  OrderItemViewHolder = new PartialOrderItemViewHolder(view2, itemListener);


    }

    private static final String TAG = "OrderItemAdapter";

    public void onBindViewHolder(@NonNull OrderItemViewHolder holder, int position) {
        OrderItemsModel currentItem = OrderItemArrayList.get(position);

        holder.binding.tvProductName.setText(currentItem.getProductName());
        holder.binding.tvItemCount.setText(currentItem.getProductCount());
        holder.binding.tvItemPrice.setText(currentItem.getProductPrice());
        // CategoriesResponse currentItem = MessagesArrayList.get(position);
//        Log.d(TAG, "onBindOrderItemViewHolder: "+MessagesArrayList.get(position).getName());
//        holder.itemName.setText(MessagesArrayList.get(position).getName());
//
//        Glide.with(context).load("http://app.al-jaddaf.com/public/uploads/"+ MessagesArrayList.get(position).getImage()).into(holder.itemImage);
    }


    class OrderItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        onClickItemListener listener;
        OrderItemBinding binding;



        public OrderItemViewHolder(OrderItemBinding binding) {
            super(binding.getRoot());
            this.binding= binding;
        }


        @Override
        public void onClick(View v) {
//            itemListener.onClickItemListener(getAdapterPosition(),MessagesArrayList.get(getAdapterPosition()).getId());

        }
    }

    public void setOrderItemArrayList(List<OrderItemsModel> ArrayList) {
        ArrayList = ArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return OrderItemArrayList == null ? 0 : OrderItemArrayList.size();
    }

    public interface onClickItemListener {
        void onClickItemListener(int position, int itemID);

    }
}



