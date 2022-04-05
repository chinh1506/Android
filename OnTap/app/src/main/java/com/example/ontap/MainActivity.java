package com.example.ontap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Donut> donuts;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect();
        DonutAdapter donutAdapter= new DonutAdapter(this,R.layout.donut_one_line,donuts);
        listView.setAdapter(donutAdapter);
        donutAdapter.updateListview(donuts);

    }

    private void connect() {
        donuts= new ArrayList<Donut>();
        donuts.add(new Donut("Tasty donut","family",120,R.drawable.tasty_donut));
        donuts.add(new Donut("Tasty donut","family",120,R.drawable.tasty_donut));
        listView= findViewById(R.id.lvDonut);

    }

}