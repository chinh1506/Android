package com.example.cs1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.cs1.adapter.NhanVienAdapter;
import com.example.cs1.model.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<NhanVien> dsNhanVien;
    private NhanVienAdapter nhanVienAdapter;
    private EditText edtMaNV;
    private EditText edtTenNV;
    private RadioButton rdoNam;
    private RadioButton rdoNu;
    private ListView lvNhanVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        nhanVienAdapter= new NhanVienAdapter(this,R.layout.dong_nhan_vien,dsNhanVien);
        lvNhanVien.setAdapter(nhanVienAdapter);
    }

    private void anhXa() {
        dsNhanVien= new ArrayList<NhanVien>();
        NhanVien nhanVien= new NhanVien("001","chinh",true);
        NhanVien nhanVien1= new NhanVien("002","chinh",true);
        NhanVien nhanVien2= new NhanVien("003","chinh",false);
        NhanVien nhanVien3= new NhanVien("004","chinh",false);
        NhanVien nhanVien4= new NhanVien("005","chinh",true);
        NhanVien nhanVien5= new NhanVien("006","chinh",true);
        dsNhanVien.add(nhanVien);
        dsNhanVien.add(nhanVien1);
        dsNhanVien.add(nhanVien2);
        dsNhanVien.add(nhanVien3);
        dsNhanVien.add(nhanVien4);
        dsNhanVien.add(nhanVien5);

        lvNhanVien=findViewById(R.id.lvNhanVien);
        edtMaNV=findViewById(R.id.edtMaNv);
        edtTenNV=findViewById(R.id.edtTenNv);
        rdoNam=findViewById(R.id.rdoNam);
        rdoNu=findViewById(R.id.rdoNu);

    }

}