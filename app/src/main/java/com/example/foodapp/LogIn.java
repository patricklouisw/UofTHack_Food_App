package com.example.foodapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class LogIn extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        editTextEmail = findViewById(R.id.textInputEditText);
        editTextPassword = findViewById(R.id.editText2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void toLogIn(View view) {
        String email = String.valueOf(editTextEmail.getText());
        String password = String.valueOf(editTextPassword.getText());

        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        Map m = new HashMap();

        m = db.userLogin(email, password);

        if (m.isEmpty()) {
            Toast.makeText(getApplicationContext(), "The email and password does not match.", Toast.LENGTH_SHORT)
                    .show();
        } else {
            User u1 = new User((String) m.get("name"), (String) m.get("email"));

            Intent i = new Intent(LogIn.this, MainPage.class);
            i.putExtra("EMAIL", email);
            startActivity(i);
        }


    }

    public void toSignUp(View view) {
        Intent i = new Intent(LogIn.this, SignUp.class);
        startActivity(i);
    }

    public void backToMain(View view) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
