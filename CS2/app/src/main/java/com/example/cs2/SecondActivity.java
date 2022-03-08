package com.example.cs2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvInfor= findViewById(R.id.tvInfor);
        String name= getIntent().getExtras().getString("name");
        String age = getIntent().getExtras().getString("age");

        tvInfor.setText(name+"\t"+age);

    }
}