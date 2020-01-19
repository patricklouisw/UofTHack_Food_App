package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.ImageButton;

public class MainPage extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

    }

    public void toPoints(View view) {
        Intent i = new Intent(MainPage.this, UserPoints.class);
        startActivity(i);

    }

    public void toLeaderboard(View view) {
        Intent i = new Intent(MainPage.this, Leaderboard.class);
        startActivity(i);

    }

    public void toMainActivity(View view) {

        Intent i = new Intent(MainPage.this, MainActivity.class);
        startActivity(i);
    }

}
