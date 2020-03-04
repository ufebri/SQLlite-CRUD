package com.bedboy.crudsqlite.ui.customer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bedboy.crudsqlite.data.DBAdapter;
import com.bedboy.crudsqlite.databinding.ItemProductBinding;
import com.bedboy.crudsqlite.model.Customer;
import com.bedboy.crudsqlite.uti.Constant;

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private List<Customer> customerList = new ArrayList<>();
    private DBAdapter dbAdapter;
    private ItemProductBinding binding;

    public CustomerAdapter(Context context, List<Customer> customerList) {
        this.context = context;
        this.dbAdapter = new DBAdapter(context, 1);
        this.customerList = customerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflater = LayoutInflater.from(viewGroup.getContext());
        binding = ItemProductBinding.inflate(inflater, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Customer customer = customerList.get(i);
        viewHolder.bind(customer);
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemProductBinding binding;

        public ViewHolder(ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Customer customer) {
            binding.tvName.setText(customer.getTxtCustomerName());
            binding.tvId.setText(customer.getIntCustomerID() + "");
            binding.tvGender.setText(Constant.getStringGender(customer.isBitGender()));
            binding.tvAddress.setText(customer.getTxtCustomerAddress());
            binding.executePendingBindings();
        }
    }

}
