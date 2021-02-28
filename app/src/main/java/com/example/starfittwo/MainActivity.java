package com.example.starfittwo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.starfittwo.Loggin.RegisterUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView register_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        register_tv = findViewById(R.id.signup_tv);
        register_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.signup_tv:
                startActivity(new Intent(MainActivity.this, RegisterUser.class));
        }
    }
}
