package com.example.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnDslh:
                Toast.makeText(this,"bạn đã chọn danh sách lớp học",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnDssv:
                Toast.makeText(this,"bạn đã chọn danh sách sinh viên",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnSua:
                Toast.makeText(this,"bạn đã chọn sửa",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnXoa:
                Toast.makeText(this,"bạn đã chọn xóa",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnIn:
                Toast.makeText(this,"bạn đã chọn in",Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}