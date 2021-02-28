package com.example.starfittwo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.starfittwo.FoodFragment.FoodFrag;
import com.example.starfittwo.Loggin.LogginActivity;
import com.example.starfittwo.Loggin.RegisterUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.api.Logging;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mFireBaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFireBaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser mFirebaseUser = mFireBaseAuth.getCurrentUser();

        if (mFirebaseUser != null) {
            startActivity(new Intent(MainActivity.this, MainPageTab.class));
            finish();
        } else {
            startActivity(new Intent(MainActivity.this, LogginActivity.class));
            finish();
        }
    }
}
