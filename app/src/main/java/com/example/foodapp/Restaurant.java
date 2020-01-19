package com.example.foodapp;

import org.json.JSONObject;

public class Restaurant {

    String resName;
    String resEmail;
    String address;
    int contributions;
    JSONObject visits;

    Restaurant (String name, String email, String address) {
        this.resName = name;
        this.resEmail = email;
        this.address = address;
        this.contributions = 0;
        this.visits = new JSONObject();
    }

}
