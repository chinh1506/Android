package com.example.demolistview;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TruyenSanPham {
    private ArrayList<SanPham> dsSanPham;
    private Button btnThoat;
    GridAdapter adapter;
    Fragment1 fragment1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Configuration configuration = getResources().getConfiguration();
        btnThoat = findViewById(R.id.btnThoat);
        if (btnThoat != null && configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            btnThoat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
        adapter = new GridAdapter(this, R.layout.san_pham, dsSanPham);
        fragment1 = (Fragment1) getFragmentManager().findFragmentById(R.id.fragment);

        if (fragment1 != null && configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            fragment1.setNumColGrid(3);
            fragment1.setAdapter(adapter);
        }

    }

    @Override
    public void dataSanPham(SanPham sanPham) {
        Fragment2 fragment2 = (Fragment2) getFragmentManager().findFragmentById(R.id.fragment2);
        Configuration configuration = getResources().getConfiguration();
        if (fragment2 != null && configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragment2.setThongTin(sanPham);
        } else {
            Intent intent = new Intent(MainActivity.this, Activity1.class);
            intent.putExtra("sp", sanPham);
            startActivity(intent);
        }
    }

    @Override
    public void dsSanPham(ArrayList<SanPham> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }
}