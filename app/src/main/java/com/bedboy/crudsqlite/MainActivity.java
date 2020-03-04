package com.bedboy.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.bedboy.crudsqlite.databinding.ActivityMainBinding;
import com.bedboy.crudsqlite.ui.brand.BrandActivity;
import com.bedboy.crudsqlite.ui.customer.CustomerActivity;
import com.bedboy.crudsqlite.ui.pembelian.PembelianActivity;
import com.bedboy.crudsqlite.ui.product.ProductActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnBrand.setOnClickListener(v -> {startActivity(new Intent(this, BrandActivity.class));});
        binding.btnCustomer.setOnClickListener(v -> {startActivity(new Intent(this, CustomerActivity.class));});
        binding.btnPembelian.setOnClickListener(v -> {startActivity(new Intent(this, PembelianActivity.class));});
        binding.btnProduct.setOnClickListener(v -> {startActivity(new Intent(this, ProductActivity.class));});

    }
}
