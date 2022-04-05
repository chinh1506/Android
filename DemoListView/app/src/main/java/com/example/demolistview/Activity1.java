package com.example.demolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {
    TruyenSanPham truyenSanPham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Fragment2 fragment2= (Fragment2) getFragmentManager().findFragmentById(R.id.frm2);
        Intent intent= getIntent();
        SanPham sanPham= (SanPham) intent.getSerializableExtra("sp");
        Configuration configuration= getResources().getConfiguration();
        if(fragment2!= null && configuration.orientation==Configuration.ORIENTATION_PORTRAIT){
            fragment2.setThongTin(sanPham);
        }

    }
}