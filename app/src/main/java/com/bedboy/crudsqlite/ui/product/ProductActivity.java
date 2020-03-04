package com.bedboy.crudsqlite.ui.product;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bedboy.crudsqlite.R;
import com.bedboy.crudsqlite.data.DBAdapter;
import com.bedboy.crudsqlite.databinding.ActivityProductBinding;
import com.bedboy.crudsqlite.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    private ActivityProductBinding binding;
    private DBAdapter dbAdapter;
    private List<Product> productList = new ArrayList<>();
    private ProductAdapter adapterProduct;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product);

        binding.btnAddProduct.setOnClickListener(v -> startActivity(new Intent(this, AddProductActivity.class)));

        getData();
    }

    private void getData() {
        dbAdapter = new DBAdapter(this, 1);
        productList = dbAdapter.getProduct();
        layoutManager = new LinearLayoutManager(this);
        adapterProduct = new ProductAdapter(productList, this);
        binding.rvProduct.setLayoutManager(layoutManager);
        binding.rvProduct.setAdapter(adapterProduct);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getData();
    }
}
