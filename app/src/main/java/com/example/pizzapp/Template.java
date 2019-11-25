package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Template extends AppCompatActivity {

    private ImageView mashrooms_image;
    private boolean mashrooms_view=false;
    private ImageView olives_image;
    private boolean olives_view=false;
    private ImageView onion_image;
    private boolean onion_view=false;
    private ImageView tomatos_image;
    private boolean tomatos_view=false;
    private ImageView pineapple_image;
    private boolean pineapple_view=false;
    private ImageView cheese_image;
    private boolean cheese_view=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        mashrooms_image = findViewById(R.id.mashrooms);
        olives_image = findViewById(R.id.olives);
        onion_image = findViewById(R.id.onion);
        tomatos_image = findViewById(R.id.tomatos);
        pineapple_image = findViewById(R.id.pineapple);
        cheese_image = findViewById(R.id.cheese);
    }

    public void showMashroom(View view) {
        if(!mashrooms_view) {
            mashrooms_image.setVisibility(View.VISIBLE);
            mashrooms_view = true;
        }
        else {
            mashrooms_image.setVisibility(View.INVISIBLE);
            mashrooms_view = false;
        }

    }

    public void showOlives(View view) {
        if(!olives_view) {
            olives_image.setVisibility(View.VISIBLE);
            olives_view = true;
        }
        else {
            olives_image.setVisibility(View.INVISIBLE);
            olives_view = false;
        }
    }

    public void showOnion(View view) {
        if(!onion_view) {
            onion_image.setVisibility(View.VISIBLE);
            onion_view = true;
        }
        else {
            onion_image.setVisibility(View.INVISIBLE);
            onion_view = false;
        }
    }

    public void showTomatos(View view) {
        if(!tomatos_view) {
            tomatos_image.setVisibility(View.VISIBLE);
            tomatos_view = true;
        }
        else {
            tomatos_image.setVisibility(View.INVISIBLE);
            tomatos_view = false;
        }
    }

    public void showPineapple(View view) {
        if(!pineapple_view) {
            pineapple_image.setVisibility(View.VISIBLE);
            pineapple_view = true;
        }
        else {
            pineapple_image.setVisibility(View.INVISIBLE);
            pineapple_view = false;
        }
    }

    public void showCheese(View view) {
        if(!cheese_view) {
            cheese_image.setVisibility(View.VISIBLE);
            cheese_view = true;
        }
        else {
            cheese_image.setVisibility(View.INVISIBLE);
            cheese_view = false;
        }
    }
}
