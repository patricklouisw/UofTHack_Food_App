package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

import android.os.Bundle;

import java.util.List;
import java.util.Map;

public class Leaderboard extends AppCompatActivity {

    Intent mainPageintent;

    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        mainPageintent = getIntent();
        String email = mainPageintent.getExtras().getString("EMAIL");
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());

        TextView firstPlace = findViewById(R.id.firstPlace);
        TextView secondPlace = findViewById(R.id.secondPlace);
        TextView thirdPlace = findViewById(R.id.thirdPlace);

        List<Map> leaderboard = db.leaderboard();
        
        firstPlace.setText(String.valueOf(leaderboard.get(0).get("name")) + " " + String.valueOf(leaderboard.get(0).get("contribution")));
        secondPlace.setText(String.valueOf(leaderboard.get(1).get("name"))+ " " + String.valueOf(leaderboard.get(1).get("contribution")));
        thirdPlace.setText(String.valueOf(leaderboard.get(2).get("name")) + " " + String.valueOf(leaderboard.get(2).get("contribution")));
    }

    public void toMainpage(View view) {
        Intent i = new Intent(getApplicationContext(), MainPage.class);
        i.putExtra("EMAIL", email);
        startActivity(i);
    }
}

