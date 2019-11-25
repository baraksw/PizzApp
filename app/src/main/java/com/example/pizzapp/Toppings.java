package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

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


}
