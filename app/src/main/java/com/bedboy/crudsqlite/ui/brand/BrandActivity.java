package com.bedboy.crudsqlite.ui.brand;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bedboy.crudsqlite.R;
import com.bedboy.crudsqlite.data.DBAdapter;
import com.bedboy.crudsqlite.databinding.ActivityBrandBinding;
import com.bedboy.crudsqlite.databinding.DialogBrandingBinding;
import com.bedboy.crudsqlite.model.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandActivity extends AppCompatActivity {

    private ActivityBrandBinding binding;
    private Dialog addBrandDialog;
    private DBAdapter dbAdapter;
    private BrandAdapter brandAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Brand> brandList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_brand);
        dbAdapter = new DBAdapter(this, 1);
        brandList = dbAdapter.getBrand();

        brandAdapter = new BrandAdapter(this, dbAdapter.getBrand(), dbAdapter);
        getData();
        addData();


    }

    private void addData() {
        binding.btnAddBrand.setOnClickListener(v -> {
            addBrandDialog = new Dialog(this);
            addBrandDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            DialogBrandingBinding binding2 = DialogBrandingBinding.inflate(LayoutInflater.from(this), null);
            addBrandDialog.setContentView(binding2.getRoot());
            Window window = addBrandDialog.getWindow();
            WindowManager.LayoutParams params = window.getAttributes();
            params.gravity = Gravity.CENTER;
            addBrandDialog.setCancelable(true);
            addBrandDialog.setCanceledOnTouchOutside(true);

            binding2.btnPopUpAddBrand.setOnClickListener(v1 -> {
                dbAdapter.persistBrand(new Brand(binding2.edtBrand.getText().toString()));
                brandList = dbAdapter.getBrand();
                brandAdapter.notifyDataSetChanged();
                getData();
                addBrandDialog.dismiss();
            });


            addBrandDialog.show();

        });
    }

    private void getData() {
        layoutManager = new LinearLayoutManager(this);
        brandAdapter = new BrandAdapter(this, brandList, dbAdapter);
        binding.rvBrand.setLayoutManager(layoutManager);
        binding.rvBrand.setAdapter(brandAdapter);
    }
}
