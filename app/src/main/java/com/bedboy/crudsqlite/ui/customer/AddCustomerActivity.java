package com.bedboy.crudsqlite.ui.customer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.bedboy.crudsqlite.R;
import com.bedboy.crudsqlite.data.DBAdapter;
import com.bedboy.crudsqlite.databinding.ActivityAddCustomerBinding;
import com.bedboy.crudsqlite.model.Customer;
import com.bedboy.crudsqlite.uti.Constant;

import java.util.Date;

public class AddCustomerActivity extends AppCompatActivity {

    private ActivityAddCustomerBinding binding;
    private DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_customer);
        dbAdapter = new DBAdapter(this, 1);

        addCustomer();
    }

    private void addCustomer() {
        binding.btnAddCust.setOnClickListener(v -> {
            Customer customer = new Customer();
            customer.setTxtCustomerName(binding.tieNamaCustomer.getText().toString());
            customer.setTxtCustomerAddress(binding.tieAdrCustomer.getText().toString());
            customer.setInserted(new Date());
            customer.setBitGender(Constant.getBitGender(binding.spnGender.getSelectedItem().toString()));
            dbAdapter.persistCust(customer);
            Toast.makeText(this,"insert success", Toast.LENGTH_SHORT).show();
            binding.tvIdCustomer.setText("");
            binding.tieNamaCustomer.setText("");
            binding.tieAdrCustomer.setText("");
            binding.spnGender.setSelection(-1);
        });
    }
}
