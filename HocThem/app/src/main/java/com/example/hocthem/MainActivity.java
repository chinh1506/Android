package com.example.hocthem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.hocthem.adapter.TraiCayAdapter;
import com.example.hocthem.model.TraiCay;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    ListView lvTraiCay;
//    TraiCayAdapter adapter;
//    List<TraiCay> dsTraiCay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        anhXa();
//        adapter= new TraiCayAdapter(R.layout.mot_dong,this,dsTraiCay);
//        lvTraiCay.setAdapter(adapter);
    }

//    private void anhXa() {
//        lvTraiCay=findViewById(R.id.lvTraiCay);
//        dsTraiCay= new ArrayList<TraiCay>();
//        TraiCay traiCay= new TraiCay("Dứa","Thơm",R.drawable.img);
//        TraiCay traiCay1= new TraiCay("Dứa","Thơm",R.drawable.img_1);
//        dsTraiCay.add(traiCay);
//        dsTraiCay.add(traiCay1);
//    }
    private void anhXa(){

    }
}