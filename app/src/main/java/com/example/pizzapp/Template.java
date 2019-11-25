package com.example.pizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Template extends AppCompatActivity {

    private ImageView mashrooms_image;
    private boolean mashrooms_view=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        mashrooms_image = findViewById(R.id.mashrooms);
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


}
