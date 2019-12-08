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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        AdressEditText = findViewById(R.id.editText_adress);
        Intent intent = getIntent();
        String pizza_price_for_details = intent.getStringExtra(Drinks.DRINKSPRICE);
        TextView textView1 = findViewById(R.id.tomer_view);
        textView1.setText(pizza_price_for_details);
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
