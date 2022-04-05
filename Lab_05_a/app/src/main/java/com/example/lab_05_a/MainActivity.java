package com.example.lab_05_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ListView lvDonut;
private ArrayList<Donut> donuts;
private DonutAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect();
        adapter= new DonutAdapter(donuts,R.layout.item_cake,this);
        lvDonut.setAdapter(adapter);


    }

    private void connect() {
        lvDonut=findViewById(R.id.lvDonut);

        donuts= new ArrayList<>();
        donuts.add(new Donut("Tasty Donut","Spicy tasty donut family", 10,R.drawable.donut1));
        donuts.add(new Donut("Tasty Donut","Spicy tasty donut family", 10,R.drawable.donut2));
        donuts.add(new Donut("Tasty Donut","Spicy tasty donut family", 10,R.drawable.donut3));
        donuts.add(new Donut("Tasty Donut","Spicy tasty donut family", 10,R.drawable.donut4));
    }


}