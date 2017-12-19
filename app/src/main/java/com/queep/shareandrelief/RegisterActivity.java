package com.queep.shareandrelief;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button user;
    private FirebaseAuth mAuth;
    private TextInputLayout display_name;
    private TextInputLayout user_email;
    private TextInputLayout user_pass;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        user = (Button) findViewById(R.id.user);
        display_name = findViewById(R.id.display_name);
        user_email = findViewById(R.id.user_email);
        user_pass = findViewById(R.id.user_pass);
        user.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.user:
                String display_name_str = display_name.getEditText().getText().toString();
                String email = user_email.getEditText().getText().toString();
                String password = user_pass.getEditText().getText().toString();
                register_user(display_name_str, email, password);
        }
    }

    private void register_user(String display_name_str, String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                          intent = new Intent(RegisterActivity.this, MainActivity.class);
                          startActivity(intent);
                          finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });

    }
}
