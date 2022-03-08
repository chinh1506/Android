package com.example.th3_0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnShowMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowMenu= (Button) findViewById(R.id.btnShowMenu);

        registerForContextMenu(btnShowMenu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_2,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.mnRed:
                btnShowMenu.setTextColor(Color.RED);
                break;
            case R.id.mnBlue:
                btnShowMenu.setTextColor(Color.BLUE);
                break;
            case R.id.mnBlack:
                btnShowMenu.setTextColor(Color.BLACK);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.mnSinhVien:
                Toast.makeText(this,"ban da chon Xem danh sach sinh vien", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnA:
                Toast.makeText(this,"ban da chon DHKTPM15A", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnB:
                Toast.makeText(this,"ban da chon DHKTPM15B", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}