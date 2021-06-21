package com.example.sakhii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Form extends AppCompatActivity {

    EditText Email, Password;
    Button Login;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__form);
        getSupportActionBar().setTitle("Login Page");

            Email = (EditText) findViewById(R.id.Email);
            Password = (EditText) findViewById(R.id.Password);
            Login = (Button) findViewById(R.id.Login);

            firebaseAuth = FirebaseAuth.getInstance();

            Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String Email1 = Email.getText().toString().trim();
                    String Password1 = Password.getText().toString().trim();


                    if(TextUtils.isEmpty(Email1)){
                        Toast.makeText(Login_Form.this, "Please Enter Registered Email ID", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(TextUtils.isEmpty(Password1)){
                        Toast.makeText(Login_Form.this, "Please Enter Correct Password", Toast.LENGTH_SHORT).show();
                        return;
                    }


                        firebaseAuth.signInWithEmailAndPassword(Email1, Password1)
                                .addOnCompleteListener(Login_Form.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {


                                        if (task.isSuccessful()) {

                                            startActivity(new Intent(getApplicationContext(), HomePageFinal.class));

                                        } else {

                                            Toast.makeText(Login_Form.this, "Login Failure", Toast.LENGTH_SHORT).show();

                                        }

                                    }
                                });




                }
            });
    }

    public void SignUp(View view) {
        startActivity(new Intent(getApplicationContext(), SignUp_Form.class));
    }
}
