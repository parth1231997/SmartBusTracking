package com.example.parthbambhaniya.smartbustracking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.parthbambhaniya.smartbustracking.R;

/**
 * Created by Parth Bambhaniya on 10/2/2017.
 */

public class LoginActivity extends AppCompatActivity
{
    TextView head_login;
    EditText v_email, v_password;
    Button b_sign_in,b_new_user;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        head_login = (TextView)findViewById(R.id.headLogin);
        v_email = (EditText)findViewById(R.id.email);
        v_password = (EditText)findViewById(R.id.password);

        b_sign_in = (Button)findViewById(R.id.signIn);
        b_new_user = (Button)findViewById(R.id.newUser);
    }
}
