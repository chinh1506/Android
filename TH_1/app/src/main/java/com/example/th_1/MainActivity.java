package com.example.th_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.Clock;

public class MainActivity extends AppCompatActivity {
    private EditText edtA;
    private EditText edtB;

    private TextView tvKq;

    private Button btnTong;
    private Button btnHieu;
    private Button btnTich;
    private Button btnThuong;
    private Button btnUcln;
    private Button btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt( edtA.getText().toString().trim());
                int b=Integer.parseInt( edtB.getText().toString().trim());
                tvKq.setText(a+b+"");
            }
        });
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt( edtA.getText().toString().trim());
                int b=Integer.parseInt( edtB.getText().toString().trim());
                tvKq.setText(a-b+"");
            }
        });
        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt( edtA.getText().toString().trim());
                int b=Integer.parseInt( edtB.getText().toString().trim());
                tvKq.setText(a*b+"");
            }
        });
        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt( edtA.getText().toString().trim());
                int b=Integer.parseInt( edtB.getText().toString().trim());
                tvKq.setText((1.0*a/b)+"");
            }
        });
        btnUcln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt( edtA.getText().toString().trim());
                int b=Integer.parseInt( edtB.getText().toString().trim());
                tvKq.setText(timUcln(a,b)+"");
            }
            public int timUcln(int a, int b){
                while (a!=b){
                    if(a>b){
                        a=a-b;
                    }else{
                        if(a<b){
                            b=b-a;
                        }
                    }
                }
                return a;
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 
            }
        });
    }

    private void anhXa() {
        edtA= findViewById(R.id.edtA);
        edtB= findViewById(R.id.edtB);

        tvKq= findViewById(R.id.tvKq);

        btnTong= findViewById(R.id.btnTong);
        btnHieu= findViewById(R.id.btnHieu);
        btnTich= findViewById(R.id.btnTich);
        btnThuong= findViewById(R.id.btnThuong);
        btnUcln= findViewById(R.id.btnUcln);
        btnThoat= findViewById(R.id.btnThoat);
    }

}