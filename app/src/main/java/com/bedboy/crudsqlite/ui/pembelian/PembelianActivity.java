package com.bedboy.crudsqlite.ui.pembelian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.bedboy.crudsqlite.R;
import com.bedboy.crudsqlite.data.DBAdapter;
import com.bedboy.crudsqlite.databinding.ActivityPembelianBinding;
import com.bedboy.crudsqlite.model.Pembelian;

import java.util.ArrayList;
import java.util.List;

public class PembelianActivity extends AppCompatActivity {

    private ActivityPembelianBinding binding;
    private DBAdapter dbAdapter;
    private List<Pembelian> pembelianList = new ArrayList<>();
    private PembelianAdapter pembelianAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_pembelian);
        binding.btnAddSales.setOnClickListener(v -> startActivity(new Intent(this, AddPembelianActivity.class)));
        getData();
    }

    private void getData() {
        dbAdapter = new DBAdapter(this, 1);
        pembelianList = dbAdapter.getSales();
        layoutManager = new LinearLayoutManager(this);
        pembelianAdapter = new PembelianAdapter(this, pembelianList);
        binding.rvSales.setLayoutManager(layoutManager);
        binding.rvSales.setAdapter(pembelianAdapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getData();
    }
}
