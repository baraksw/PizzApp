package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class CreditOrCash extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_or_cash);
    }

    public void launchCredit(View view) {
        Intent intent = new Intent(this, Credit.class);
        startActivity(intent);
    }
}
