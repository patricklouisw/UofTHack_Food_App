package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class RestaurantMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_main_page);

        TextView mouthsFednumber = (TextView) findViewById(R.id.textView3);
        mouthsFednumber.setText("0");
    }

    public void toLoactionSearch(View view) {

    }

    public void toLeaderboard(View view) {
        Intent i = new Intent(RestaurantMainPage.this, Leaderboard.class);
        startActivity(i);

    }

    public void toMainActivity(View view) {

        Intent i = new Intent(RestaurantMainPage.this, MainActivity.class);
        startActivity(i);
    }
}
