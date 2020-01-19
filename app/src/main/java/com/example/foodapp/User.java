package com.example.foodapp;

import org.json.JSONObject;

public class User {

    String name;
    String email;
    int points;
    JSONObject visits;

    User(String name, String email) {
        this.name = name;
        this.email = email;
        this.points = 0;
        this.visits = new JSONObject();
    }

}
