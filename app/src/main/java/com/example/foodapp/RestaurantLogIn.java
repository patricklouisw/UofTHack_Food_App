package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class RestaurantLogIn extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_main);

        editTextEmail = findViewById(R.id.textInputEditText);
        editTextPassword = findViewById(R.id.editText2);
    }

    public void toLogIn(View view) {
        String email = String.valueOf(editTextEmail.getText());
        String password = String.valueOf(editTextPassword.getText());

        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        Map m = new HashMap();

        m = db.restaurantLogin(email, password);

        if (m.isEmpty()) {
            Toast.makeText(getApplicationContext(), "The email and password does not match.", Toast.LENGTH_SHORT)
                    .show();
        } else {
            Restaurant r1 = new Restaurant((String) m.get("name"), (String) m.get("email"), (String) m.get("address"));

            Intent i = new Intent(getApplicationContext(), RestaurantMainPage.class);
            i.putExtra("EMAIL", email);
            startActivity(i);
        }
    }

    public void toSignUp(View view) {
        Intent i = new Intent(getApplicationContext(), SignUpRestaurant.class);
        startActivity(i);
    }

    public void backToMain(View view) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
