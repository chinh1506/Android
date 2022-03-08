package com.example.th2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.th2_2.adapter.NhanVienAdapter;
import com.example.th2_2.model.NhanVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<NhanVien> dsNhanVien;
    private NhanVienAdapter nhanVienAdapter;
    private EditText edtMaNV;
    private EditText edtTenNV;
    private RadioButton rdoNam;
    private RadioButton rdoNu;
    private ListView lvNhanVien;
    private ImageButton btnXoa;
    private List<Integer> integers;
    private Button btnThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        nhanVienAdapter= new NhanVienAdapter(this,R.layout.dong_nhan_vien,dsNhanVien);
        lvNhanVien.setAdapter(nhanVienAdapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dsNhanVien.add(getNhanVien());
                nhanVienAdapter.updateListView(dsNhanVien);
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=lvNhanVien.getChildCount()-1;i>-1;i--){
                    Log.println(Log.INFO,"NV",lvNhanVien.getChildCount()+"");
                    View view1= lvNhanVien.getChildAt(i);
                    CheckBox chkXoa=view1.findViewById(R.id.chkXoa);
                    if(chkXoa.isChecked()){
                        dsNhanVien.remove(i);
                    }
                }
                nhanVienAdapter.updateListView(dsNhanVien);
            }
        });
    }
public NhanVien getNhanVien(){
        return new NhanVien(edtMaNV.getText().toString().trim(),edtTenNV.getText().toString().trim(),rdoNam.isChecked());
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

        btnThem= findViewById(R.id.btnNhap);
        btnXoa= findViewById(R.id.btnXoa);
        lvNhanVien=findViewById(R.id.lvNhanVien);
        edtMaNV=findViewById(R.id.edtMaNv);
        edtTenNV=findViewById(R.id.edtTenNv);
        rdoNam=findViewById(R.id.rdoNam);
        rdoNu=findViewById(R.id.rdoNu);

    }

}