package com.example.uidemo;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
    private String[] dsDonVi;
    private String donVi;
    private Button btnThoat;
    private EditText edtMa;
    private EditText edtHoTen;
    private RadioButton rdoNam;
    private RadioButton rdoNu;
    private RadioGroup radioGroup;
    private ImageView imvAnh;
    private Button btnXoa;
    private Button btnThem;
    private Button btnTruyVan;
    private Spinner spinner;
    private ListView listView;
    private Button btnChoose;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        dsDonVi = getResources().getStringArray(R.array.phong_ban);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dsDonVi);
        spinner.setAdapter(adapter);
        NhanVienAdapter nhanVienAdapter = new NhanVienAdapter(this, dsNhanVien, R.layout.dong_nhan_vien);
        ArrayAdapter nhanVienAdt = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dsNhanVien);
        listView.setAdapter(nhanVienAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donVi = dsDonVi[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ma = Integer.parseInt(edtMa.getText().toString().trim());
                String ten = edtHoTen.getText().toString().trim();
                boolean gt = rdoNam.isChecked();

                NhanVien nhanVien = new NhanVien(ma, ten, gt, donVi, uri);

                dsNhanVien.add(nhanVien);

                nhanVienAdapter.updateListView(dsNhanVien);
            }
        });
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Title"), 1);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView ma=view.findViewById(R.id.tvMa);
                TextView ten=view.findViewById(R.id.tvTen);
                TextView gt=view.findViewById(R.id.tvGt);
                TextView dv=view.findViewById(R.id.tvDonVi);
                ImageView hinh=view.findViewById(R.id.imvHinh);
                edtMa.setText(ma.getText().toString());
                edtHoTen.setText(ten.getText().toString());
                if(gt.getText().toString().equals("Nam")){
                    rdoNu.setChecked(false);
                    rdoNam.setChecked(true);
                }else{
                    rdoNu.setChecked(true);
                    rdoNam.setChecked(false);
                }
                Bitmap bitmap= convertImageViewToBitmap(hinh);
                imvAnh.setImageBitmap(bitmap);

            }
        });

    }
    private Bitmap convertImageViewToBitmap(ImageView v){

        Bitmap bm=((BitmapDrawable)v.getDrawable()).getBitmap();

        return bm;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            uri = data.getData();
            imvAnh.setImageURI(uri);
        }

    }
    public void clickItemListView(){

    }
    private void anhXa() {
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnTruyVan = findViewById(R.id.btnTruyVan);
        btnThoat = findViewById(R.id.btnThoat);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtMa = findViewById(R.id.edtMa);
        radioGroup = findViewById(R.id.rdoGioiTinh);
        spinner = findViewById(R.id.spnDonVi);
        listView = findViewById(R.id.lv);
        rdoNam = findViewById(R.id.rdoNam);
        rdoNu = findViewById(R.id.rdoNu);
        imvAnh= findViewById(R.id.imvAnh);
        btnChoose= findViewById(R.id.btnChoose);
    }

}