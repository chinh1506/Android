package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnRut;
    private ImageView imgv1;
    private ImageView imgv2;
    private ImageView imgv3;
    private TextView tvKq;
    int manghinhbai[] = {
            R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5,
            R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10,
            R.drawable.cj, R.drawable.cq, R.drawable.ck,
            R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5,
            R.drawable.d6, R.drawable.d7, R.drawable.d8, R.drawable.d9, R.drawable.d10,
            R.drawable.dj, R.drawable.dq, R.drawable.dk,
            R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5,
            R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,
            R.drawable.hj, R.drawable.hq, R.drawable.hk,
            R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5,
            R.drawable.s6, R.drawable.s7, R.drawable.s8, R.drawable.s9, R.drawable.s10,
            R.drawable.sj, R.drawable.sq, R.drawable.sk};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        btnRut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] baLa = layBaSoNgauNhien(0, 51);
                imgv1.setImageResource(manghinhbai[baLa[0]]);
                imgv2.setImageResource(manghinhbai[baLa[1]]);
                imgv3.setImageResource(manghinhbai[baLa[2]]);
                tvKq.setText(tinhKetQua(baLa));
                Toast.makeText(MainActivity.this, "" + baLa[0] + "    " + baLa[1] + "   " + baLa[2] + "", Toast.LENGTH_LONG).show();
            }
        });


    }
    private String tinhKetQua(int[] arr){
        String kq= "";
        if(demSoTay(arr)==3){
            return "3 tay";
        }
        else{
            int tong=0;
            for (int i=0; i < arr.length; i++) {
                if(arr[i]%13<10)
                    tong+=arr[i]%13+1;
            }
            if(tong%10==0){
                kq="Bù, Số tây: "+demSoTay(arr);
            }
            else {
                kq="kết quả là "+tong%10+ "nút,"+"số tây là: "+demSoTay(arr);
            }
        }
        return kq;

    }
    private int demSoTay(int[] arr) {
        int k=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] %13>9)
                k++;
        }
        return k;

    }

    private void anhXa() {
        btnRut = findViewById(R.id.btnRut);
        imgv1 = findViewById(R.id.imgv1);
        imgv2 = findViewById(R.id.imgv2);
        imgv3 = findViewById(R.id.imgv3);
        tvKq = findViewById(R.id.tvKq);
    }

    public int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public boolean kiemTraTrung(int k, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k)
                return true;
        }
        return false;
    }

    public int[] layBaSoNgauNhien(int min, int max) {
        int[] baso = new int[3];
        int i = 0;
        baso[i++] = random(min, max);
        do {
            int k = random(min, max);
            if (!kiemTraTrung(k, baso)) {
                baso[i++] = k;
            }
        } while (i < 3);
        return baso;
    }
}