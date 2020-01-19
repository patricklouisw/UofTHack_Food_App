package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

public class UserPoints extends AppCompatActivity {

    Intent mainPageintent;

    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPageintent = getIntent();
        email = mainPageintent.getExtras().getString("EMAIL");

        setContentView(R.layout.activity_user_points);

        DatabaseHelper db = new DatabaseHelper(getApplicationContext());

        TextView pointsTextView = (TextView) findViewById(R.id.textView11);
        TextView donationsTextView = (TextView) findViewById(R.id.textView12);
        TextView visitsTextView = (TextView) findViewById(R.id.textView13);

        pointsTextView.setText("total points");
        donationsTextView.setText("$");
        visitsTextView.setText("Mcdonalds");

        pointsTextView.setText(String.valueOf(db.getPoints(email)));
    }

    public void toMainpage(View view){
        Intent i = new Intent(getApplicationContext(), MainPage.class);
        i.putExtra("EMAIL", email);
        startActivity(i);
    }
}
