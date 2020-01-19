package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseHelper myDb;
    private Intent intent;

    private Button btnLogIn;

    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        myDb = new DatabaseHelper(this);

        btnLogIn = findViewById(R.id.btnLogIn);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnLogIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogIn:
                intent = new Intent(getApplicationContext(), LogIn.class);
                break;
            case R.id.btnSignUp:
                intent = new Intent(getApplicationContext(), SignUp.class);
                break;
            case R.id.restaurantSignUp:
                intent = new Intent(getApplicationContext(), RestaurantLogIn.class);
                break;
        }
        intent.putExtra("DATABASE", myDb);
        startActivity(intent);
    }
}
