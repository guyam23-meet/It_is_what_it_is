package com.example.devworkshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView SignIn;
    private EditText email;
    private EditText password;
    private Button signup;
    private Button signin;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        SignIn = findViewById(R.id.SignIn);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signup);
        signin = findViewById(R.id.signin);
        signup.setOnClickListener(this);
        signin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==signin){
            signin_user(email.getText().toString(),password.getText().toString());
        }
        if(view==signup){
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        }
    }
    public void signin_user(String email,String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this,"Authentication failed.",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}