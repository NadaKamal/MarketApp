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


import com.example.market.Model.AddressModel;
import com.example.market.databinding.AddressItemBinding;

import java.util.ArrayList;
import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.AddressViewHolder> {


    List<AddressModel> Addresses;
    private onClickItemListener itemListener;
    Context context;

    public AddressAdapter(List<AddressModel> Addresses,
                          onClickItemListener listener,
                          Context context) {
        this.Addresses = Addresses;
        this.itemListener = listener;
        this.context = context;
    }

    @NonNull

    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       return new AddressViewHolder(AddressItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));

        //  View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.partial_item, parent, false);
        //  AddressViewHolder = new PartialAddressViewHolder(view2, itemListener);


    }

    private static final String TAG = "AddressAdapter";

    public void onBindViewHolder(@NonNull AddressViewHolder holder, int position) {
        AddressModel currentItem = Addresses.get(position);

        holder.binding.tvAddress.setText(currentItem.getAddress());
        holder.binding.tvGovernorate.setText(currentItem.getGovernorate());
        // CategoriesResponse currentItem = MessagesArrayList.get(position);
//        Log.d(TAG, "onBindAddressViewHolder: "+MessagesArrayList.get(position).getName());
//        holder.itemName.setText(MessagesArrayList.get(position).getName());
//
//        Glide.with(context).load("http://app.al-jaddaf.com/public/uploads/"+ MessagesArrayList.get(position).getImage()).into(holder.itemImage);
    }


    class AddressViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView msgContent, msgLink, seenNum, time;
        onClickItemListener listener;
        AddressItemBinding binding;


        public AddressViewHolder(AddressItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }


        @Override
        public void onClick(View v) {
//            itemListener.onClickItemListener(getAdapterPosition(),MessagesArrayList.get(getAdapterPosition()).getId());

        }
    }

    public void setAddresses(List<AddressModel> ArrayList) {
        ArrayList = ArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return Addresses == null ? 0 : Addresses.size();
    }

    public interface onClickItemListener {
        void onClickItemListener(int position, int itemID);

    }
}



