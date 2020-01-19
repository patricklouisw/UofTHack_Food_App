package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpRestaurant extends AppCompatActivity {

    EditText edtTextRestaurantName;
    EditText edtTextEmailName;
    EditText edtTextAddress;
    EditText edtTextPassword;
    EditText edtTextRePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_restaurant);

        edtTextRestaurantName = findViewById(R.id.restaurantAccountEntry);
        edtTextEmailName = findViewById(R.id.restaurantEmailEntry);
        edtTextAddress = findViewById(R.id.restaurantAddress);
        edtTextPassword = findViewById(R.id.restaurantPassword);
        edtTextRePassword = findViewById(R.id.restaurantPassword2);
    }

    public void toRestaurantMain(View view) {
        //Check if the password and retype password is the same
        String password = String.valueOf(edtTextPassword.getText());
        String rePassword = String.valueOf(edtTextRePassword.getText());
        if(password.equals(rePassword)) {
            String name = String.valueOf(edtTextRestaurantName.getText());
            String email = String.valueOf(edtTextEmailName.getText());
            String address = String.valueOf(edtTextAddress.getText());
            DatabaseHelper db = new DatabaseHelper(getApplicationContext());
            db.restaurantSignup(name, password, email, address);
            //Direct this page to Main Page
            Intent i = new Intent(getApplicationContext(), RestaurantMainPage.class);
            i.putExtra("EMAIL", email);
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "Password and the Re-typed password are different.", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public void backToMain(View view) {
        Intent i = new Intent(getApplicationContext(), RestaurantLogIn.class);
        startActivity(i);
    }
}
