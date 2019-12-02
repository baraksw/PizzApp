package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class Toppings extends AppCompatActivity {

    private int topping;
    private ImageView mushrooms_image_r, mushrooms_image_l;
    private ImageView olives_image_r, olives_image_l;
    private ImageView onion_image_r, onion_image_l;
    private ImageView tomato_image_r, tomato_image_l;
    private ImageView pineapple_image_r, pineapple_image_l;
    private ImageView cheese_image_r, cheese_image_l;
    private int mushrooms_visible = 0, olives_visible = 0, onion_visible = 0, tomatos_visible = 0, pineapple_visible = 0, cheese_visible = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppings);
        mushrooms_image_r = findViewById(R.id.mushrooms_r);
        mushrooms_image_l = findViewById(R.id.mushrooms_l);
        olives_image_r = findViewById(R.id.olives_r);
        olives_image_l = findViewById(R.id.olives_l);
        onion_image_r = findViewById(R.id.onion_r);
        onion_image_l = findViewById(R.id.onion_l);
        tomato_image_r = findViewById(R.id.tomato_r);
        tomato_image_l = findViewById(R.id.tomato_l);
        pineapple_image_r = findViewById(R.id.pineapple_r);
        pineapple_image_l = findViewById(R.id.pineapple_l);
        /*cheese_image_r = findViewById(R.id.cheese_r);
        cheese_image_l = findViewById(R.id.cheese_l);*/


    }

    public void showView(View view, ImageView vr, ImageView vl, int vis) {
        switch (vis) {
            case 0:
                vr.setVisibility(View.VISIBLE);
                vl.setVisibility(View.VISIBLE);
                 break;
            case 1:
                vr.setVisibility(View.VISIBLE);
                vl.setVisibility(View.INVISIBLE);
                break;
            case 2:
                vr.setVisibility(View.INVISIBLE);
                vl.setVisibility(View.VISIBLE);
                break;

        }

    }

    public void showMushroom(View view) {
        topping=0;

    }

    public void showOnion(View view) {
        topping=1;
    }

    public void showTomatos(View view) {
        topping=2;
    }

    public void showPineapple(View view) {
        topping=3;
    }

    public void showOlives(View view) {topping=4;}

    public void showFull(View view) {
        mushrooms_visible=0;
        onion_visible=0;
        tomatos_visible=0;
        pineapple_visible=0;
        olives_visible=0;
        add_topping(view);
    }

    public void showR_half(View view) {
        mushrooms_visible=1;
        onion_visible=1;
        tomatos_visible=1;
        pineapple_visible=1;
        olives_visible=1;
        add_topping(view);
    }

    public void showL_half(View view) {
        mushrooms_visible=2;
        onion_visible=2;
        tomatos_visible=2;
        pineapple_visible=2;
        olives_visible=2;
        add_topping(view);
    }

    public void add_topping(View view){
        switch(topping){
            case 0:
                showView(view, mushrooms_image_r, mushrooms_image_l, mushrooms_visible);
                break;
            case 1:
                showView(view, onion_image_r, onion_image_l, onion_visible);
                break;
            case 2:
                showView(view, tomato_image_r, tomato_image_l, tomatos_visible);
                break;
            case 3:
                showView(view, pineapple_image_r, pineapple_image_l, pineapple_visible);
                break;
            case 4:
                showView(view,olives_image_r,olives_image_l,olives_visible);
                break;

        }
    }



}

