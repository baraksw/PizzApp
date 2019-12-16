package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.santalu.maskedittext.MaskEditText;


public class CustomerDetails extends AppCompatActivity {

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
    public static final String PHONENUMBER = "phone_number";
    public static final String ADDRESS = "address";


    private int size_price = 0;
    private int toppings_price = 0;
    private int drink_price = 0;
    private int pizza_size = 0;
    private int drink_type = 0;
    private int total_price = 0;
    private int topping = 0;
    private int mushrooms_visible, olives_visible, onion_visible, tomatos_visible, pineapple_visible;

    private String phone_number = "NULL";
    private String address = "NULL";


    private EditText AddressEditText;
    private MaskEditText PhoneNumberEditText;

    private ImageView mushrooms_image_right, mushrooms_image_left;
    private ImageView olives_image_right, olives_image_left;
    private ImageView onion_image_right, onion_image_left;
    private ImageView tomato_image_right, tomato_image_left;
    private ImageView pineapple_image_right, pineapple_image_left;
    private ImageView cola_view;
    private ImageView fanta_view;
    private ImageView sprite_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        AddressEditText = findViewById(R.id.address_editText);
        PhoneNumberEditText = findViewById(R.id.phoneNumber_editText);
        PhoneNumberEditText.setText(phone_number);

        Intent intent = getIntent();
        toppings_price = intent.getIntExtra(Drinks.TOPPINGSPRICE, 0);
        drink_price = intent.getIntExtra(Drinks.DRINKSPRICE, 0);
        size_price = intent.getIntExtra(Drinks.SIZEPRICE, 0);
        total_price = toppings_price + size_price + drink_price;
        TextView current_price = findViewById(R.id.total_price_text_view);
        current_price.setText("מחיר: " + String.valueOf(total_price) + "₪");

        drink_type = intent.getIntExtra(Drinks.DRINKTYPE, 4);
        drink_type = intent.getIntExtra(Credit.DRINKTYPE, 4);
        mushrooms_visible = intent.getIntExtra(Drinks.MUSHROOMVISIBLE, 0);
        olives_visible = intent.getIntExtra(Drinks.OLIVESVISIBLE, 0);
        tomatos_visible = intent.getIntExtra(Drinks.TOMATOVISIBLE, 0);
        onion_visible = intent.getIntExtra(Drinks.ONIONVISIBLE, 0);
        pineapple_visible = intent.getIntExtra(Drinks.PINEAPPLEVISIBLE, 0);

        address = intent.getStringExtra(Credit.ADDRESS);
        AddressEditText.setText(address);

        phone_number = intent.getStringExtra(Credit.PHONENUMBER);
        PhoneNumberEditText.setText(phone_number);


        mushrooms_image_right = findViewById(R.id.mushrooms_rightHalf);
        mushrooms_image_left = findViewById(R.id.mushrooms_leftHalf);
        olives_image_right = findViewById(R.id.olives_rightHalf);
        olives_image_left = findViewById(R.id.olives_leftHalf);
        onion_image_right = findViewById(R.id.onion_rightHalf);
        onion_image_left = findViewById(R.id.onion_leftHalf);
        tomato_image_right = findViewById(R.id.tomato_rightHalf);
        tomato_image_left = findViewById(R.id.tomato_leftHalf);
        pineapple_image_right = findViewById(R.id.pineapple_rightHalf);
        pineapple_image_left = findViewById(R.id.pineapple_leftHalf);
        cola_view = findViewById(R.id.cola_drink);
        sprite_view = findViewById(R.id.sprite_drink);
        fanta_view = findViewById(R.id.fanta_drink);
        AddressEditText = findViewById(R.id.address_editText);
        PhoneNumberEditText = findViewById(R.id.phoneNumber_editText);
        show_default();

