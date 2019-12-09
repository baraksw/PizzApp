package com.example.pizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class Drinks extends AppCompatActivity {

  
    ViewPager drinks_viewPager;
    Adapter drinks_adapter;
    List<Model> drinks_models;

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

    private int size_price=0;
    private int toppings_price=0;
    private int drink_price=0;
    private int pizza_size=0;
    private int drink_type=1;
    private int total_price=0;



    public int flag=0;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;

    private int mushrooms_visible, olives_visible, onion_visible, tomatos_visible , pineapple_visible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        Intent intent = getIntent();


        mushrooms_visible = intent.getIntExtra(Toppings.MUSHROOMVISIBLE,0);
        olives_visible = intent.getIntExtra(Toppings.OLIVESVISIBLE,0);
        tomatos_visible = intent.getIntExtra(Toppings.TOMATOVISIBLE,0);
        onion_visible = intent.getIntExtra(Toppings.ONIONVISIBLE,0);
        pineapple_visible = intent.getIntExtra(Toppings.PINEAPPLEVISIBLE,0);
        pizza_size=intent.getIntExtra(Toppings.PIZZASIZE,0);

        size_price = intent.getIntExtra(Toppings.SIZEPRICE,0);
        toppings_price = intent.getIntExtra(Toppings.TOPPINGSPRICE,0);
        drink_price = intent.getIntExtra(Toppings.DRINKSPRICE,0);
        add_price();
        total_price = size_price+toppings_price+drink_price;


        drinks_models = new ArrayList<>();
        drinks_models.add(new Model(R.drawable.coke_bottle, "7 שקלים"));
        drinks_models.add(new Model(R.drawable.sprite_bottle, "7 שקלים"));
        drinks_models.add(new Model(R.drawable.fanta_bottle, "7 שקלים"));

        drinks_adapter = new Adapter(drinks_models, this);

        drinks_viewPager = findViewById(R.id.drinks_viewPager);
        drinks_viewPager.setAdapter(drinks_adapter);
        drinks_viewPager.setPadding(130, 0, 0, 130);

        drinks_viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                drink_type=position+1;
                add_price();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    public void add_price() {
        if(drink_type!=0)
            drink_price=7;
        else
            drink_price=0;

        total_price=drink_price+toppings_price+size_price;
    }

    public void launchToppingsPage(View view) {
        Intent toppingsIntent = new Intent(this, Toppings.class);
        toppingsIntent.putExtra(SIZEPRICE,size_price);
        toppingsIntent.putExtra(PIZZASIZE,pizza_size);
        toppingsIntent.putExtra(TOPPINGSPRICE,toppings_price);
        toppingsIntent.putExtra(DRINKSPRICE,drink_price);
        toppingsIntent.putExtra(DRINKTYPE,drink_type);
        toppingsIntent.putExtra(MUSHROOMVISIBLE,mushrooms_visible);
        toppingsIntent.putExtra(OLIVESVISIBLE,olives_visible);
        toppingsIntent.putExtra(TOMATOVISIBLE,tomatos_visible);
        toppingsIntent.putExtra(ONIONVISIBLE,onion_visible);
        toppingsIntent.putExtra(PINEAPPLEVISIBLE,pineapple_visible);
        startActivity(toppingsIntent);

    }

    public void launchCustomerDetailsPage(View view) {
        Intent customerDetailsIntent = new Intent(this, CustomerDetails.class);
        total_price = drink_price+size_price+toppings_price;
        customerDetailsIntent.putExtra(SIZEPRICE,size_price);
        customerDetailsIntent.putExtra(PIZZASIZE,pizza_size);
        customerDetailsIntent.putExtra(TOPPINGSPRICE,toppings_price);
        customerDetailsIntent.putExtra(DRINKSPRICE,drink_price);
        customerDetailsIntent.putExtra(DRINKTYPE,drink_type);
        customerDetailsIntent.putExtra(MUSHROOMVISIBLE,mushrooms_visible);
        customerDetailsIntent.putExtra(OLIVESVISIBLE,olives_visible);
        customerDetailsIntent.putExtra(TOMATOVISIBLE,tomatos_visible);
        customerDetailsIntent.putExtra(ONIONVISIBLE,onion_visible);
        customerDetailsIntent.putExtra(PINEAPPLEVISIBLE,pineapple_visible);
        startActivity(customerDetailsIntent);

    }


}


