package com.bedboy.crudsqlite.ui.pembelian;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bedboy.crudsqlite.R;
import com.bedboy.crudsqlite.data.DBAdapter;
import com.bedboy.crudsqlite.databinding.ActivityAddPembelianBinding;
import com.bedboy.crudsqlite.model.Customer;
import com.bedboy.crudsqlite.model.Pembelian;
import com.bedboy.crudsqlite.model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddPembelianActivity extends AppCompatActivity {

    private List<Product> productList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();
    private List<String> productNames = new ArrayList<>();
    private List<String> customerNames = new ArrayList<>();
    private DBAdapter dbAdapter;
    private ActivityAddPembelianBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_pembelian);
        dbAdapter = new DBAdapter(this, 1);


        checkData();
        setSpinner();
        addData();
    }

    private void addData() {
        binding.btnAddSale.setOnClickListener(v -> {
            Pembelian sale = new Pembelian();
            sale.setIntProductID(productList.get(binding.spnProduct.getSelectedItemPosition()).getIntProductID());
            sale.setIntCustomerID(customerList.get(binding.spnCustomer.getSelectedItemPosition()).getIntCustomerID());
            sale.setIntQty(Integer.parseInt(binding.tieSaleQty.getText().toString()));
            sale.setDtSalesOrder(new Date());
            dbAdapter.persistSale(sale);
            Toast.makeText(this, "Insert Success", Toast.LENGTH_SHORT).show();

        });
    }

    private void setSpinner() {
        if (productNames != null) {
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, productNames);
            binding.spnProduct.setAdapter(dataAdapter);
        }

        if (customerNames != null) {
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    R.layout.support_simple_spinner_dropdown_item, customerNames);
            binding.spnCustomer.setAdapter(dataAdapter2);
        }
    }

    private void checkData() {
        productList = dbAdapter.getProduct();
        customerList = dbAdapter.getCustomer();

        for (int a = 0; a < productList.size(); a++) {
            productNames.add(productList.get(a).getTxtProductName() + "");
        }

        for (int a = 0; a < customerList.size(); a++) {
            customerNames.add(customerList.get(a).getTxtCustomerName() + "");
        }
    }
}