        switch (drink_type) {
            case 1: {
                cola_view.setVisibility(View.VISIBLE);
                sprite_view.setVisibility(View.INVISIBLE);
                fanta_view.setVisibility(View.INVISIBLE);
                break;
            }
            case 2: {
                cola_view.setVisibility(View.INVISIBLE);
                sprite_view.setVisibility(View.VISIBLE);
                fanta_view.setVisibility(View.INVISIBLE);
                break;
            }
            case 3: {
                cola_view.setVisibility(View.INVISIBLE);
                sprite_view.setVisibility(View.INVISIBLE);
                fanta_view.setVisibility(View.VISIBLE);
                break;
            }
            default:
                ;
        }


    }

    public void showView(ImageView right_view, ImageView left_view, int topping_visibility) {
        switch (topping_visibility) {
            case 0:
                right_view.setVisibility(View.INVISIBLE);
                left_view.setVisibility(View.INVISIBLE);
                break;
            case 1:
                right_view.setVisibility(View.VISIBLE);
                left_view.setVisibility(View.VISIBLE);
                break;
            case 2:
                right_view.setVisibility(View.VISIBLE);
                left_view.setVisibility(View.INVISIBLE);
                break;
            case 3:
                right_view.setVisibility(View.INVISIBLE);
                left_view.setVisibility(View.VISIBLE);
                break;

        }

    }

    public void showMushroom(View view) {
        topping = 0;
    }

    public void showOnion(View view) {
        topping = 1;
    }

    public void showTomatos(View view) {
        topping = 2;
    }

    public void showPineapple(View view) {
        topping = 3;
    }

    public void showOlives(View view) {
        topping = 4;
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

    public void launchCredit(View view) {
        if ((TextUtils.isEmpty(AddressEditText.getText().toString())) || (TextUtils.isEmpty(PhoneNumberEditText.getText().toString()))) {
            Toast.makeText(CustomerDetails.this, "נא למלא את כל השדות", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, Credit.class);

            address = AddressEditText.getText().toString();
            intent.putExtra(ADDRESS, address);
            phone_number = PhoneNumberEditText.getText().toString();
            intent.putExtra(PHONENUMBER, phone_number);

            intent.putExtra(SIZEPRICE, size_price);
            intent.putExtra(PIZZASIZE, pizza_size);
            intent.putExtra(TOPPINGSPRICE, toppings_price);
            intent.putExtra(DRINKSPRICE, drink_price);
            intent.putExtra(DRINKTYPE, drink_type);
            intent.putExtra(MUSHROOMVISIBLE, mushrooms_visible);
            intent.putExtra(OLIVESVISIBLE, olives_visible);
            intent.putExtra(TOMATOVISIBLE, tomatos_visible);
            intent.putExtra(ONIONVISIBLE, onion_visible);
            intent.putExtra(PINEAPPLEVISIBLE, pineapple_visible);


            startActivity(intent);
        }
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
    }

    public void launchLastScreen(View view) {
        if ((TextUtils.isEmpty(AddressEditText.getText().toString())) || (TextUtils.isEmpty(PhoneNumberEditText.getText().toString()))) {
            Toast.makeText(CustomerDetails.this, "נא למלא את כל השדות", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, LastScreen.class);
            startActivity(intent);
        }
    }

    public void launchDrinksPagePage(View view) {
        Intent intent = new Intent(this, Drinks.class);

        address = AddressEditText.getText().toString();
        intent.putExtra(ADDRESS, address);
        phone_number = PhoneNumberEditText.getText().toString();
        intent.putExtra(PHONENUMBER, phone_number);

        intent.putExtra(SIZEPRICE, size_price);
        intent.putExtra(PIZZASIZE, pizza_size);
        intent.putExtra(TOPPINGSPRICE, toppings_price);
        intent.putExtra(DRINKSPRICE, drink_price);
        intent.putExtra(DRINKTYPE, drink_type);
        intent.putExtra(MUSHROOMVISIBLE, mushrooms_visible);
        intent.putExtra(OLIVESVISIBLE, olives_visible);
        intent.putExtra(TOMATOVISIBLE, tomatos_visible);
        intent.putExtra(ONIONVISIBLE, onion_visible);
        intent.putExtra(PINEAPPLEVISIBLE, pineapple_visible);

        startActivity(intent);
    }
}
