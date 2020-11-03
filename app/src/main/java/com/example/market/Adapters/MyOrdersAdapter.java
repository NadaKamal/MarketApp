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
import com.example.market.R;
import com.example.market.databinding.MyOrdersItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MyOrdersAdapter extends RecyclerView.Adapter<MyOrdersAdapter.MyOrdersViewHolder> {


    List<OrderModel> OrderArrayList;
    private onClickItemListener itemListener;
     OrderItemAdapter orderItemAdapter;
    List<OrderItemsModel> orderItemsModelArrayList;
    Context context;

    public MyOrdersAdapter(List<OrderModel> OrderArrayList,  Context context,List<OrderItemsModel> orderItemsModelArrayList) {
        this.OrderArrayList = OrderArrayList;
        this.orderItemsModelArrayList = orderItemsModelArrayList;
        this.context = context;
    }

    @NonNull

    @Override
    public MyOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyOrdersViewHolder(MyOrdersItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));


        //  View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.partial_item, parent, false);
        //  MyOrdersViewHolder = new PartialMyOrdersViewHolder(view2, itemListener);


    }

    private static final String TAG = "MyOrdersAdapter";

    public void onBindViewHolder(@NonNull final MyOrdersViewHolder holder, int position) {
        OrderModel currentItem = OrderArrayList.get(position);

        holder.binding.tvOrderNumber.setText(currentItem.getOrderNum());
        holder.binding.tvDelivery.setText(currentItem.getDeliveryPrice());
        holder.binding.tvTotal.setText(currentItem.getTotalOrder());
        holder.binding.tvOrderStatus.setText(currentItem.getOrderStatus());
        orderItemAdapter = new OrderItemAdapter(orderItemsModelArrayList,context);
        holder.binding.recyclerOrderItems.setAdapter(orderItemAdapter);
        holder.binding.ivExpandItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.binding.expandedLayout.getVisibility() == View.GONE)
                {
                    holder.binding.ivExpandItem.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24);
                    holder.binding.expandedLayout.setVisibility(View.VISIBLE);
                }
                else if(holder.binding.expandedLayout.getVisibility() == View.VISIBLE)
                {
                    holder.binding.expandedLayout.setVisibility(View.GONE);
                    holder.binding.ivExpandItem.setImageResource(R.drawable.ic_baseline_arrow_drop_down_24);
                }

            }
        });
        // CategoriesResponse currentItem = MessagesArrayList.get(position);
//        Log.d(TAG, "onBindMyOrdersViewHolder: "+MessagesArrayList.get(position).getName());
//        holder.itemName.setText(MessagesArrayList.get(position).getName());
//
//        Glide.with(context).load("http://app.al-jaddaf.com/public/uploads/"+ MessagesArrayList.get(position).getImage()).into(holder.itemImage);
    }


    class MyOrdersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        onClickItemListener listener;

        MyOrdersItemBinding binding;


        public MyOrdersViewHolder(MyOrdersItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


        @Override
        public void onClick(View v) {
//            itemListener.onClickItemListener(getAdapterPosition(),MessagesArrayList.get(getAdapterPosition()).getId());

        }
    }

    public void setOrderArrayList(List<OrderModel> ArrayList) {
        ArrayList = ArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return OrderArrayList == null ? 0 : OrderArrayList.size();
    }

    public interface onClickItemListener {
        void onClickItemListener(int position, int itemID);

    }
}



