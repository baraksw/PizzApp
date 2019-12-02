package com.example.pizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Drinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        Intent intent = getIntent();
        String pizza_price_for_toppings = intent.getStringExtra(Toppings.PIZZAPRICE);

        TextView textView1 = findViewById(R.id.tomer_text);
        textView1.setText(pizza_price_for_toppings);

    }

    public void launchCustomerDetailsPage(View view) {
        Intent customerDetailsIntent = new Intent(this, Customer_Details.class);
        startActivity(customerDetailsIntent);
    }

    public void launchToppingsPage(View view) {
        Intent toppingsIntent = new Intent(this, Toppings.class);
        startActivity(toppingsIntent);
    }
}

