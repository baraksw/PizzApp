package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LastScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_screen);
        Intent intent = getIntent();
        String message = intent.getStringExtra(CustomerDetails.EXTRA_MESSAGE);
        String howToPay;

        howToPay = intent.getStringExtra(CustomerDetails.EXTRA_MESSAGE2);
        howToPay = intent.getStringExtra(Credit.EXTRA_MESSAGE3);
        TextView textView = findViewById(R.id.text_message);
        TextView textView1 = findViewById(R.id.text_howToPay);
        textView.setText(message);
        textView1.setText(howToPay);
    }

    public void launchLastScreen(View view) {
        Intent intent = new Intent(this, LastScreen.class);
        startActivity(intent);
    }
}