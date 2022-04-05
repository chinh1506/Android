package com.example.demolistview;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Fragment1 extends Fragment {
    ArrayList<SanPham> dssp;
    GridAdapter adapter;
    TruyenSanPham truyenSanPham;
    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        gridView = view.findViewById(R.id.grv);
        ganDuLieu();
        truyenSanPham = (TruyenSanPham) getActivity();
        truyenSanPham.dsSanPham(dssp);
        adapter = new GridAdapter(getActivity(), R.layout.san_pham, dssp);
        gridView.setAdapter(adapter);
        Toast.makeText(getActivity(),gridView.getChildCount()+"",Toast.LENGTH_SHORT).show();

        Configuration configuration=getResources().getConfiguration();


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                truyenSanPham.dataSanPham(dssp.get(i));
                Log.println(Log.INFO, "log", gridView.getChildCount() + "");
                Log.println(Log.INFO, "log", dssp.get(i) + "");
                view.setSelected(true);
            }
        });

        return view;
    }


    public void setNumColGrid(int num) {
        gridView.setNumColumns(num);
    }

    public void setAdapter(GridAdapter adapter) {
        gridView.setAdapter(adapter);
    }

    public void ganDuLieu() {
        dssp = new ArrayList<SanPham>();
        dssp.add(new SanPham(1, "Sữa bột Ensual", R.drawable.img, 299000, "CP Green là đứa con mới chào đời của tập đoàn CP Việt Nam, mang sứ mệnh đem Rau sạch đến mọi nhà để xứng danh là \"Kitchen on the World\".\n"));
        dssp.add(new SanPham(10, "TÔM THẺ NGUYÊN CON SIZE 21/25 - 500G", R.drawable.tomthe, 199000, "Tôm thẻ chân trắng nguyên con được làm sạch cẩn thận:\n" +
                "\n" +
                "\n" +
                "- Không qua muối nước\n" +
                "\n" +
                "- Không kháng sinh\n" +
                "\n" +
                "- Không tạp chất\n" +
                "\n" +
                "Cách chế biến: đông hoàn toàn sau đó hấp, nướng, nấu lẩu, suace trứng muối, kho tàu…\n" +
                "\n" +
                "\n" +
                "Bảo quản: Trong tủ đông hoặc ngăn đông tủ lạnh\n" +
                "\n" +
                "\n" +
                "Đóng gói : Có hai quy cách như sau: size 50 con/ 1kg và size 60 con/ 1 kg.\n" +
                "Thành Phần: Tôm thẻ chân trắng nguyên con size nhỏ \n" +
                "Không qua muối nước, không kháng sinh, không tạp chất\n" +
                "Đóng gói : Sơ mi block 500gr/ hộp 25 con."));
        dssp.add(new SanPham(9, "DA CÁ VỊ RONG BIỂN CAY CP 50G", R.drawable.daca, 119000, "CP Green là đứa con mới chào đời của tập đoàn CP Việt Nam, mang sứ mệnh đem Rau sạch đến mọi nhà để xứng danh là \"Kitchen on the World\".\n"));
        dssp.add(new SanPham(2, "Sữa tươi Vinamilk", R.drawable.img_1, 24000, "CP Green là đứa con mới chào đời của tập đoàn CP Việt Nam, mang sứ mệnh đem Rau sạch đến mọi nhà để xứng danh là \"Kitchen on the World\".\n"));
        dssp.add(new SanPham(3, "Sữa Milo", R.drawable.img_2, 28000, "CP Green là đứa con mới chào đời của tập đoàn CP Việt Nam, mang sứ mệnh đem Rau sạch đến mọi nhà để xứng danh là \"Kitchen on the World\".\n"));
        dssp.add(new SanPham(4, "Sua Vinamilk 4 hộp", R.drawable.img_3, 32000, "CP Green là đứa con mới chào đời của tập đoàn CP Việt Nam, mang sứ mệnh đem Rau sạch đến mọi nhà để xứng danh là \"Kitchen on the World\".\n"));
        dssp.add(new SanPham(8, "XÚC XÍCH GOLD TIỆT TRÙNG - 100G", R.drawable.xucxich, 89000, "THÔNG TIN SẢN PHẨM\n" +
                "\n" +
                "Xúc xích Gold CP là sự kết hợp độc đáo giữa hương vị của các loại thịt gà, thịt lợn và gia vị, tạo nên một món ăn đặc trưng, hấp dẫn. Sản phẩm mang đến những trải nghiệm mới trong các món ăn chế biến sẵn. Xúc xích được sản xuất trên dây chuyền hiện đại với những nguyên liệu tự nhiên được chọn lọc kỹ lưỡng. Đặc biệt, xúc xích Gold CP không sử dụng màu phụ gia, chất bảo quản nên đảm bảo an toàn cho người sử dụng.\n" +
                "\n" +
                "Với xúc xích Gold CP, các bà nội trợ sẽ tiết kiệm đáng kể thời gian nấu nướng cũng như công sức chế biến mà vẫn có món ăn thơm ngon, bổ dưỡng. Ngoài ra, có thể dùng trong bữa ăn nhẹ, ăn sáng, dùng với cơm, mì đều rất thơm ngon.\n" +
                "\n" +
                "Thành phần: thịt gà, thịt heo, mỡ, tinh bột, muối, đường; chất bảo quản: Sodium Acetate (E262i), Sodium  Lactate (E325); chất điều vị: Monsodium Glutamate (E621); chất nhũ hóa: Pentansodium Triphosphate (E451i), Sodium Polyphosphate (E452i)\n" +
                "\n" +
                "Hướng dẫn sử dụng: Dùng ăn ngay hoặc chế biến món ăn tùy thích.\n" +
                "\n" +
                "Hướng dẫn bảo quản: Bảo quản ở nhiệt độ thường, nơi khô ráo, thoáng mát.\n" +
                "\n" +
                "Tiêu chuẩn:\n" +
                "\n" +
                "ISO 9001:2000\n" +
                "\n" +
                "ISO 14001:2004\n" +
                "\n" +
                "GMP\n" +
                "\n" +
                "HACCP\n" +
                "\n" +
                "Sản xuất bởi:\n" +
                "\n" +
                "Công ty: CP chăn nuôi C.P Việt Nam\n" +
                "\n" +
                "Địa chỉ: Số 11 - Lô 13 - Đường 19A - KCN Biên Hòa 2 - Đồng Nai"));
        dssp.add(new SanPham(7, "BẮP CẢI TÍM HỮU CƠ - 1KG", R.drawable.caitim, 29000, "CP Green là đứa con mới chào đời của tập đoàn CP Việt Nam, mang sứ mệnh đem Rau sạch đến mọi nhà để xứng danh là \"Kitchen on the World\""));
        dssp.add(new SanPham(5, "CÀ RỐT HỮU CƠ – 500GR", R.drawable.carot, 39000, "CP Green là đứa con mới chào đời của tập đoàn CP Việt Nam, mang sứ mệnh đem Rau sạch đến mọi nhà để xứng danh là \"Kitchen on the World\".\n" +
                "\n" +
                "Rau sạch C.P Green:\n" +
                "\n" +
                "Đạt chứng nhận hữu cơ USDA và EU\n" +
                "Sản phẩm được sản xuất trực tiếp tại nông trại ở Đà Lạt. Đảm bảo sản phẩm đến tay khách hàng luôn tươi ngon và chất lượng nhất trong 24 giờ.\n" +
                "Cam kết 6 KHÔNG: không phân hoá học, không thuốc bảo vệ thực vật, không thuốc diệt cỏ, không kháng sinh, không tăng trọng, không thức ăn công nghiệp.\n" +
                "Đổi trả MIỄN PHÍ nếu không hài lòng."));
        dssp.add(new SanPham(6, "KHỔ QUA HỮU CƠ", R.drawable.khoqua, 49000, "CP Green là đứa con mới chào đời của tập đoàn CP Việt Nam, mang sứ mệnh đem Rau sạch đến mọi nhà để xứng danh là \"Kitchen on the World\".\n" +
                "\n" +
                "Rau sạch C.P Green:\n" +
                "\n" +
                "Đạt chứng nhận hữu cơ USDA và EU\n" +
                "Sản phẩm được sản xuất trực tiếp tại nông trại ở Đà Lạt. Đảm bảo sản phẩm đến tay khách hàng luôn tươi ngon và chất lượng nhất trong 24 giờ.\n" +
                "Cam kết 6 KHÔNG: không phân hoá học, không thuốc bảo vệ thực vật, không thuốc diệt cỏ, không kháng sinh, không tăng trọng, không thức ăn công nghiệp.\n" +
                "Đổi trả MIỄN PHÍ nếu không hài lòng.\n"));
    }
}
