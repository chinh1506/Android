package com.example.uidemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NhanVienAdapter extends BaseAdapter {
    ArrayList<NhanVien> dsNhanVien;
    Context context;
    int layout;

    public NhanVienAdapter(Context context, ArrayList<NhanVien> dsNhanVien, int layout) {
        this.dsNhanVien = dsNhanVien;
        this.context = context;
        this.layout = layout;
    }



    @Override
    public int getCount() {
        return dsNhanVien.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class ViewHolder {
        TextView tvMa, tvTen, tvGt, tvDv;
        ImageView imvHinh;

    }

    public void updateListView(ArrayList<NhanVien> dsNhanVien) {
        this.dsNhanVien = dsNhanVien;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder = new ViewHolder();
            holder.tvDv = view.findViewById(R.id.tvDonVi);
            holder.tvGt = view.findViewById(R.id.tvGt);
            holder.tvMa = view.findViewById(R.id.tvMa);
            holder.tvTen = view.findViewById(R.id.tvTen);
            holder.imvHinh= view.findViewById(R.id.imvHinh);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        NhanVien nhanVien = dsNhanVien.get(i);
        holder.tvDv.setText(nhanVien.getDonVi().toString());
        holder.tvMa.setText(nhanVien.getMa()+"");
        holder.tvTen.setText(nhanVien.getHoTen().toString());
        holder.tvGt.setText((nhanVien.isGioiTinh() ? "Nam" : "Nu"));
        holder.imvHinh.setImageURI(nhanVien.getHinh());
        return view;
    }
}
