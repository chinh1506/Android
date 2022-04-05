package com.example.onthigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edtMa;
    private EditText edtThongTin;
    private Button btnNhap;
    private Button btnLuu;
    private Button btnXem;
    private ArrayList<SinhVien> dssv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        try {
            read("sv.txt");
        } catch (IOException e) {
            Toast.makeText(MainActivity.this, "da tao file sv.txt", Toast.LENGTH_LONG);
        }
        btnXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityDanhSach.class);
                String data = "";
                for (SinhVien sinhVien : dssv) {
                    data += sinhVien.toString() + ";";
                }
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ma = Integer.parseInt(edtMa.getText().toString().trim());
                String thongtin = edtThongTin.getText().toString().trim();
                SinhVien sinhVien = new SinhVien(ma, thongtin);
                if (dssv.contains(sinhVien)) {
                    Toast.makeText(MainActivity.this, "Sinh vieen nay da ton tai", Toast.LENGTH_LONG);
                } else {
                    dssv.add(sinhVien);
                }
            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    save("sv.txt", dssv);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private void save(String fileName, ArrayList<SinhVien> ds) throws IOException {
        String data = "";
        for (SinhVien sinhVien : ds) {
            data += sinhVien.toString() + ";";
        }
        FileOutputStream out = null;
        try {
            out = openFileOutput(fileName, Context.MODE_PRIVATE);
            out.write(data.getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    private void read(String fileName) throws IOException {
        FileInputStream in = null;
        String data = "";
        int c;
        try {
            in = openFileInput(fileName);
            while ((c = in.read()) != -1) {
                data += Character.toString((char) c);
            }
            String[] ds = data.split(";");
            for (String sv : ds) {
                String[] temp = sv.split("-");
                dssv.add(new SinhVien(Integer.parseInt(temp[0]), temp[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            in.close();
        }

    }

    private void anhXa() {
        dssv = new ArrayList<>();
        edtMa = findViewById(R.id.edtMa);
        edtThongTin = findViewById(R.id.edtThongTin);
        btnLuu = findViewById(R.id.btnLuu);
        btnNhap = findViewById(R.id.btnNhap);
        btnXem = findViewById(R.id.btnXem);
    }
}