package com.example.cher.firstproduct;
import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cher.firstproduct.databinding.ActivityMainBinding;
import com.example.cher.firstproduct.databinding.ContentMainBinding;
import com.example.cher.firstproduct.models.ObjectWrapperForBinder;
import com.example.cher.firstproduct.models.Product;
import com.example.cher.firstproduct.models.ProductSearchResult;
import com.example.cher.firstproduct.rest.ProductsParser;
import com.example.cher.firstproduct.ui.adapter.ProductsAdapter;
import java.io.IOException;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity
    implements SearchView.OnQueryTextListener{
    ActivityMainBinding pBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu,menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView =(SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query){
        try {
            Observable<ProductSearchResult> result = ProductsParser.searchByName(query);
            Subscription subscription = result
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            ProductSearchResult->updateListView(ProductSearchResult),
                            Throwable::printStackTrace,
                            () -> Log.d("NGVL","complete")
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText){return false;}

    public void updateListView(ProductSearchResult productSearchResult){
        pBinding.listProducts.setAdapter(new ProductsAdapter(this,productSearchResult.getResults()));
        pBinding.listProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Product product = (Product)pBinding.listProducts.getItemAtPosition(i);
                final Bundle bundle = new Bundle();
                bundle.putBinder("productDetail",new ObjectWrapperForBinder(product));
                startActivity(new Intent(MainActivity.this,DetailActivity.class).putExtras(bundle));
            }
        });


    }

}


