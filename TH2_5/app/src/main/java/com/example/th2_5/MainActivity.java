package com.example.th2_5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.th2_5.model.HoaDon;
import com.example.th2_5.model.KhachHang;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText edtTenKh;
    private EditText edtSoLuongSach;
    private CheckBox chkVip;
    private TextView tvThanhTien;
    private Button btnTinh;
    private Button btnTiep;
    private Button btnThongKe;
    private EditText edtTongKH;
    private EditText edtTongKHVip;
    private EditText edtTongDoanhThu;
    private ImageButton btnThoat;
    private List<HoaDon> dsHoaDon=null;
    private HoaDon hoaDon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        if(dsHoaDon==null){
            dsHoaDon= new ArrayList<HoaDon>();
        }
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoaDon= getHD();
                tvThanhTien.setText(hoaDon.tinhThanhTien()+"");
            }
        });
        btnTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dsHoaDon.add(hoaDon);

            }
        });
        btnThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dsHoaDon.size() > 0) {
                    edtTongKH.setText(dsHoaDon.size()+"");
                    int i = 0;
                    double tongDoanhThu = 0;
                    for (HoaDon hd : dsHoaDon) {
                        if (hd.getKhachHang().isVip())
                            i++;
                        tongDoanhThu += hd.tinhThanhTien();
                    }
                    Log.println(Log.INFO,"Thông báo","i "+i);
                    edtTongKHVip.setText(i+"");
                    edtTongDoanhThu.setText(tongDoanhThu + "");
                }
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    private KhachHang getKH(){
        return new KhachHang(edtTenKh.getText().toString().trim(),chkVip.isChecked());
    }
    private HoaDon getHD(){
        return new HoaDon(Integer.parseInt(edtSoLuongSach.getText().toString().trim()),getKH());
    }
    private void anhXa() {
        edtTenKh= findViewById(R.id.edtTen);
        edtSoLuongSach= findViewById(R.id.edtSoLuong);
        chkVip= findViewById(R.id.chkVip);
        tvThanhTien= findViewById(R.id.tvThanhTien);
        btnTinh= findViewById(R.id.btnTinh);
        btnTiep= findViewById(R.id.btnTiep);
        btnThongKe= findViewById(R.id.btnThongKe);
        edtTongKH= findViewById(R.id.edtTongKH);
        edtTongKHVip= findViewById(R.id.edtKhVip);
        edtTongDoanhThu= findViewById(R.id.edtTongDoanhThu);
        btnThoat= findViewById(R.id.btnThoat);
    }
}