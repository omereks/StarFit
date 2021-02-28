package com.example.starfittwo.Loggin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.starfittwo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener  {

    private EditText UserName;
    private EditText UserEmail;
    private EditText UserPass;
    private Button Register_bt;


    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        UserName = findViewById(R.id.UserName_et);
        UserEmail = findViewById(R.id.Email_et);
        UserPass = findViewById(R.id.passwoed_et);
        Register_bt = findViewById(R.id.register_bt);

        mAuth = FirebaseAuth.getInstance();


        Register_bt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_bt:
                registerUser();
        }
    }

    private void registerUser() {
        String name = UserName.getText().toString().trim();
        String email = UserEmail.getText().toString().trim();
        String pass = UserPass.getText().toString().trim();

        if (name.isEmpty()){
            UserName.setError("Fill Name");
            UserName.requestFocus();
            return;
        }
        if (pass.isEmpty()){
            UserPass.setError("Fill password");
            UserPass.requestFocus();
            return;
        }
        if (email.isEmpty()){
            UserEmail.setError("Fill Email");
            UserEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            UserEmail.setError("Enter Valid Email");
            UserEmail.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(name,email);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(RegisterUser.this,"Welcome", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    }
                });

    }
}

