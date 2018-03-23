package com.example.parthbambhaniya.smartbustracking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parthbambhaniya.smartbustracking.R;

/**
 * Created by Parth Bambhaniya on 10/1/2017.
 */

public class RegisterActivity extends AppCompatActivity
{
    TextView head_register;
    EditText v_fname, v_email, v_password;
    RadioGroup v_gender_group;
    RadioButton v_gender;
    Spinner v_city;
    Button b_sign_up,b_cancel,b_user;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        head_register = (TextView) findViewById(R.id.headRegister);
        v_fname = (EditText) findViewById(R.id.full_name);
        v_email = (EditText) findViewById(R.id.email);
        v_password = (EditText) findViewById(R.id.password);
        v_city = (Spinner) findViewById(R.id.city);

        v_gender_group = (RadioGroup) findViewById(R.id.gender);
        int selectedId = v_gender_group.getCheckedRadioButtonId();
        v_gender = (RadioButton) findViewById(selectedId);

        b_sign_up = (Button) findViewById(R.id.signUp);
        b_cancel = (Button) findViewById(R.id.cancel);
        b_user = (Button) findViewById(R.id.user);

        b_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Register Successfully",Toast.LENGTH_SHORT).show();
            }
        });

        b_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v_fname.setText("");
                v_email.setText("");
                v_password.setText("");
                v_gender.setText("");
            }
        });
            }
}
