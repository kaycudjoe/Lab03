package com.calvin.kec32.lab03;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.KeyEvent;
/*
    Karen Cudjoe
    Lab 3 - Exercise 3.3
    CS 262
 */


public class PasswordActivity extends AppCompatActivity {
    // Variables
    private EditText PasswordEditText;
    private ImageView ImageView;
    private TextView InvalidPasswordTextView;
    private SharedPreferences savedValues;
    private String passwordString = "";
    private String rightPassword = "Karen is cool";

    // Main Function
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        PasswordEditText = (EditText) findViewById(R.id.PasswordEditText);
        ImageView = (ImageView) findViewById(R.id.ImageView);
        ImageView.setVisibility(View.GONE);
        InvalidPasswordTextView = (TextView) findViewById(R.id.InvalidPasswordTextView);
        InvalidPasswordTextView.setVisibility(View.GONE);

        // Use a suitable listener to handle the editor-action event caused by the user entering a password

        PasswordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                passwordString = PasswordEditText.getText().toString();
                if (passwordString.equals(rightPassword)) {
                    ImageView.setVisibility(View.VISIBLE);
                    InvalidPasswordTextView.setVisibility(View.GONE);
                } else {
                    InvalidPasswordTextView.setVisibility(View.VISIBLE);
                    ImageView.setVisibility(View.GONE);
                }
                return false;

            }
        });
    }
}
