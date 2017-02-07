package com.example.cher.firstproduct;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Cher on 1/29/2017.
 */

public class ImageBinding {
    @BindingAdapter("android:src")
    public static void setImage(ImageView imageView,String url){
                Picasso.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
