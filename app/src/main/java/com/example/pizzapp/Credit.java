package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Credit extends AppCompatActivity {

    private EditText numOfCard;
    private EditText cvv;
    private EditText validity;
    private EditText email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
        numOfCard = findViewById(R.id.numOfCard_editText);
        cvv = findViewById(R.id.CVV_editText);
        validity = findViewById(R.id.validity_editText);
        email = findViewById(R.id.email_editText);
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
        startActivity(intent);
    }
}
