package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Bundle data = getIntent().getExtras();
        DatabaseHelper myDb = (DatabaseHelper) data.getSerializable("DATABASE");
    }

    public void toMainpage(View view) {

        EditText name = (EditText) findViewById(R.id.accountEntry);
        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password1);
        EditText rePassword = (EditText) findViewById(R.id.password2);

        String p = String.valueOf(password.getText());
        String p2 = String.valueOf(rePassword.getText());

        if (p.equals(p2)) {
//            myDb.addUser(name, email, 0, [], " ");

            Intent i = new Intent(SignUp.this, MainPage.class);
            startActivity(i);
        } else {
            // ...
        }

    }
}
