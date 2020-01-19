package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class RestaurantMainPage extends AppCompatActivity {

    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_main_page);

        TextView mouthsFednumber = (TextView) findViewById(R.id.textView3);

        Intent intent = getIntent();
        email = intent.getExtras().getString("EMAIL");
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());

        mouthsFednumber.setText(db.totalContribution());
    }

    public void toLocationSearch(View view) {

    }

    public void toLeaderboard(View view) {
        Intent i = new Intent(RestaurantMainPage.this, Leaderboard.class);
        i.putExtra("EMAIL", email);
        startActivity(i);
    }

    public void toMainActivity(View view) {
        Intent i = new Intent(RestaurantMainPage.this, MainActivity.class);
        startActivity(i);
    }
}
