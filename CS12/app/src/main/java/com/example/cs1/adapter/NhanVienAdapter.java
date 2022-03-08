package com.example.cs1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cs1.R;
import com.example.cs1.model.NhanVien;

import java.util.List;

public class NhanVienAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<NhanVien> nhanVienList;

    public NhanVienAdapter(Context context, int layout, List<NhanVien> nhanVienList) {
        this.context = context;
        this.layout = layout;
        this.nhanVienList = nhanVienList;
    }

    @Override
    public int getCount() {
        return nhanVienList.size();
    }

    @Override
    public Object getItem(int i) {
        return nhanVienList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder{
        ImageView imgvHinh;
        TextView tvMaTen;
        CheckBox chkXoa;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder= new ViewHolder();
            holder.imgvHinh=view.findViewById(R.id.imgvHinh);
            holder.tvMaTen=view.findViewById(R.id.tvMaTen);
            holder.chkXoa= view.findViewById(R.id.chkXoa);
            view.setTag(holder);
        }
        else {
            holder= (ViewHolder) view.getTag();
        }
        NhanVien nhanVien= nhanVienList.get(i);
        holder.tvMaTen.setText(nhanVien.getMaNhanVien()+" - "+nhanVien.getTenNhanVien());
        if(nhanVien.isGioiTinh())
            holder.imgvHinh.setImageResource(R.drawable.nam);
        else    holder.imgvHinh.setImageResource(R.drawable.nu);
        return view;
    }
}
