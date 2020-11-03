package com.example.market.ui.cart;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.market.R;
import com.example.market.databinding.FragmentCartBinding;
import com.example.market.ui.LoginFragment;

import ir.neo.stepbarview.StepBarView;

public class CartFragment extends Fragment {
    static FragmentCartBinding binding;
    private CartViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(CartViewModel.class);
        binding = FragmentCartBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
//        final TextView textView = root.findViewById(R.id.text_dashboard);
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return view;
    }

    private static Context context;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Navigation.findNavController(view).navigate(R.id.action_navigation_cart_to_loginFragment);
        //  binding.StepBar.setStepsReachedColor(getActivity().getResources().getColor(R.color.colorPrimaryDark));
        binding.StepBar.setReachedStep(1);
        context=getContext();
        getActivity().getSupportFragmentManager()
                .beginTransaction().replace(R.id.cart_container_fragment, new CartItemsFragment(), null)
                .commit();


    }

    public static void setReachedStep(final int step) {
      //  Toast.makeText(context, ""+step, Toast.LENGTH_SHORT).show();
        binding.StepBar.setReachedStep(step);
        binding.StepBar.refreshDrawableState();
    }
}