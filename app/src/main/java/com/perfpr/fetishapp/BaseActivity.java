package com.perfpr.fetishapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {
    private ImageView ivCancel, ivLove;
    private RecyclerView rvUsers;
    private Button btnSignUp, btnChooseKinks;
    private List<StandardUser> newUser = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        rvUsers =(RecyclerView)findViewById(R.id.rvSwipeOptions);
        ivCancel = (ImageView)findViewById(R.id.ivCancel);
        ivLove = (ImageView)findViewById(R.id.ivLove);
        btnSignUp = (Button)findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BaseActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });
        btnChooseKinks = (Button)findViewById(R.id.btnChooseKinks);
        btnChooseKinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BaseActivity.this, SetupKinks.class);
                startActivity(i);
            }
        });

        rvUsers =(RecyclerView)findViewById(R.id.rvSwipeOptions);
        UserPickerAdapter adapter = new UserPickerAdapter(newUser, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvUsers.setLayoutManager(linearLayoutManager);
        rvUsers.setAdapter(adapter);
        addUsers();

    }

    private void addUsers() {
        StandardUser user = new StandardUser("path","Becky", "Williams", "08/02/1988", "Female", "Bio Short", "Straight",
                "Lots of Kinks", "None", "None", "None", "tera@gmail.com", "17257", "Today", true);
        newUser.add(user);
    }
}
