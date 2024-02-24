package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserProfile extends AppCompatActivity {

    EditText username,password;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        username = findViewById(R.id.etxtuser);
        password = findViewById(R.id.etxtpass);
        back = findViewById(R.id.btnBack);

        Intent MyData = getIntent();
        String strusername,strpass;
        strusername = MyData.getStringExtra("username");
        strpass = MyData.getStringExtra("pass");

        username.setText(strusername);
        password.setText(strpass);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserProfile.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}