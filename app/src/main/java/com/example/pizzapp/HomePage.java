package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class HomePage extends AppCompatActivity {
    private static final String LOG_TAG = HomePage.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchToppingsPage(View view) {
        Log.d(LOG_TAG, "Next button clicked!");
        Intent intent = new Intent(this, Toppings.class);
        startActivity(intent);
    }

    private void startActivity(Intent intent) {
    }
}
