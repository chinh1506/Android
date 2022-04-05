package com.example.demolistview;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.text.DecimalFormat;

public class Fragment2 extends Fragment {
    private ImageView imvHinh;
    private TextView tvTen;
    private TextView tvGia;
    private TextView tvMota;
    private Button btnThanhToan;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_2,container,false);
        anhXa(view);
        SanPham sanPham=new SanPham(5, "CÀ RỐT HỮU CƠ – 500GR", R.drawable.carot, 39000, "CP Green là đứa con mới chào đời của tập đoàn CP Việt Nam, mang sứ mệnh đem Rau sạch đến mọi nhà để xứng danh là \"Kitchen on the World\".\n" +
                "\n" +
                "Rau sạch C.P Green:\n" +
                "\n" +
                "Đạt chứng nhận hữu cơ USDA và EU\n" +
                "Sản phẩm được sản xuất trực tiếp tại nông trại ở Đà Lạt. Đảm bảo sản phẩm đến tay khách hàng luôn tươi ngon và chất lượng nhất trong 24 giờ.\n" +
                "Cam kết 6 KHÔNG: không phân hoá học, không thuốc bảo vệ thực vật, không thuốc diệt cỏ, không kháng sinh, không tăng trọng, không thức ăn công nghiệp.\n" +
                "Đổi trả MIỄN PHÍ nếu không hài lòng.");
        setThongTin(sanPham);
        return view;
    }
    public void setThongTin(SanPham sanPham){
        imvHinh.setImageResource(sanPham.getHinhAnh());
        DecimalFormat decimalFormat= new DecimalFormat("###,###,###"+" đ");
        tvGia.setText(decimalFormat.format( sanPham.getGia()));
        tvMota.setText(sanPham.getMoTa());
        tvTen.setText(sanPham.getTen());
    }
    private void anhXa(View view) {
        imvHinh= view.findViewById(R.id.imvHinhsp);
        tvGia= view.findViewById(R.id.tvGiasp);
        tvMota= view.findViewById(R.id.tvMotasp);
        tvTen= view.findViewById(R.id.tvtenSp);

    }
}
