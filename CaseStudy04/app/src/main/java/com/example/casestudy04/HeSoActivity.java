package com.example.casestudy04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HeSoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_he_so);
        EditText etA= findViewById(R.id.etA);
        EditText etB= findViewById(R.id.etB);
        EditText etC= findViewById(R.id.etC);
        Button btnGiai= findViewById(R.id.btnGiai);

        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.putExtra("a",etA.getText().toString().trim());
                intent.putExtra("b",etB.getText().toString().trim());
                intent.putExtra("c",etC.getText().toString().trim());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}