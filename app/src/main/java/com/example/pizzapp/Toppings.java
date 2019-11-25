package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Toppings extends AppCompatActivity {

int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppings);
        a=0;
    }

    public void showMashroom(View view) {
        a=1;


    }


    public void launchHomePage(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void launchDrinksPage(View view) {
        Intent intent = new Intent(this, Activity_drinks.class);
        startActivity(intent);
    }
}
