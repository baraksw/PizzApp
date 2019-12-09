package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomerDetails extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.pizzapp.extra.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.pizzapp.extra.MESSAGE2";
    private EditText AdressEditText;
    private String howToPay; 

    private int pizza_price_for_drink;
    private int mushrooms_visible, olives_visible, onion_visible, tomatos_visible , pineapple_visible;
    private int drink_type=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        AdressEditText = findViewById(R.id.editText_adress);
        Intent intent = getIntent();
        pizza_price_for_drink = intent.getIntExtra(Drinks.DRINKSPRICE,0);
        TextView current_price = findViewById(R.id.total_price_text_view);
        current_price.setText(String.valueOf(pizza_price_for_drink));

        mushrooms_visible = intent.getIntExtra(Drinks.MUSHROOMVISIBLE,0);
        olives_visible = intent.getIntExtra(Drinks.OLIVESVISIBLE,0);
        tomatos_visible = intent.getIntExtra(Drinks.TOMATOVISIBLE,0);
        onion_visible = intent.getIntExtra(Drinks.ONIONVISIBLE,0);
        pineapple_visible = intent.getIntExtra(Drinks.PINEAPPLEVISIBLE,0);
        drink_type = intent.getIntExtra(Drinks.DRINKTYPE,0);

        ImageView cola_view = findViewById(R.id.cola_drink);
        ImageView sprite_view = findViewById(R.id.sprite_drink);
        ImageView fanta_view = findViewById(R.id.fanta_drink);

        switch(drink_type)
        {
            case 1:cola_view.setVisibility(View.VISIBLE);
            case 2:sprite_view.setVisibility(View.VISIBLE);
            case 3:fanta_view.setVisibility(View.VISIBLE);
        }
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

    public void launchDrinksPagePage(View view) {
        Intent intent = new Intent(this, Drinks.class);
        startActivity(intent);
    }
}
