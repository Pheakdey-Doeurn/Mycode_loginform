package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button add,showlist;
    ListView list;

    User user;
    ArrayList<User>myUserList = new ArrayList<User>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.edtUsername);
        password = findViewById(R.id.edtpass);
        add = findViewById(R.id.add);
        showlist = findViewById(R.id.showlist);
        list = findViewById(R.id.list);

        user = new User("Pheakdey","123");
        myUserList.add(user);
        user = new User("Pheak","1234");
        myUserList.add(user);
        user = new User("Kdey","12345");
        myUserList.add(user);

        MyAdapter myAdapter = new MyAdapter(myUserList,this);
        list.setAdapter(myAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                User U = (User) list.getItemAtPosition(i);
                String username,pass;
                username=U.getUsername();
                pass=U.getPassword();

                Intent intent = new Intent(MainActivity.this,UserProfile.class);
                intent.putExtra("username",U.getUsername());
                intent.putExtra("pass",U.getPassword());
                startActivity(intent);
            }
        });
    add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String userst = username.getText().toString();
            String passst = password.getText().toString();

            user = new User(userst,passst);
            if(userst!=""&&passst!="")
                myUserList.add(user);
            username.setText("");
            password.setText("");
        }
    });

    showlist.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            list.setAdapter(myAdapter);
        }
    });
    }

}