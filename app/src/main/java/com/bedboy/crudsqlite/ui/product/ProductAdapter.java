package com.bedboy.crudsqlite.ui.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bedboy.crudsqlite.data.DBAdapter;
import com.bedboy.crudsqlite.databinding.ItemProductBinding;
import com.bedboy.crudsqlite.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private RecyclerView.LayoutManager layoutManager;
    private List<Product> products;
    private Context context;
    private DBAdapter dbAdapter;
    private ItemProductBinding binding;
    private LayoutInflater inflater;

    public ProductAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
        this.dbAdapter = new DBAdapter(context, 1);
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
        Product product = products.get(i);
        viewHolder.bind(product);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemProductBinding binding;

        private ViewHolder(ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Product product) {
            binding.tvName.setText(product.getTxtProductName());
            binding.tvId.setText(product.getIntProductID() + "");
            binding.tvGender.setText(product.getTxtProductCode());
            binding.tvAddress.setText(product.getBrandName());
            binding.executePendingBindings();
        }
    }
}
