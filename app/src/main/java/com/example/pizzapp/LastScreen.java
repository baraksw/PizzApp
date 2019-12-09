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
    }

    public void launchLastScreen(View view) {
        Intent intent = new Intent(this, LastScreen.class);
        startActivity(intent);
    }
}