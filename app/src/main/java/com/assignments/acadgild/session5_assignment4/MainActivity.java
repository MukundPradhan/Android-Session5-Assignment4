/*
Acad Gild Android Course
Session 5 - Assignment 4

Make a Login screen to display another activity Welcomes with user name.

Data transfered thru' Bundle

 */



package com.assignments.acadgild.session5_assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin;
    EditText etName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.button);
        etName = (EditText) findViewById(R.id.etInputName);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (!etName.getText().toString().isEmpty()) {
            Intent intent = new Intent(MainActivity.this, Welcome.class);
            Bundle bundle = new Bundle();
            bundle.putString("BundleName", etName.getText().toString().trim());
            intent.putExtras(bundle);
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
            etName.requestFocus();

        }
    }
}
