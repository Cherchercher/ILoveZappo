package com.example.cher.firstproduct;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.cher.firstproduct.databinding.ContentMainBinding;
import com.example.cher.firstproduct.models.ObjectWrapperForBinder;
import com.example.cher.firstproduct.models.Product;

import static com.example.cher.firstproduct.BR.product;
import static com.example.cher.firstproduct.R.attr.srcCompat;

/**
 * Created by Cher on 2/3/2017.
 */

public class DetailActivity extends AppCompatActivity{
    ContentMainBinding cBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Product product = ((ObjectWrapperForBinder)getIntent().getExtras().getBinder("productDetail")).getData();
        cBinding= DataBindingUtil.setContentView(this,R.layout.content_main);
        cBinding.setProduct(product);

        FloatingActionButton myFab = (FloatingActionButton)  this.findViewById(R.id.floatingActionButton);
        final Animation FabClick = AnimationUtils.loadAnimation(this, R.anim.bounce);
        BounceInterPolator interpolator = new BounceInterPolator(0.2, 20);
        FabClick.setInterpolator(interpolator);
        myFab.setOnClickListener(new OnClickListener() {
            boolean buttonClicked = false;

            private void timer() {
                final Handler handler = new Handler();
                handler.post(new Runnable() {
                    private int seconds = 2;
                    private boolean stopTimer = false;
                    @Override
                    public void run() {
                        seconds--;
                        if (seconds < 0) {
                            myFab.setImageResource(R.drawable.check);
                            stopTimer = true;
                        }
                        if(stopTimer == false) {
                            myFab.setImageResource(R.drawable.heart);
                            handler.postDelayed(this, 1000);
                        }
                    }

                });
            }

            @Override
            public void onClick(View view) {
                if(!buttonClicked) {
                    timer();
                    myFab.startAnimation(FabClick);
                }
                else
                {
                    myFab.setImageResource(R.drawable.shopping_cart);
                }
                buttonClicked = !buttonClicked;
            }
        });

    }

}
