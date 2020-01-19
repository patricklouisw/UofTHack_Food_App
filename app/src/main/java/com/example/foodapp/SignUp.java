package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;
    EditText rePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Bundle data = getIntent().getExtras();
//        DatabaseHelper myDb = (DatabaseHelper) data.getSerializable("DATABASE");

        name = (EditText) findViewById(R.id.accountEntry);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password1);
        rePassword = (EditText) findViewById(R.id.password2);
    }

    public void toMainpage(View view) {

        String n = String.valueOf(name.getText());
        String e = String.valueOf(email.getText());
        String p = String.valueOf(password.getText());
        String p2 = String.valueOf(rePassword.getText());
        if (p.equals(p2)) {
//            myDb.addUser(name, email, 0, [], " ");
            DatabaseHelper db = new DatabaseHelper(getApplicationContext());
            db.userSignup(n, p, e);

            Intent i = new Intent(SignUp.this, MainPage.class);
            i.putExtra("EMAIL", e);
            startActivity(i);
        } else{
            Toast.makeText(getApplicationContext(), "Password and the Re-typed password are different.", Toast.LENGTH_SHORT)
                    .show();
        }

    }

    public void backToMain(View view) {
        Intent i = new Intent(getApplicationContext(), LogIn.class);
        startActivity(i);
    }
}
