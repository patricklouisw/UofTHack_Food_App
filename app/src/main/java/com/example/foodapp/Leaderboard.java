package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

import android.os.Bundle;

public class Leaderboard extends AppCompatActivity {

    Intent mainPageintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        mainPageintent = getIntent();

        TextView firstPlace = findViewById(R.id.firstPlace);
        TextView secondPlace = findViewById(R.id.secondPlace);
        TextView thirdPlace = findViewById(R.id.thirdPlace);

        firstPlace.setText(" ");
        secondPlace.setText(" ");
        thirdPlace.setText(" ");


    }

    public void toMainpage(View view) {
        Intent i = new Intent(Leaderboard.this, mainPageintent.getClass());
        startActivity(i);
    }
}

