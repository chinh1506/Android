package com.example.demolistview;

import static android.content.Context.*;

import android.content.Context;
import android.content.res.Configuration;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<SanPham> dssp;


    public GridAdapter(Context context, int layout, ArrayList<SanPham> dssp) {
        this.context = context;
        this.layout = layout;
        this.dssp = dssp;
    }

    @Override
    public int getCount() {
        return dssp.size();
    }

    @Override
    public Object getItem(int i) {
        return dssp.get(i);

    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class ViewHolder {
        ImageView imv;
        TextView tvGia, tvTen;

        public void reSize() {
            tvGia.setTextSize(16);
            tvTen.setTextSize(16);
        }
    }

    public void updateAdapter(ArrayList<SanPham> ds) {
        this.dssp = ds;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder = new ViewHolder();
            holder.imv = view.findViewById(R.id.imvHinhsp);
            holder.tvTen = view.findViewById(R.id.tvTen);
            holder.tvGia = view.findViewById(R.id.tvGia);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Configuration configuration=context.getResources().getConfiguration();
        if(configuration.orientation==Configuration.ORIENTATION_LANDSCAPE){
            holder.tvTen.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
            holder.tvGia.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
        }
        SanPham sanPham = dssp.get(i);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###" + " đ");
        holder.tvGia.setText(decimalFormat.format(sanPham.getGia()));
        holder.imv.setImageResource(sanPham.getHinhAnh());
        holder.tvTen.setText(sanPham.getTen());
        return view;
    }
}
