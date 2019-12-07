package com.example.pizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Drinks extends AppCompatActivity {

    public static final String DRINKSPRICE = "price_for_pizza";
    private String pizza_price;
    private String total_price;
    private int drinks_price=0;

    public int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        Intent intent = getIntent();
        String pizza_price_for_toppings = intent.getStringExtra(Toppings.TOPPINGSPRICE);
        pizza_price=pizza_price_for_toppings;

        TextView textView1 = findViewById(R.id.tomer_text);
        textView1.setText(pizza_price_for_toppings);


    }


    public void add_price(View view) {
        if (flag==1) {
            drinks_price -= 7;
            flag = 0;
        } else {
            drinks_price += 7;
            flag = 1;
        }
    }

    public void launchToppingsPage(View view) {
        Intent toppingsIntent = new Intent(this, Toppings.class);
        startActivity(toppingsIntent);

    }

    public void launchCustomerDetailsPage(View view) {
        Intent customerDetailsIntent = new Intent(this, CustomerDetails.class);
        total_price+=Integer.parseInt(pizza_price)+drinks_price;

        customerDetailsIntent.putExtra(DRINKSPRICE,total_price);
        startActivity(customerDetailsIntent);

    }


}


