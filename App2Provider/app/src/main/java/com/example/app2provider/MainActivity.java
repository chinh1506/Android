package com.example.app2provider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static final String AUTHORITY="com.example";
    static final String CONTENT_PROVIDER="contentprovider";
    static final String URL="content://"+AUTHORITY+"/"+CONTENT_PROVIDER;
    static final Uri URI= Uri.parse(URL);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtId= findViewById(R.id.edtId);
        EditText edtName= findViewById(R.id.edtName);
        EditText edtUnit= findViewById(R.id.edtUnit);
        EditText edtMadein= findViewById(R.id.edtMadein);
        Button btnSave= findViewById(R.id.btnSave);
        GridView grvProduct= findViewById(R.id.grvProduct);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues= new ContentValues();
                contentValues.put("id",edtId.getText().toString().trim());
                contentValues.put("name",edtName.getText().toString().trim());
                contentValues.put("unit",edtUnit.getText().toString().trim());
                contentValues.put("madein",edtMadein.getText().toString().trim());
                Uri insertUri= getContentResolver().insert(URI,contentValues);
                Toast.makeText(MainActivity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
            }
        });
        Button btnSelect= findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=
                ArrayList<String> strings= new ArrayList<>();
                Cursor cursor=getContentResolver().query(URI,null,null,null,"name");
                if(cursor!=null){
                    cursor.moveToFirst();
                    do {
                        strings.add(cursor.getInt(0)+"");
                        strings.add(cursor.getString(1));
                        strings.add(cursor.getString(2));
                        strings.add(cursor.getString(3));
                    }while (cursor.moveToNext());
                    ArrayAdapter<String> adapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,strings);
                    grvProduct.setAdapter(adapter);
                }
            }
        });


    }
}