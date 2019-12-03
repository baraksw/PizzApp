package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Credit extends AppCompatActivity {

    public static final String EXTRA_MESSAGE3 = "com.example.pizzapp.extra.MESSAGE3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
    }

    public void launchLastScreen(View view) {
        Intent intent = new Intent(this, LastScreen.class);
        String howToPay = intent.getStringExtra(CustomerDetails.EXTRA_MESSAGE2);
        intent.putExtra(EXTRA_MESSAGE3, howToPay);
        startActivity(intent);
    }

    public void launchToppingsPage(View view) {
        Intent intent = new Intent(this, Toppings.class);
        startActivity(intent);
    }
}
