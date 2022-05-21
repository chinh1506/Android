package com.example;

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

public class ProductActivity extends AppCompatActivity {
    EditText edtId;
    EditText edtName;
    EditText edtUnit;
    EditText edtMadein;
    GridView grvProduct;
    static final String URI="content://com.example";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        edtId=findViewById(R.id.edtId);
        edtName=findViewById(R.id.edtName);
        edtUnit=findViewById(R.id.edtUnit);
        edtMadein=findViewById(R.id.edtMadein);
        grvProduct=findViewById(R.id.grvProduct);

        Button btnSave= findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values= new ContentValues();
                values.put("id",edtId.getText().toString().trim());
                values.put("name",edtName.getText().toString().trim());
                values.put("unit",edtUnit.getText().toString().trim());
                values.put("madein",edtMadein.getText().toString().trim());
                Uri product=Uri.parse(URI);
                Uri insertUri= getContentResolver().insert(product,values);
                Toast.makeText(getApplicationContext(),"da luu",Toast.LENGTH_SHORT).show();
            }
        });
        Button btnSelect=findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> strings= new ArrayList<>();
                Uri product= Uri.parse(URI);
                Cursor cursor=getContentResolver().query(product,null,null,null,"name");
                if(cursor!= null){
                    cursor.moveToFirst();
                    do {
                        strings.add(cursor.getInt(0)+"");
                        strings.add(cursor.getString(1));
                        strings.add(cursor.getString(2));
                        strings.add(cursor.getString(3));
                    }while (cursor.moveToNext());
                    ArrayAdapter<String> adapter=new ArrayAdapter<>(ProductActivity.this, android.R.layout.simple_list_item_1,strings);
                    grvProduct.setAdapter(adapter);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Khong co ket qua",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}