package com.example.cher.firstproduct.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.example.cher.firstproduct.R;
import com.example.cher.firstproduct.databinding.ProductDetailBinding;
import com.example.cher.firstproduct.models.Product;

import java.util.List;

/**
 * Created by Cher on 1/29/2017.
 */

public class ProductsAdapter extends ArrayAdapter<Product>{
    public ProductsAdapter(Context context, List<Product> products) {super(context,0,products);}

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Product product =getItem(position);
        ProductDetailBinding binding = null;
        if(convertView == null){
            binding = DataBindingUtil.inflate(
                    LayoutInflater.from(getContext()),
                    R.layout.product_detail, parent, false);
        }
        else{
            binding =DataBindingUtil.bind(convertView);
        }
        binding.setProduct(product);
        return binding.getRoot();
    }
}
