package com.bedboy.crudsqlite.ui.customer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.bedboy.crudsqlite.R;
import com.bedboy.crudsqlite.data.DBAdapter;
import com.bedboy.crudsqlite.databinding.ActivityCustomerBinding;
import com.bedboy.crudsqlite.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerActivity extends AppCompatActivity {

    private ActivityCustomerBinding binding;
    private DBAdapter dbAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Customer> customerList = new ArrayList<>();
    private CustomerAdapter customerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_customer);
        dbAdapter = new DBAdapter(this, 1);

        binding.btnAddCustomer.setOnClickListener(v -> startActivity(new Intent(this, AddCustomerActivity.class)));
        getData();
    }

    private void getData() {
        customerList = dbAdapter.getCustomer();
        layoutManager = new LinearLayoutManager(this);
        customerAdapter = new CustomerAdapter(this, customerList);
        binding.rvCustomer.setLayoutManager(layoutManager);
        binding.rvCustomer.setAdapter(customerAdapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getData();
    }
}
