package com.example.th3_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder builder= new AlertDialog.Builder(this);

        builder.setTitle("Thông báo");
        final CharSequence[] items={"Đỏ", "cam","Vàng"};
        final boolean[] checkes={false, false, false};
        builder.setMultiChoiceItems(items, checkes, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                checkes[i]=b;
                Toast.makeText(MainActivity.this,"da chon"+items[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"da chon nut yes", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog= builder.create();
        dialog.show();
    }
}