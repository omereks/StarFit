package com.example.starfittwo.Loggin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.starfittwo.FoodFragment.FoodFrag;
import com.example.starfittwo.R;
import com.google.firebase.auth.FirebaseAuth;

public class LogginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView register_tv;

    private EditText emailET;
    private EditText passET;
    private Button signinBT;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        register_tv = findViewById(R.id.signup_tv);
        register_tv.setOnClickListener(this);

        signinBT = findViewById(R.id.signin_bt);
        signinBT.setOnClickListener(this);

        emailET = findViewById(R.id.Email_et);
        passET = findViewById(R.id.passwoed_et);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.signup_tv:
                startActivity(new Intent(this, FoodFrag.class));
        }
    }
}