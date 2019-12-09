package com.example.pizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Drinks extends AppCompatActivity {

    public static final String DRINKSPRICE = "price_for_pizza";
    public static final String MUSHROOMVISIBLE = "mushroom_visable";
    public static final String OLIVESVISIBLE = "olives_visable";
    public static final String TOMATOVISIBLE = "tomato_visable";
    public static final String ONIONVISIBLE = "onion_visable";
    public static final String PINEAPPLEVISIBLE = "pineapple_visable";
    public static final String DRINKTYPE="drink_type";

    private int drink_type=0;
    private int pizza_price_for_toppings=0;
    private int pizza_price_for_drink=0;
    private int drinks_price=0;

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

        pizza_price_for_toppings = intent.getIntExtra(Toppings.TOPPINGSPRICE,0);
        mushrooms_visible = intent.getIntExtra(Toppings.MUSHROOMVISIBLE,0);
        olives_visible = intent.getIntExtra(Toppings.OLIVESVISIBLE,0);
        tomatos_visible = intent.getIntExtra(Toppings.TOMATOVISIBLE,0);
        onion_visible = intent.getIntExtra(Toppings.ONIONVISIBLE,0);
        pineapple_visible = intent.getIntExtra(Toppings.PINEAPPLEVISIBLE,0);
        TextView textView1 = findViewById(R.id.tomer_text);
        textView1.setText(String.valueOf(pizza_price_for_toppings));

    }


    public void add_cola(View view)
    {
        if(drink_type==1)
            drink_type=0;
        else
            drink_type=1;
        add_price(view);
    }

    public void add_sprite(View view)
    {
        if(drink_type==2)
            drink_type=0;
        else
            drink_type=2;
        add_price(view);
    }

    public void add_fanta(View view)
    {
        if(drink_type==3)
            drink_type=0;
        else
            drink_type=3;
        add_price(view);
    }

    public void add_price(View view) {
        if(drink_type!=0)
            drinks_price=7;
        else
            drinks_price=0;

        pizza_price_for_drink = pizza_price_for_toppings+drinks_price;
        TextView textView1 = findViewById(R.id.tomer_text);
        textView1.setText(String.valueOf(pizza_price_for_drink));
    }

    public void launchToppingsPage(View view) {
        Intent toppingsIntent = new Intent(this, Toppings.class);
        toppingsIntent.putExtra(DRINKSPRICE,pizza_price_for_drink);
        toppingsIntent.putExtra(MUSHROOMVISIBLE,mushrooms_visible);
        toppingsIntent.putExtra(OLIVESVISIBLE,olives_visible);
        toppingsIntent.putExtra(TOMATOVISIBLE,tomatos_visible);
        toppingsIntent.putExtra(ONIONVISIBLE,onion_visible);
        toppingsIntent.putExtra(PINEAPPLEVISIBLE,pineapple_visible);
        startActivity(toppingsIntent);

    }

    public void launchCustomerDetailsPage(View view) {
        Intent customerDetailsIntent = new Intent(this, CustomerDetails.class);
        pizza_price_for_drink = drinks_price+pizza_price_for_toppings;
        customerDetailsIntent.putExtra(DRINKSPRICE,pizza_price_for_drink);
        customerDetailsIntent.putExtra(MUSHROOMVISIBLE,mushrooms_visible);
        customerDetailsIntent.putExtra(OLIVESVISIBLE,olives_visible);
        customerDetailsIntent.putExtra(TOMATOVISIBLE,tomatos_visible);
        customerDetailsIntent.putExtra(ONIONVISIBLE,onion_visible);
        customerDetailsIntent.putExtra(PINEAPPLEVISIBLE,pineapple_visible);
        customerDetailsIntent.putExtra(DRINKTYPE,drink_type);
        startActivity(customerDetailsIntent);

    }


}


