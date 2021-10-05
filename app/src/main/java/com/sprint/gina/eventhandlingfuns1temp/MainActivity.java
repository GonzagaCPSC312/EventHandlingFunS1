package com.sprint.gina.eventhandlingfuns1temp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {
    public static final String TAG = "MainActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.buttonLogin);

        // we want some code to execute when the user taps our login button
        // we will do this via "callback"
        // essentially: we register a callback on the button
        // when the button is clicked, a "click" event is fired
        // and all registered callbacks are notified

        // 2 ways to do this
        // 1. (simple way, but doesn't work for event other click events)
        // set the onClick attribute for Button to be the name of a method in MainActivity
        // 2. have a class implement the View.OnClickListener interface
        // a few diff ways to do this...
        // 2.A. MainActivity implement the interface
//        loginButton.setOnClickListener(this);
        // 2.B. define another class (outer or nested) that implements the interface
        // 2.C. do 2.B. with an anonymous class
        // (this is the preferred approach)
        loginButton.setOnClickListener(new View.OnClickListener() { // can be shortened with lambda expression
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onButtonClick: button clicked!! (2.C)");
                EditText usernameET = findViewById(R.id.editTextUsername);
                EditText passwordET = findViewById(R.id.editTextTextPassword);

                // warm up task 1
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();
                Log.d(TAG, "onClick: " + username + " " + password);

                // task 2
                usernameET.setText("");
                passwordET.setText("");
            }
        });
    }

    // 1.
//    public void onButtonClick(View view) {
//        Log.d(TAG, "onButtonClick: button clicked!! (1.)");
//    }

//    @Override
//    public void onClick(View v) {
//        Log.d(TAG, "onButtonClick: button clicked!! (2.A)");
//    }
}