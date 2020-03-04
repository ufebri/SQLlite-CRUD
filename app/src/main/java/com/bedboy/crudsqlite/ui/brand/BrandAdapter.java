package com.bedboy.crudsqlite.ui.brand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bedboy.crudsqlite.data.DBAdapter;
import com.bedboy.crudsqlite.databinding.ItemProductBinding;
import com.bedboy.crudsqlite.model.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<Brand> brandList = new ArrayList<>();
    private DBAdapter dbAdapter;
    private ItemProductBinding binding;

    public BrandAdapter(Context context, List<Brand> brands, DBAdapter dbAdapter) {
        this.context = context;
        this.brandList = brands;
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
        Brand brand = brandList.get(i);
        viewHolder.bind(brand);
    }

    @Override
    public int getItemCount() {
        return brandList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemProductBinding binding;

        public ViewHolder(ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Brand brand) {
            binding.tvName.setText(brand.getTxtBrandName());
            binding.tvId.setText(brand.getIntBrandID() + "");
            binding.executePendingBindings();
        }
    }
}
