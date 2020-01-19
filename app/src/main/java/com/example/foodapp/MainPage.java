package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import android.content.Intent;
import android.widget.TextView;


public class MainPage extends AppCompatActivity {

    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Intent intent = getIntent();
        email = intent.getExtras().getString("EMAIL");
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());

        TextView mouthsFednumber = (TextView) findViewById(R.id.textView3);
        mouthsFednumber.setText(String.valueOf(db.totalContribution()));

    }

    public void toPoints(View view) {
        Intent i = new Intent(MainPage.this, UserPoints.class);
        i.putExtra("EMAIL", email);
        startActivity(i);

    }

    public void toLeaderboard(View view) {
        Intent i = new Intent(MainPage.this, Leaderboard.class);
        i.putExtra("EMAIL", email);
        startActivity(i);

    }

    public void toMainActivity(View view) {
        Intent i = new Intent(MainPage.this, MainActivity.class);
        startActivity(i);
    }

    public void toAbout(View view) {
        Intent i = new Intent(MainPage.this, about.class);
        i.putExtra("EMAIL", email);
        startActivity(i);
    }




}
