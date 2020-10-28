package com.example.market;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.market.databinding.ActivityHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends AppCompatActivity {

    TextView title;
    ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        setSupportActionBar(binding.toolBar.toolBar1);



        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_cart, R.id.navigation_account,R.id.navigation_setting)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupWithNavController(binding.navView, navController);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.toolBar.toolBar1,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        title = binding.toolBar.toolbarTitle;

navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
    @Override
    public void onDestinationChanged(@NonNull NavController controller,
                                     @NonNull NavDestination destination,
                                     @Nullable Bundle arguments) {


        if(destination.getId()==R.id.navigation_account)
        {
            binding.toolBar.toolbarTitle.setVisibility(View.VISIBLE);
            binding.toolBar.toolbarImg.setVisibility(View.GONE);
            binding.toolBar.toolbarTitle.setText(destination.getLabel());
        }
        else if (destination.getId() == R.id.navigation_setting)
        {
            binding.toolBar.toolbarTitle.setVisibility(View.VISIBLE);
            binding.toolBar.toolbarImg.setVisibility(View.GONE);
            binding.toolBar.toolbarTitle.setText(destination.getLabel());
        }
        else if (destination.getId() == R.id.navigation_cart)
        {
            binding.toolBar.toolbarTitle.setVisibility(View.VISIBLE);
            binding.toolBar.toolbarImg.setVisibility(View.GONE);
            binding.toolBar.toolbarTitle.setText(destination.getLabel());
        }

        else if (destination.getId() == R.id.signUpFragment)
        {
            binding.toolBar.toolbarTitle.setVisibility(View.VISIBLE);
            binding.toolBar.toolbarImg.setVisibility(View.GONE);
            binding.toolBar.toolbarTitle.setText(destination.getLabel());
        }
        else if (destination.getId() == R.id.loginFragment)
        {
            binding.toolBar.toolbarTitle.setVisibility(View.VISIBLE);
            binding.toolBar.toolbarImg.setVisibility(View.GONE);
            binding.toolBar.toolbarTitle.setText(destination.getLabel());
        }
        else if (destination.getId() == R.id.vegetablesFragment)
        {
            binding.toolBar.toolbarTitle.setVisibility(View.VISIBLE);
            binding.toolBar.toolbarImg.setVisibility(View.GONE);
            binding.toolBar.toolbarTitle.setText(destination.getLabel());
        }
    }
});


    }

}