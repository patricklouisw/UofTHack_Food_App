package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class about extends AppCompatActivity {

    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Intent i = getIntent();
        email = i.getExtras().getString("EMAIL");
    }

    public void toMainPage(View view) {
        Intent i = new Intent(getApplicationContext(), MainPage.class);
        i.putExtra("EMAIL", email);
        startActivity(i);
    }
}
