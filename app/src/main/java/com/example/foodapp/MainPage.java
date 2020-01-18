package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    public void toPoints(View view) {

    }

    public void toLeaderboard(View view) {

    }

    public void toMainActivity(View view) {

        Intent i = new Intent(MainPage.this, MainActivity.class);
        startActivity(i);
    }


}
