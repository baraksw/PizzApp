package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Credit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
    }

    public void launchCustomerDetails(View view) {
        Intent intent = new Intent(this, Customer_Details.class);
        startActivity(intent);





    }
}
