package com.bedboy.crudsqlite.ui.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.bedboy.crudsqlite.R;
import com.bedboy.crudsqlite.data.DBAdapter;
import com.bedboy.crudsqlite.databinding.ActivityAddProductBinding;
import com.bedboy.crudsqlite.model.Brand;
import com.bedboy.crudsqlite.model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddProductActivity extends AppCompatActivity {

    private DBAdapter dbAdapter;
    private ActivityAddProductBinding binding;
    private List<Brand> brandList = new ArrayList<>();
    private List<String> brandName = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_product);
        dbAdapter = new DBAdapter(this, 1);

        setSpinner();
        addProduct();
    }

    private void addProduct() {
        binding.btnAddProducts.setOnClickListener(v -> {
            Product product = new Product();
            product.setDtInserted(new Date());
            product.setIntBrandID(brandList.get(binding.spnBrand.getSelectedItemPosition()).getIntBrandID());
            product.setTxtProductName(binding.etProductNames.getText().toString());
            product.setTxtProductCode(binding.etProductCodes.getText().toString());
            dbAdapter.persistProduct(product);
            Toast.makeText(this, "Insert Success", Toast.LENGTH_SHORT).show();
            binding.etProductNames.setText("");
            binding.etProductCodes.setText("");
            binding.tvIdProducts.setText("");
        });
    }

    private void setSpinner() {
        brandList = dbAdapter.getBrand();
        for (int a = 0; a < brandList.size(); a++) {
            brandName.add(brandList.get(a).getTxtBrandName());
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, brandName);
        binding.spnBrand.setAdapter(dataAdapter);
    }
}
