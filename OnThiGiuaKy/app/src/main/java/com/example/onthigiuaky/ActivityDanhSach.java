package com.example.onthigiuaky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySet;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ActivityDanhSach extends AppCompatActivity {

    private ArrayList<SinhVien> dssv;
    private TextView tvDssv;
    private Button btnDong;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach);
        anhXa();
        String data= getIntent().getExtras().getString("data");
        String[] ds= data.split(";");
        for (String sv:ds) {
            String[] temp= sv.split("-");
            dssv.add(new SinhVien(Integer.parseInt(temp[0]),temp[1]));
        }
        ArrayAdapter adapter= new ArrayAdapter(ActivityDanhSach.this, android.R.layout.simple_list_item_1,dssv);
        listView.setAdapter(adapter);

        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void anhXa() {
        dssv= new ArrayList<>();
        tvDssv=findViewById(R.id.tvDssv);
        listView= findViewById(R.id.lv);
        btnDong= findViewById(R.id.btnDong);
    }
}