package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class CustomerDetails extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.pizzapp.extra.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.pizzapp.extra.MESSAGE2";
    private EditText AdressEditText;
    private String howToPay;
    private int pizza_price_for_drink;
    private int mushrooms_visible, olives_visible, onion_visible, tomatos_visible , pineapple_visible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        AdressEditText = findViewById(R.id.editText_adress);

        Intent intent = getIntent();
        pizza_price_for_drink = intent.getIntExtra(Drinks.DRINKSPRICE,0);
        TextView current_price = findViewById(R.id.tomer_view);
        current_price.setText(String.valueOf(pizza_price_for_drink));

        mushrooms_visible = intent.getIntExtra(Toppings.MUSHROOMVISIBLE,0);
        olives_visible = intent.getIntExtra(Toppings.OLIVESVISIBLE,0);
        tomatos_visible = intent.getIntExtra(Toppings.TOMATOVISIBLE,0);
        onion_visible = intent.getIntExtra(Toppings.ONIONVISIBLE,0);
        pineapple_visible = intent.getIntExtra(Toppings.PINEAPPLEVISIBLE,0);
    }

    public void launchCredit(View view) {
        Intent intent = new Intent(this, Credit.class);
        howToPay = "Credit Card";
        intent.putExtra(EXTRA_MESSAGE2, howToPay);
        startActivity(intent);
    }

    public void launchLastScreen(View view) {
        Intent intent = new Intent(this, LastScreen.class);
        howToPay = "Cash";
        String messageAdress = AdressEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, messageAdress);
        intent.putExtra(EXTRA_MESSAGE2, howToPay);
        startActivity(intent);
    }

    public void launchToppingsPage(View view) {
        Intent intent = new Intent(this, Credit.class);
        startActivity(intent);

    }
}
