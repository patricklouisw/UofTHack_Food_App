package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RestaurantLogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_main);
    }

    public void toLogIn(View view) {
        Intent i = new Intent(getApplicationContext(), RestaurantMainPage.class);
        startActivity(i);
    }

    public void toSignUp(View view) {
        Intent i = new Intent(getApplicationContext(), SignUpRestaurant.class);
        startActivity(i);
    }
}
