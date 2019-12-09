package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Toppings extends AppCompatActivity {

    public static final String SIZEPRICE = "price_for_size";
    public static final String PIZZASIZE = "size_of_pizza";
    public static final String DRINKSPRICE = "price_for_drink";
    public static final String DRINKTYPE = "drink_type";
    public static final String TOPPINGSPRICE = "price_for_toppings";
    public static final String MUSHROOMVISIBLE = "mushroom_visable";
    public static final String OLIVESVISIBLE = "olives_visable";
    public static final String TOMATOVISIBLE = "tomato_visable";
    public static final String ONIONVISIBLE = "onion_visable";
    public static final String PINEAPPLEVISIBLE = "pineapple_visable";

    private int size_price = 0;
    private int toppings_price = 0;
    private int drink_price = 0;
    private int pizza_size = 0;
    private int drink_type = 0;
    private int total_price = 0;
    private int topping;

    private boolean is_mushroom_pressed = false;
    private boolean is_tomato_pressed = false;
    private boolean is_onion_pressed = false;
    private boolean is_pineapple_pressed = false;
    private boolean is_olives_pressed = false;

    private ImageView mushrooms_image_right, mushrooms_image_left;
    private ImageView olives_image_right, olives_image_left;
    private ImageView onion_image_right, onion_image_left;
    private ImageView tomato_image_right, tomato_image_left;
    private ImageView pineapple_image_right, pineapple_image_left;
    private Button button_mushrooms;
    private Button button_olives;
    private Button button_tomato;
    private Button button_onion;
    private Button button_pineapple;


    private int mushrooms_visible, olives_visible, onion_visible, tomatos_visible, pineapple_visible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppings);

        Intent intent = getIntent();
        mushrooms_visible = 0;
        olives_visible = 0;
        onion_visible = 0;
        tomatos_visible = 0;
        pineapple_visible = 0;

        mushrooms_visible = intent.getIntExtra(Drinks.MUSHROOMVISIBLE, 0);
        olives_visible = intent.getIntExtra(Drinks.OLIVESVISIBLE, 0);
        tomatos_visible = intent.getIntExtra(Drinks.TOMATOVISIBLE, 0);
        onion_visible = intent.getIntExtra(Drinks.ONIONVISIBLE, 0);
        pineapple_visible = intent.getIntExtra(Drinks.PINEAPPLEVISIBLE, 0);
        pizza_size = intent.getIntExtra(HomePage.PIZZASIZE, 0);
        drink_type = intent.getIntExtra(Drinks.DRINKTYPE, 0);
        size_price = intent.getIntExtra(HomePage.SIZEPRICE, 0);
        toppings_price = intent.getIntExtra(HomePage.TOPPINGSPRICE, 0);
        drink_price = intent.getIntExtra(HomePage.DRINKSPRICE, 0);
        total_price = size_price + toppings_price + drink_price;

        add_toppings_price();
        total_price = intent.getIntExtra(Drinks.DRINKSPRICE, 0);

        TextView current_price_view = findViewById(R.id.Current_Price);
        current_price_view.setText(String.valueOf(total_price));
        mushrooms_image_right = findViewById(R.id.mushrooms_r);
        mushrooms_image_left = findViewById(R.id.mushrooms_l);
        olives_image_right = findViewById(R.id.olives_r);
        olives_image_left = findViewById(R.id.olives_l);
        onion_image_right = findViewById(R.id.onion_r);
        onion_image_left = findViewById(R.id.onion_l);
        tomato_image_right = findViewById(R.id.tomato_r);
        tomato_image_left = findViewById(R.id.tomato_l);
        pineapple_image_right = findViewById(R.id.pineapple_r);
        pineapple_image_left = findViewById(R.id.pineapple_l);
        button_mushrooms = findViewById(R.id.Topping_Mushrooms);
        button_olives = findViewById(R.id.Topping_Olives);
        button_onion = findViewById(R.id.Topping_Onion);
        button_pineapple = findViewById(R.id.Topping_Pineapple);
        button_tomato = findViewById(R.id.Topping_Tomatos);

        show_default();
    }

    public void showView(ImageView view_right, ImageView view_left, int topping_visibility) {
        switch (topping_visibility) {
            case 0:
                view_right.setVisibility(View.INVISIBLE);
                view_left.setVisibility(View.INVISIBLE);
                break;
            case 1:
                view_right.setVisibility(View.VISIBLE);
                view_left.setVisibility(View.VISIBLE);
                break;
            case 2:
                view_right.setVisibility(View.VISIBLE);
                view_left.setVisibility(View.INVISIBLE);
                break;
            case 3:
                view_right.setVisibility(View.INVISIBLE);
                view_left.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void showMushroom(View view) {
        topping = 0;
        if (!is_mushroom_pressed) {
            button_mushrooms.setBackgroundResource(R.drawable.toppings_button_clicked_shape);
            button_tomato.setBackgroundResource(R.drawable.toppings_button_shape);
            button_pineapple.setBackgroundResource(R.drawable.toppings_button_shape);
            button_onion.setBackgroundResource(R.drawable.toppings_button_shape);
            button_olives.setBackgroundResource(R.drawable.toppings_button_shape);
            is_mushroom_pressed = true;
            is_olives_pressed = false;
            is_onion_pressed = false;
            is_tomato_pressed = false;
            is_pineapple_pressed = false;
        }
        else if (is_mushroom_pressed)
            button_mushrooms.setBackgroundResource(R.drawable.toppings_button_shape);
        is_mushroom_pressed = false;
    }

    public void showOnion(View view) {
        topping = 1;
        if (!is_onion_pressed) {
            button_onion.setBackgroundResource(R.drawable.toppings_button_clicked_shape);
            button_tomato.setBackgroundResource(R.drawable.toppings_button_shape);
            button_pineapple.setBackgroundResource(R.drawable.toppings_button_shape);
            button_mushrooms.setBackgroundResource(R.drawable.toppings_button_shape);
            button_olives.setBackgroundResource(R.drawable.toppings_button_shape);
            is_mushroom_pressed = false;
            is_olives_pressed = false;
            is_onion_pressed = true;
            is_tomato_pressed = false;
            is_pineapple_pressed = false;
        }
        else if (is_onion_pressed)
            button_onion.setBackgroundResource(R.drawable.toppings_button_shape);
        is_onion_pressed = false;
    }

    public void showTomatos(View view) {
        topping = 2;
        if (!is_tomato_pressed) {
            button_tomato.setBackgroundResource(R.drawable.toppings_button_clicked_shape);
            button_onion.setBackgroundResource(R.drawable.toppings_button_shape);
            button_pineapple.setBackgroundResource(R.drawable.toppings_button_shape);
            button_mushrooms.setBackgroundResource(R.drawable.toppings_button_shape);
            button_olives.setBackgroundResource(R.drawable.toppings_button_shape);
            is_mushroom_pressed = false;
            is_olives_pressed = false;
            is_onion_pressed = false;
            is_tomato_pressed = true;
            is_pineapple_pressed = false;
        }
        else if (is_tomato_pressed)
            button_tomato.setBackgroundResource(R.drawable.toppings_button_shape);
        is_tomato_pressed = false;
    }

    public void showPineapple(View view) {
        topping = 3;
        if (!is_pineapple_pressed) {
            button_pineapple.setBackgroundResource(R.drawable.toppings_button_clicked_shape);
            button_tomato.setBackgroundResource(R.drawable.toppings_button_shape);
            button_onion.setBackgroundResource(R.drawable.toppings_button_shape);
            button_mushrooms.setBackgroundResource(R.drawable.toppings_button_shape);
            button_olives.setBackgroundResource(R.drawable.toppings_button_shape);
            is_mushroom_pressed = false;
            is_olives_pressed = false;
            is_onion_pressed = false;
            is_tomato_pressed = false;
            is_pineapple_pressed = true;
        }
        else if (is_pineapple_pressed)
            button_pineapple.setBackgroundResource(R.drawable.toppings_button_shape);
        is_pineapple_pressed = false;
    }

    public void showOlives(View view) {
        topping = 4;
        if (!is_olives_pressed) {
            button_olives.setBackgroundResource(R.drawable.toppings_button_clicked_shape);
            button_tomato.setBackgroundResource(R.drawable.toppings_button_shape);
            button_pineapple.setBackgroundResource(R.drawable.toppings_button_shape);
            button_mushrooms.setBackgroundResource(R.drawable.toppings_button_shape);
            button_onion.setBackgroundResource(R.drawable.toppings_button_shape);
            is_mushroom_pressed = false;
            is_olives_pressed = true;
            is_onion_pressed = false;
            is_tomato_pressed = false;
            is_pineapple_pressed = false;
        }
        else if (is_olives_pressed)
            button_olives.setBackgroundResource(R.drawable.toppings_button_shape);
        is_olives_pressed = false;
    }

    public void showFull(View view) {
        switch (topping) {
            case 0:
                if (mushrooms_visible == 1)
                    mushrooms_visible = 0;
                else
                    mushrooms_visible = 1;
                break;
            case 1:
                if (onion_visible == 1)
                    onion_visible = 0;
                else
                    onion_visible = 1;
                break;
            case 2:
                if (tomatos_visible == 1)
                    tomatos_visible = 0;
                else
                    tomatos_visible = 1;
                break;
            case 3:
                if (pineapple_visible == 1)
                    pineapple_visible = 0;
                else
                    pineapple_visible = 1;
                break;
            case 4:
                if (olives_visible == 1)
                    olives_visible = 0;
                else
                    olives_visible = 1;
                break;
        }

        add_topping();
        add_toppings_price();
    }

    public void showR_half(View view) {
        switch (topping) {
            case 0:
                if (mushrooms_visible == 2)
                    mushrooms_visible = 0;
                else
                    mushrooms_visible = 2;
                break;

            case 1:
                if (onion_visible == 2)
                    onion_visible = 0;
                else
                    onion_visible = 2;
                break;
            case 2:
                if (tomatos_visible == 2)
                    tomatos_visible = 0;
                else
                    tomatos_visible = 2;
                break;
            case 3:
                if (pineapple_visible == 2)
                    pineapple_visible = 0;
                else
                    pineapple_visible = 2;
                break;
            case 4:
                if (olives_visible == 2)
                    olives_visible = 0;
                else
                    olives_visible = 2;
                break;
        }

        add_topping();
        add_toppings_price();
    }

    public void showL_half(View view) {
        switch (topping) {
            case 0:
                if (mushrooms_visible == 3)
                    mushrooms_visible = 0;
                else
                    mushrooms_visible = 3;
                break;
            case 1:
                if (onion_visible == 3)
                    onion_visible = 0;
                else
                    onion_visible = 3;
                break;
            case 2:
                if (tomatos_visible == 3)
                    tomatos_visible = 0;
                else
                    tomatos_visible = 3;
                break;
            case 3:
                if (pineapple_visible == 3)
                    pineapple_visible = 0;
                else
                    pineapple_visible = 3;
                break;
            case 4:
                if (olives_visible == 3)
                    olives_visible = 0;
                else
                    olives_visible = 3;
                break;
        }

        add_topping();
        add_toppings_price();
    }


    public void add_topping() {
        switch (topping) {
            case 0:
                showView(mushrooms_image_right, mushrooms_image_left, mushrooms_visible);
                break;
            case 1:
                showView(onion_image_right, onion_image_left, onion_visible);
                break;
            case 2:
                showView(tomato_image_right, tomato_image_left, tomatos_visible);
                break;
            case 3:
                showView(pineapple_image_right, pineapple_image_left, pineapple_visible);
                break;
            case 4:
                showView(olives_image_right, olives_image_left, olives_visible);
                break;

        }
    }


    public void add_toppings_price() {
        toppings_price = 0;

        if (mushrooms_visible == 1)
            toppings_price += 10;
        if (mushrooms_visible == 2)
            toppings_price += 5;
        if (mushrooms_visible == 3)
            toppings_price += 5;

        if (olives_visible == 1)
            toppings_price += 10;
        if (olives_visible == 2)
            toppings_price += 5;
        if (olives_visible == 3)
            toppings_price += 5;

        if (onion_visible == 1)
            toppings_price += 10;
        if (onion_visible == 2)
            toppings_price += 5;
        if (onion_visible == 3)
            toppings_price += 5;

        if (tomatos_visible == 1)
            toppings_price += 10;
        if (tomatos_visible == 2)
            toppings_price += 5;
        if (tomatos_visible == 3)
            toppings_price += 5;

        if (pineapple_visible == 1)
            toppings_price += 10;
        if (pineapple_visible == 2)
            toppings_price += 5;
        if (pineapple_visible == 3)
            toppings_price += 5;

        total_price = size_price + toppings_price + drink_price;

        TextView current_price_view = findViewById(R.id.Current_Price);
        current_price_view.setText(String.valueOf(total_price)+'₪');
    }


    public void show_default() {
        topping = 0;
        add_topping();
        topping = 1;
        add_topping();
        topping = 2;
        add_topping();
        topping = 3;
        add_topping();
        topping = 4;
        add_topping();
        add_toppings_price();
    }

    public void launchHomePage(View view) {
        Intent homePageIntent = new Intent(this, HomePage.class);
        homePageIntent.putExtra(SIZEPRICE, size_price);
        homePageIntent.putExtra(PIZZASIZE, pizza_size);
        homePageIntent.putExtra(TOPPINGSPRICE, toppings_price);
        homePageIntent.putExtra(DRINKSPRICE, drink_price);
        homePageIntent.putExtra(DRINKTYPE, drink_type);
        homePageIntent.putExtra(MUSHROOMVISIBLE, mushrooms_visible);
        homePageIntent.putExtra(OLIVESVISIBLE, olives_visible);
        homePageIntent.putExtra(TOMATOVISIBLE, tomatos_visible);
        homePageIntent.putExtra(ONIONVISIBLE, onion_visible);
        homePageIntent.putExtra(PINEAPPLEVISIBLE, pineapple_visible);

        startActivity(homePageIntent);
    }

    public void launchDrinksPage(View view) {
        Intent drinksIntent = new Intent(this, Drinks.class);
        drinksIntent.putExtra(SIZEPRICE, size_price);
        drinksIntent.putExtra(PIZZASIZE, pizza_size);
        drinksIntent.putExtra(TOPPINGSPRICE, toppings_price);
        drinksIntent.putExtra(DRINKSPRICE, drink_price);
        drinksIntent.putExtra(DRINKTYPE, drink_type);
        drinksIntent.putExtra(MUSHROOMVISIBLE, mushrooms_visible);
        drinksIntent.putExtra(OLIVESVISIBLE, olives_visible);
        drinksIntent.putExtra(TOMATOVISIBLE, tomatos_visible);
        drinksIntent.putExtra(ONIONVISIBLE, onion_visible);
        drinksIntent.putExtra(PINEAPPLEVISIBLE, pineapple_visible);

        startActivity(drinksIntent);
    }
}

