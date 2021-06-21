package com.example.sakhii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp_Form extends AppCompatActivity {
    Button SignUp;
    EditText FullName, Username, Email, Mobile, Password, ConfirmPassword;
    ProgressBar ProgressBar;
    private FirebaseAuth FirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__form);
        getSupportActionBar().setTitle("SignUp Page");

        FullName = (EditText) findViewById(R.id.Fullname);
        Username = (EditText) findViewById(R.id.Username);
        Email = (EditText) findViewById(R.id.Email);
        Mobile = (EditText) findViewById(R.id.Mobile);
        Password = (EditText) findViewById(R.id.Password);
        ConfirmPassword = (EditText) findViewById(R.id.ConfirmPassword);
        SignUp = (Button) findViewById(R.id.Login);
        ProgressBar = (ProgressBar) findViewById(R.id.ProgressBar);

        FirebaseAuth = FirebaseAuth.getInstance();


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String FullName1 = FullName.getText().toString().trim();
                String Username1 = Username.getText().toString().trim();
                String Email1 = Email.getText().toString().trim();
                String Mobile1 = Mobile.getText().toString().trim();
                String Password1 = Password.getText().toString().trim();
                String ConfirmPassword1 = ConfirmPassword.getText().toString().trim();


                if(TextUtils.isEmpty(FullName1)){
                    Toast.makeText(SignUp_Form.this, "Please Enter Full Name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(Username1)){
                    Toast.makeText(SignUp_Form.this, "Please Enter User Name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(Email1)){
                    Toast.makeText(SignUp_Form.this, "Please Enter Email ID", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(Mobile1)){
                    Toast.makeText(SignUp_Form.this, "Please Enter Mobile", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(Password1)) {
                    Toast.makeText(SignUp_Form.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(ConfirmPassword1)){
                    Toast.makeText(SignUp_Form.this, "Please Enter Confirm Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                ProgressBar.setVisibility(View.VISIBLE);

                if(Password1.equals(ConfirmPassword1)){
                    FirebaseAuth.createUserWithEmailAndPassword(Email1, Password1)
                            .addOnCompleteListener(SignUp_Form.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    ProgressBar.setVisibility(View.GONE);

                                    if (task.isSuccessful()) {

                                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                        Toast.makeText(SignUp_Form.this, "SignUp Successful", Toast.LENGTH_SHORT).show();

                                    } else {

                                        Toast.makeText(SignUp_Form.this, "SignUp Failure", Toast.LENGTH_SHORT).show();

                                    }

                                }
                            });
                }

            }
        });
    }
}
