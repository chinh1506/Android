package com.example.casestudy3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnS= findViewById(R.id.btnEnter);

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent,999);
//                startActivityIfNeeded(intent,999);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==999 && resultCode== RESULT_OK){
            String resuilt= data.getStringExtra("ns");
            int ns= Integer.parseInt(resuilt);
            Calendar calendar= Calendar.getInstance();
            int nht= calendar.get(Calendar.YEAR);


            TextView tvEnter= findViewById(R.id.tvKq);
            tvEnter.setText("Số tuổi của bạn là: "+(nht-ns));
        }
    }
}