package com.example.market.ui.orders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.market.Adapters.MyOrdersAdapter;
import com.example.market.Adapters.OrderItemAdapter;
import com.example.market.Model.OrderItemsModel;
import com.example.market.Model.OrderModel;
import com.example.market.R;
import com.example.market.databinding.FragmentMyOrdersBinding;

import java.util.ArrayList;
import java.util.Collections;

public class OrdersFragment extends Fragment {

    private OrdersViewModel notificationsViewModel;
  FragmentMyOrdersBinding binding;
    ArrayList<OrderItemsModel> orderItemsModelArrayList = new ArrayList<>();
  MyOrdersAdapter myOrdersAdapter;
  ArrayList<OrderModel> orderModelArrayList = new ArrayList<>();



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(OrdersViewModel.class);
      //  View root = inflater.inflate(R.layout.fragment_my_orders, container, false);
        binding = FragmentMyOrdersBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
//        final TextView textView = root.findViewById(R.id.text_notifications);
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return view;

      //  return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        orderItemsModelArrayList.add(new OrderItemsModel("Item1", "20GM", "20EGP"));
        orderItemsModelArrayList.add(new OrderItemsModel("Item1", "20GM", "20EGP"));



        orderModelArrayList.add(new OrderModel("Order #2000",
                "200EGP", "5EGP",
                orderItemsModelArrayList,
                "Delivered"));

        orderModelArrayList.add(new OrderModel("Order #2200",
                "200EGP", "5EGP",
                orderItemsModelArrayList,
                "Delivered"));
        orderModelArrayList.add(new OrderModel("Order #2000",
                "200EGP", "5EGP",
                orderItemsModelArrayList,
                "Delivered"));

        orderModelArrayList.add(new OrderModel("Order #2200",
                "200EGP", "5EGP",
                orderItemsModelArrayList,
                "Delivered"));
        orderModelArrayList.add(new OrderModel("Order #2000",
                "200EGP", "5EGP",
                orderItemsModelArrayList,
                "Delivered"));

        orderModelArrayList.add(new OrderModel("Order #2200",
                "200EGP", "5EGP",
                orderItemsModelArrayList,
                "Delivered"));

        orderModelArrayList.add(new OrderModel("Order #2000",
                "200EGP", "5EGP",
                orderItemsModelArrayList,
                "Delivered"));

        orderModelArrayList.add(new OrderModel("Order #2200",
                "200EGP", "5EGP",
                orderItemsModelArrayList,
                "Delivered"));

        orderModelArrayList.add(new OrderModel("Order #2000",
                "200EGP", "5EGP",
                orderItemsModelArrayList,
                "Delivered"));

        orderModelArrayList.add(new OrderModel("Order #2200",
                "200EGP", "5EGP",
                orderItemsModelArrayList,
                "Delivered"));
        myOrdersAdapter = new MyOrdersAdapter(orderModelArrayList, getActivity(),orderItemsModelArrayList);

        binding.recyclerMyOrders.setAdapter(myOrdersAdapter);
    }
}