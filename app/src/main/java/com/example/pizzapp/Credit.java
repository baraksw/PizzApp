package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.santalu.maskedittext.MaskEditText;

import org.w3c.dom.Text;


public class Credit extends AppCompatActivity {

    private MaskEditText numOfCard;
    private MaskEditText cvv;
    private MaskEditText validity;
    private MaskEditText email;
    TextView tuval;

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

            public String s="NON";


    private int size_price = 0;
    private int toppings_price = 0;
    private int drink_price = 0;
    private int pizza_size = 0;
    private int drink_type = 0;
    private int total_price = 0;
    private int topping = 0;
    private int mushrooms_visible, olives_visible, onion_visible, tomatos_visible, pineapple_visible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
        numOfCard = findViewById(R.id.numOfCard_editText);
        cvv = findViewById(R.id.CVV_editText);
        validity = findViewById(R.id.validity_editText);
        email = findViewById(R.id.email_editText);

        s=String.valueOf(numOfCard);
        tuval=findViewById(R.id.textView4);
        tuval.setText(s);

        Intent intent = getIntent();
        size_price=intent.getIntExtra(CustomerDetails.SIZEPRICE,0);
        toppings_price=intent.getIntExtra(CustomerDetails.TOPPINGSPRICE,0);
        drink_price=intent.getIntExtra(CustomerDetails.DRINKSPRICE,0);
        pizza_size=intent.getIntExtra(CustomerDetails.PIZZASIZE,0);
        drink_type=intent.getIntExtra(CustomerDetails.DRINKTYPE,0);
        mushrooms_visible = intent.getIntExtra(CustomerDetails.MUSHROOMVISIBLE, 0);
        olives_visible = intent.getIntExtra(CustomerDetails.OLIVESVISIBLE, 0);
        tomatos_visible = intent.getIntExtra(CustomerDetails.TOMATOVISIBLE, 0);
        onion_visible = intent.getIntExtra(CustomerDetails.ONIONVISIBLE, 0);
        pineapple_visible = intent.getIntExtra(CustomerDetails.PINEAPPLEVISIBLE, 0);

    }

    public void launchLastScreen(View view) {
        if ((TextUtils.isEmpty(numOfCard.getText().toString())) || (TextUtils.isEmpty(cvv.getText().toString())) || (TextUtils.isEmpty(validity.getText().toString())) || (TextUtils.isEmpty(email.getText().toString()))) {
            Toast.makeText(Credit.this, "נא למלא את כל השדות", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, LastScreen.class);
            startActivity(intent);
        }
    }

    public void launchCustomerDetailsPage(View view) {
        Intent intent = new Intent(this, CustomerDetails.class);
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
