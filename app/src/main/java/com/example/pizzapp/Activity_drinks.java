package com.example.pizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_drinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
    }

    public void launchPaymentPage(View view) {
        Intent intent = new Intent(this, );
        startActivity(intent);
    }

    public void launchToppingsPage(View view) {
        Intent intent = new Intent(this, Toppings.class);
        startActivity(intent);
    }
}

