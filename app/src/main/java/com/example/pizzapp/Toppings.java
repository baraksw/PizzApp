package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Toppings extends AppCompatActivity {

    public static final String TOPPINGSPRICE = "price_for_toppings";
    public static final String MUSHROOMVISIBLE = "mushroom_visable";
    public static final String OLIVESVISIBLE = "olives_visable";
    public static final String TOMATOVISIBLE = "tomato_visable";
    public static final String ONIONVISIBLE = "onion_visable";
    public static final String PINEAPPLEVISIBLE = "pineapple_visable";
    private int pizza_price_for_size=0;
    private int pizza_price_for_toppings=0;
    private int toppings_price=0;

    private int topping;
    private ImageView mushrooms_image_r, mushrooms_image_l;
    private ImageView olives_image_r, olives_image_l;
    private ImageView onion_image_r, onion_image_l;
    private ImageView tomato_image_r, tomato_image_l;
    private ImageView pineapple_image_r, pineapple_image_l;

    private int mushrooms_visible = 0, olives_visible = 0, onion_visible = 0, tomatos_visible = 0, pineapple_visible = 0;
    private int toppings_visible[]={mushrooms_visible,olives_visible,olives_visible,tomatos_visible,pineapple_visible};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppings);

        Intent intent = getIntent();
        pizza_price_for_size = intent.getIntExtra(HomePage.SIZEPRICE,0);
        pizza_price_for_toppings=pizza_price_for_size;
        TextView current_price_view = findViewById(R.id.Current_Price);
        current_price_view.setText(String.valueOf(pizza_price_for_toppings));

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


    }

    public void showView(View view, ImageView vr, ImageView vl, int vis) {
        switch (vis) {
            case 0:
                vr.setVisibility(View.INVISIBLE);
                vl.setVisibility(View.INVISIBLE);
                break;
            case 1:
                vr.setVisibility(View.VISIBLE);
                vl.setVisibility(View.VISIBLE);
                 break;
            case 2:
                vr.setVisibility(View.VISIBLE);
                vl.setVisibility(View.INVISIBLE);
                break;
            case 3:
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

    public void showOlives(View view) {
        topping=4;
    }

    public void showFull(View view) {
        switch(topping) {
            case 0:
                if(mushrooms_visible==1)
                    mushrooms_visible=0;
                else
                    mushrooms_visible=1;
                break;
            case 1:
                if(onion_visible==1)
                    onion_visible=0;
                else
                    onion_visible=1;
                break;
            case 2:
                if(tomatos_visible==1)
                    tomatos_visible=0;
                else
                    tomatos_visible=1;
                break;
            case 3:
                if(pineapple_visible==1)
                    pineapple_visible=0;
                else
                    pineapple_visible=1;
                break;
            case 4:
                if(olives_visible==1)
                    olives_visible=0;
                else
                    olives_visible=1;
                break;
        }

        add_toppings_price();
        add_topping(view);
    }

    public void showR_half(View view) {
        switch(topping) {
            case 0:
                if(mushrooms_visible==2)
                    mushrooms_visible=0;
                else
                    mushrooms_visible=2;
                break;

            case 1:
                if(onion_visible==2)
                    onion_visible=0;
                else
                    onion_visible=2;
                break;
            case 2:
                if(tomatos_visible==2)
                    tomatos_visible=0;
                else
                    tomatos_visible=2;
                break;
            case 3:
                if(pineapple_visible==2)
                    pineapple_visible=0;
                else
                    pineapple_visible=2;
                break;
            case 4:
                if(olives_visible==2)
                    olives_visible=0;
                else
                    olives_visible=2;
                break;
        }

        add_toppings_price();
        add_topping(view);
    }

    public void showL_half(View view) {
        switch(topping) {
            case 0:
                if(mushrooms_visible==3)
                    mushrooms_visible=0;
                else
                    mushrooms_visible=3;
                break;
            case 1:
                if(onion_visible==3)
                    onion_visible=0;
                else
                    onion_visible=3;
                break;
            case 2:
                if(tomatos_visible==3)
                    tomatos_visible=0;
                else
                    tomatos_visible=3;
                break;
            case 3:
                if(pineapple_visible==3)
                    pineapple_visible=0;
                else
                    pineapple_visible=3;
                break;
            case 4:
                if(olives_visible==3)
                    olives_visible=0;
                else
                    olives_visible=3;
                break;
        }
        add_toppings_price();
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


    public void add_toppings_price(){
        toppings_price=0;

        if(mushrooms_visible==1)
            toppings_price+=10;
        if(mushrooms_visible==2)
            toppings_price+=5;
        if(mushrooms_visible==3)
            toppings_price+=5;

        if(olives_visible==1)
            toppings_price+=10;
        if(olives_visible==2)
            toppings_price+=5;
        if(olives_visible==3)
            toppings_price+=5;

        if(onion_visible==1)
            toppings_price+=10;
        if(onion_visible==2)
            toppings_price+=5;
        if(onion_visible==3)
            toppings_price+=5;

        if(tomatos_visible==1)
            toppings_price+=10;
        if(tomatos_visible==2)
            toppings_price+=5;
        if(tomatos_visible==3)
            toppings_price+=5;

        if(pineapple_visible==1)
            toppings_price+=10;
        if(pineapple_visible==2)
            toppings_price+=5;
        if(pineapple_visible==3)
            toppings_price+=5;

        pizza_price_for_toppings=toppings_price+pizza_price_for_size;
        TextView current_price_view = findViewById(R.id.Current_Price);
        current_price_view.setText(String.valueOf(pizza_price_for_toppings));

    }


    public void launchHomePage(View view) {
        Intent homePageIntent = new Intent(this, HomePage.class);
        startActivity(homePageIntent);
    }

    public void launchDrinksPage(View view) {
        Intent drinksIntent = new Intent(this, Drinks.class);
        /*pizza_price_for_toppings=toppings_price+pizza_price_for_size;*/
        drinksIntent.putExtra(TOPPINGSPRICE,pizza_price_for_toppings);
        drinksIntent.putExtra(MUSHROOMVISIBLE,mushrooms_visible);
        drinksIntent.putExtra(OLIVESVISIBLE,olives_visible);
        drinksIntent.putExtra(TOMATOVISIBLE,tomatos_visible);
        drinksIntent.putExtra(ONIONVISIBLE,onion_visible);
        drinksIntent.putExtra(PINEAPPLEVISIBLE,pineapple_visible);
        startActivity(drinksIntent);
    }
}

