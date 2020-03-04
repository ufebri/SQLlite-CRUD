package com.bedboy.crudsqlite.ui.pembelian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bedboy.crudsqlite.data.DBAdapter;
import com.bedboy.crudsqlite.databinding.ItemProductBinding;
import com.bedboy.crudsqlite.model.Pembelian;

import java.util.List;

public class PembelianAdapter extends RecyclerView.Adapter<PembelianAdapter.ViewHolder> {

    private Context context;
    private DBAdapter dbAdapter;
    private List<Pembelian> salesList;
    private LayoutInflater inflater;
    private ItemProductBinding binding;

    public PembelianAdapter(Context context, List<Pembelian> salesList) {
        this.context = context;
        this.salesList = salesList;
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
        Pembelian sale = salesList.get(i);
        viewHolder.bind(sale);
    }

    @Override
    public int getItemCount() {
        return salesList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemProductBinding binding;

        private ViewHolder(ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Pembelian sale) {
            binding.tvName.setText(sale.getProdName() + "");
            binding.tvId.setText(sale.getIntSalesOrderID() + "");
            binding.tvGender.setText(sale.getCustName());
            binding.tvAddress.setText(sale.getIntQty() + "");
            binding.executePendingBindings();
        }
    }
}
