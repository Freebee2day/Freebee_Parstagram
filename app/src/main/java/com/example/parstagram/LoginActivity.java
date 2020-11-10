package com.example.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG="LoginActivity";

    EditText etUser;
    EditText etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(ParseUser.getCurrentUser()!=null){
            goMainActivity();
        }

        etPassword=findViewById(R.id.etPassword);
        etUser=findViewById(R.id.etUser);
        btnLogin=findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= etUser.getText().toString();
                String password= etPassword.getText().toString();
                loginUser(username,password);
            }
        });


    }

    private void loginUser(String username, String password) {
        Log.i(TAG, "loginUser: about to login");
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e!=null){
                    //fail to login
                    Log.i(TAG, "fail to login");
                    return;
                }
                Log.i(TAG, "goMainActivity: logging in");
                goMainActivity();
            }
        });
    }

    private void goMainActivity() {
        Log.i(TAG, "goMainActivity: successful login!");
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}