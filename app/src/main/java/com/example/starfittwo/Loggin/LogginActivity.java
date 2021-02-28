package com.example.starfittwo.Loggin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.starfittwo.FoodFragment.FoodFrag;
import com.example.starfittwo.MainPageTab;
import com.example.starfittwo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.signup_tv:
                startActivity(new Intent(this, RegisterUser.class));
                break;

            case R.id.signin_bt:
                userLogin();
                break;

        }
    }

    private void userLogin() {
        String email = emailET.getText().toString().trim();
        String pass = passET.getText().toString().trim();


        if (pass.isEmpty()){
            passET.setError("Fill password");
            passET.requestFocus();
            return;
        }
        if (email.isEmpty()){
            emailET.setError("Fill Email");
            emailET.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailET.setError("Enter Valid Email");
            emailET.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //Enter app:
                    startActivity(new Intent(LogginActivity.this, MainPageTab.class));

                }else {
                    Toast.makeText(LogginActivity.this,"sign in failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}