package com.example.cher.firstproduct.rest;
import com.example.cher.firstproduct.models.ProductSearchResult;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Cher on 1/29/2017.
 */
public interface ProductsRetrofit {
    String ENDPOINT_URL = "https://api.zappos.com";
    @GET("/Search?&key=b743e26728e16b81da139182bb2094357c31d331")
    Observable<ProductSearchResult> search(@Query("term") String term);
}
