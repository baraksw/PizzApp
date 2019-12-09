package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    ViewPager pizza_size_viewPager;
    Adapter adapter;
    List<Model> models;
    private static final String LOG_TAG = HomePage.class.getSimpleName();

    public static final String SIZESPRICE = "price_for_size";
    private String pizza_price;
    private int size_price=0;
    public boolean personal_flag=false,family_flag=false,big_flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.pizza_size_small, "40 שקלים"));
        models.add(new Model(R.drawable.pizza_size_medium, "50 שקלים"));
        models.add(new Model(R.drawable.pizza_size_large, "60 שקלים"));

        adapter = new Adapter(models, this);

        pizza_size_viewPager = findViewById(R.id.pizza_size_viewPager);
        pizza_size_viewPager.setAdapter(adapter);
        pizza_size_viewPager.setPadding(130, 0, 0, 130);

        pizza_size_viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount() -1)) {

                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void launchToppingsPage(View view) {
        Intent ToppingsIntent = new Intent(this, Toppings.class);
        pizza_price=String.valueOf(size_price);
        ToppingsIntent.putExtra(SIZESPRICE,pizza_price);
        startActivity(ToppingsIntent);
    }

    public void choosePizzaSize(View view) {

    }

    public void personal_size(View view) {
        personal_flag=true;
        family_flag=false;
        big_flag=false;
        size_price=40;
    }

    public void family_size(View view) {
        personal_flag=true;
        family_flag=true;
        big_flag=false;
        size_price=50;
    }

    public void big_size(View view) {
        personal_flag=true;
        family_flag=false;
        big_flag=true;
        size_price=60;

    }
}
