package com.example.cher.firstproduct.rest;
import com.example.cher.firstproduct.models.ProductSearchResult;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import java.io.IOException;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

import static com.example.cher.firstproduct.rest.ProductsRetrofit.ENDPOINT_URL;

/**
 * Created by Cher on 1/29/2017.
 */

public class ProductsParser {
    public static Observable<ProductSearchResult> searchByName(String q) throws IOException{
        RxJavaCallAdapterFactory rxAdapter =
                RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .build();

        ProductsRetrofit api = retrofit.create(ProductsRetrofit.class);
        return api.search(q);
    }
}
