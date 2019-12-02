package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Customer_Details extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.pizzapp.extra.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.pizzapp.extra.MESSAGE2";

    private EditText AdressEditText;
    private String howToPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer__details);
        AdressEditText = findViewById(R.id.editText_Adress);
    }

    public void launchCredit(View view) {
        Intent intent = new Intent(this, Credit.class);
        howToPay = "Credit Card";
        intent.putExtra(EXTRA_MESSAGE2, howToPay);
        startActivity(intent);
    }

    public void launchLastScreen(View view) {
        Intent intent = new Intent(this, LastScreen.class);
        howToPay = "Cash";
        String messageAdress = AdressEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, messageAdress);
        intent.putExtra(EXTRA_MESSAGE2, howToPay);
        startActivity(intent);
    }
}
