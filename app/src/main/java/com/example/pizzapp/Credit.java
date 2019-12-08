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
        startActivity(intent);
    }

    public void launchCustomerDetailsPage(View view) {
        Intent intent = new Intent(this, CustomerDetails.class);
        startActivity(intent);
    }
}
