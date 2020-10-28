package com.example.market;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Adapter;

import com.bartoszlipinski.flippablestackview.StackPageTransformer;
import com.example.market.Adapters.ImagesAdapter;
import com.example.market.Adapters.PagerAdapter;
import com.example.market.Model.CategoriesModel;
import com.example.market.databinding.ActivityMainBinding;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
   ActivityMainBinding binding;
   ArrayList<CategoriesModel> models = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolBar.toolBar1);






    }



}