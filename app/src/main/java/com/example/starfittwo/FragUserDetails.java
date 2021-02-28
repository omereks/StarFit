package com.example.starfittwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.starfittwo.ui.main.UserDetailsFragment;
import com.google.firebase.auth.FirebaseAuth;

public class FragUserDetails extends AppCompatActivity {

    FirebaseAuth mFirebaseAuth;

    private TextView signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_user_details_layout);

        mFirebaseAuth = FirebaseAuth.getInstance();

        signout = findViewById(R.id.signup_tv);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFirebaseAuth.signOut();
                startActivity(new Intent(FragUserDetails.this, MainActivity.class));
                finish();
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, UserDetailsFragment.newInstance())
                    .commitNow();
        }



    }
}