package com.example.casestudy04;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvKq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvKq=findViewById(R.id.tvKq);
        Button btnG= findViewById(R.id.btnOpen);
        Button btnPT1= findViewById(R.id.btnPT1);
        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, HeSoActivity.class);
                startActivityForResult(intent,888);
            }
        });
        btnPT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, PTBacNhat.class);
                startActivityForResult(intent,999);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==888 && resultCode== RESULT_OK){
            String a=data.getStringExtra("a");
            String b=data.getStringExtra("b");
            String c=data.getStringExtra("c");
            giaiPTBac2(Double.parseDouble(a),Double.parseDouble(b),Double.parseDouble(c));
        }
        if(requestCode==999 && resultCode== RESULT_OK){
            String a=data.getStringExtra("kq");
            tvKq.setText(a);
        }


    }
    public void giaiPTBac2(double a, double b, double c) {
        if (a == 0)
            if (b == 0)
                if (c == 0)
                    tvKq.setText("Có vô số nghiệm");
                else
                    tvKq.setText("Vô nghiệm");
            else
                tvKq.setText(String.format("Có 1 nghiệm đơn: x=%f", -c / b));
        else {
            double delta = b * b - 4 * a * c;

            if (delta == 0)
                tvKq.setText(String.format("Có 1 nghiệm kép: x=%f", -b / 2 * a));
            else if (delta < 0)
                tvKq.setText("Vô nghiệm");
            else {
                tvKq.setText(String.format("Có 2 nghiệm phân biệt:\nx1= %f\nx2= %f", ((-b + Math.sqrt(delta)) / (2 * a)),
                        (-b - Math.sqrt(delta)) / (2 * a)));
            }
        }
    }

}