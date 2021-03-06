package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    ViewPager pizza_size_viewPager;
    Adapter adapter;
    List<Model> pizza_size_models;
    private static final String LOG_TAG = HomePage.class.getSimpleName();


    public static final String SIZEPRICE = "price_for_size";
    public static final String PIZZASIZE="size_of_pizza";
    public static final String DRINKSPRICE = "price_for_drink";
    public static final String DRINKTYPE="drink_type";
    public static final String TOPPINGSPRICE = "price_for_toppings";
    public static final String MUSHROOMVISIBLE = "mushroom_visable";
    public static final String OLIVESVISIBLE = "olives_visable";
    public static final String TOMATOVISIBLE = "tomato_visable";
    public static final String ONIONVISIBLE = "onion_visable";
    public static final String PINEAPPLEVISIBLE = "pineapple_visable";
    public static final String PHONENUMBER = "phone_number";
    public static final String ADDRESS = "address";

    private String phone_number ;
    private String address;


    TextView t1;
    private int size_price=0;
    private int toppings_price=0;
    private int drink_price=0;
    private int pizza_size=1;
    private int drink_type=0;
    private int total_price=0;
    int mCurrentPosition = 1;


    public boolean personal_flag=false,family_flag=false,big_flag=false;

    private int mushrooms_visible = 0, olives_visible = 0, onion_visible = 0, tomatos_visible = 0, pineapple_visible = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        pizza_size_models = new ArrayList<>();
        pizza_size_models.add(new Model(R.drawable.pizza_size_large, "60 שקלים"));
        pizza_size_models.add(new Model(R.drawable.pizza_size_small, "40 שקלים"));
        pizza_size_models.add(new Model(R.drawable.pizza_size_medium, "50 שקלים"));
        pizza_size_models.add(new Model(R.drawable.pizza_size_large, "60 שקלים"));
        pizza_size_models.add(new Model(R.drawable.pizza_size_small, "40 שקלים"));

        adapter = new Adapter(pizza_size_models, this);

        pizza_size_viewPager = findViewById(R.id.pizza_size_viewPager);
        pizza_size_viewPager.setAdapter(adapter);
        pizza_size_viewPager.setCurrentItem(1);
        pizza_size_viewPager.setPadding(0, 0, 0, 0);

        Intent intent = getIntent();
        mushrooms_visible = intent.getIntExtra(Toppings.MUSHROOMVISIBLE,0);
        olives_visible = intent.getIntExtra(Toppings.OLIVESVISIBLE,0);
        tomatos_visible = intent.getIntExtra(Toppings.TOMATOVISIBLE,0);
        onion_visible = intent.getIntExtra(Toppings.ONIONVISIBLE,0);
        pineapple_visible = intent.getIntExtra(Toppings.PINEAPPLEVISIBLE,0);

        add_size_price();

        address = intent.getStringExtra(Drinks.ADDRESS);
        phone_number = intent.getStringExtra(Drinks.PHONENUMBER);

        pizza_size_viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int lastPageIndex = pizza_size_models.size() - 1;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pizza_size=position;
                add_size_price();
                mCurrentPosition = position;
                pizza_size=mCurrentPosition;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (mCurrentPosition == 0) {
                    pizza_size_viewPager.setCurrentItem(lastPageIndex - 1, false);
                } else if (mCurrentPosition == lastPageIndex) {
                    pizza_size_viewPager.setCurrentItem(1, false);
                }
            }
        });
    }

    public void launchToppingsPage(View view) {
        Intent ToppingsIntent = new Intent(this, Toppings.class);
        ToppingsIntent.putExtra(SIZEPRICE,size_price);
        ToppingsIntent.putExtra(PIZZASIZE,pizza_size);
        ToppingsIntent.putExtra(TOPPINGSPRICE,toppings_price);
        ToppingsIntent.putExtra(DRINKSPRICE,drink_price);
        ToppingsIntent.putExtra(DRINKTYPE,drink_type);
        ToppingsIntent.putExtra(MUSHROOMVISIBLE,mushrooms_visible);
        ToppingsIntent.putExtra(OLIVESVISIBLE,olives_visible);
        ToppingsIntent.putExtra(TOMATOVISIBLE,tomatos_visible);
        ToppingsIntent.putExtra(ONIONVISIBLE,onion_visible);
        ToppingsIntent.putExtra(PINEAPPLEVISIBLE,pineapple_visible);
        ToppingsIntent.putExtra(ADDRESS,address);
        ToppingsIntent.putExtra(PHONENUMBER,phone_number);
        startActivity(ToppingsIntent);
    }

    public void choosePizzaSize(View view) {

    }



    public void add_size_price()
    {
        if(pizza_size==1)
            size_price=40;
        if(pizza_size==2)
            size_price=50;
        if(pizza_size==3)
            size_price=60;
    }
}
