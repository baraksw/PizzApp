package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class HomePage extends AppCompatActivity {
    private static final String LOG_TAG = HomePage.class.getSimpleName();

    public static final String SIZEPRICE = "price_for_size";
    private int size_price=0;
    public boolean personal_flag=false,family_flag=false,big_flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

    }

    public void launchToppingsPage(View view) {
        Intent ToppingsIntent = new Intent(this, Toppings.class);
        ToppingsIntent.putExtra(SIZEPRICE,size_price);
        startActivity(ToppingsIntent);
    }

    public void choosePizzaSize(View view) {

    }

    public void personal_size(View view) {
        personal_flag=true;
        family_flag=false;
        big_flag=false;
        size_price=40;
    }

    public void family_size(View view) {
        personal_flag=false;
        family_flag=true;
        big_flag=false;
        size_price=50;
    }

    public void big_size(View view) {
        personal_flag=false;
        family_flag=false;
        big_flag=true;
        size_price=60;

    }
}
