package com.example.cher.firstproduct.models;

import android.os.Binder;

/**
 * Created by Cher on 2/3/2017.
 */

public class ObjectWrapperForBinder extends Binder {
    private final Product mData;

    public ObjectWrapperForBinder(Product data) {
        mData = data;
    }

    public Product getData() {
        return mData;
    }
}
