package com.example.gamebaicao2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {
    private Button btnPlay;
    private TextView tvTime;
    private EditText edtSoPhut;
    private TextView tvWin;
    private TextView tvWin2;
    private ImageView imvMay1;
    private ImageView imvMay2;
    private ImageView imvMay3;
    private ImageView imvMay4;
    private ImageView imvMay5;
    private ImageView imvMay6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        anhXa();



        btnPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int soPhut= Integer.parseInt( edtSoPhut.getText().toString());
                int milis= soPhut*60*1000;
                AtomicInteger n= new AtomicInteger(0);
                AtomicInteger sec= new AtomicInteger(soPhut*60);
                AtomicInteger win1= new AtomicInteger(0);
                AtomicInteger win2= new AtomicInteger(0);
                CountDownTimer countDownTimer= new CountDownTimer(milis,500) {
                    @Override
                    public void onTick(long l) {
                        int[] mang6So = lay6SoNgauNhien(0, 51);
                        int[] mangBan = {mang6So[1], mang6So[3], mang6So[5]};
                        int[] mangMay = {mang6So[0], mang6So[2], mang6So[4]};
                        imvMay1.setImageResource(manghinhbai[mang6So[1]]);
                        imvMay2.setImageResource(manghinhbai[mang6So[3]]);
                        imvMay3.setImageResource(manghinhbai[mang6So[5]]);
                        imvMay4.setImageResource(manghinhbai[mang6So[0]]);
                        imvMay5.setImageResource(manghinhbai[mang6So[2]]);
                        imvMay6.setImageResource(manghinhbai[mang6So[4]]);
                        if(n.get()%2==0){
                            sec.set(sec.get()-1);
                            tvTime.setText(demGio(sec.get()));
                        }
                        n.set(n.get()+1);
                        if (kiemTraWin(mangBan, mangMay)) {
                            win1.set(win1.get()+1);
                            tvWin.setText("Win: " + win1.get());
                        } else {
                            win2.set(win2.get()+1);
                            tvWin2.setText("Win: " + (win2.get()));
                        }
                    }

                    @Override
                    public void onFinish() {

                    }
                }.start();
            }
        });

    }
    private String demGio(int sec){
        int min=sec/60;
        sec=sec%60;
        return (min<10?"0"+min:min)+(sec%2==0?":":" ")+(sec<10?"0"+sec:sec);
    }
    private void anhXa(){
        btnPlay= findViewById(R.id.btnPlay);
        tvTime= findViewById(R.id.tvTime);
        tvWin= findViewById(R.id.tvKq1);
        tvWin2= findViewById(R.id.tvKq2);
        edtSoPhut= findViewById(R.id.edtSoPhut);
        imvMay1= findViewById(R.id.imvMay1);
        imvMay2= findViewById(R.id.imvMay2);
        imvMay3= findViewById(R.id.imvMay3);
        imvMay4= findViewById(R.id.imvMay4);
        imvMay5= findViewById(R.id.imvMay5);
        imvMay6= findViewById(R.id.imvMay6);
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

    private boolean kiemTraWin(int[] a, int[] b) {
        if (demSoTay(a) == 3 && demSoTay(b) < 3) {
            return true;
        }
        if (demSoTay(b) == 3 && demSoTay(a) < 3) {
            return false;
        }
        if (demSoTay(a) == 3 && demSoTay(b) == 3) {
            if (timMax(a) > timMax(b)) {
                return true;
            } else return false;
        } else {
            int tongA = 0;
            int tongB = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] % 13 < 10)
                    tongA += a[i] % 13 + 1;
                if (b[i] % 13 < 10)
                    tongB += b[i] % 13 + 1;
            }
            if (tongA % 10 > tongB % 10) {
                return true;
            } else if (tongA % 10 < tongB % 10) {
                return false;
            } else {
                if (demSoTay(a) > demSoTay(b)) {
                    return true;
                } else if (demSoTay(a) < demSoTay(b)) {
                    return false;
                } else {
                    if (timMax(a) > timMax(b)) {
                        return true;
                    } else return false;
                }
            }
        }
    }

    private int timMax(int[] a) {
        int max = a[0];
        max = a[1] > a[0] ? a[1] : a[0];
        max = max > a[2] ? max : a[2];
        return max;
    }

    public int[] lay6SoNgauNhien(int min, int max) {
        int[] baso = new int[6];
        int i = 0;
        baso[i++] = random(min, max);
        do {
            int k = random(min, max);
            if (!kiemTraTrung(k, baso)) {
                baso[i++] = k;
            }
        } while (i < 6);
        return baso;
    }

    private int demSoTay(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 13 > 9)
                k++;
        }
        return k;

    }

    private String tinhKetQua(int[] arr) {
        String kq = "";
        if (demSoTay(arr) == 3) {
            return "3 tay";
        } else {
            int tong = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 13 < 10)
                    tong += arr[i] % 13 + 1;
            }
            if (tong % 10 == 0) {
                kq = "Bù, Số tây: " + demSoTay(arr);
            } else {
                kq = "kết quả là " + tong % 10 + " nút," + " số tây là: " + demSoTay(arr);
            }
        }
        return kq;

    }

}