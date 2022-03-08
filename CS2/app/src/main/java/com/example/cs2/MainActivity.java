package com.example.cs2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name= findViewById(R.id.txtName);
        EditText age= findViewById(R.id.txtAge);
        Button submit=findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("age",age.getText().toString());
                startActivity(intent);
            }
        });
    }
}