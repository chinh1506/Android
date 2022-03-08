package com.example.hocthem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hocthem.R;
import com.example.hocthem.model.TraiCay;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {

    private int layout;
    private Context context;
    private List<TraiCay> dsTraiCay;

    public TraiCayAdapter(int layout, Context context, List<TraiCay> dsTraiCay) {
        this.layout = layout;
        this.context = context;
        this.dsTraiCay = dsTraiCay;
    }

    @Override
    public int getCount() {
        return dsTraiCay.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder{
        TextView tvName;
        TextView tvMota;
        ImageView imgHinh;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view==null){
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(layout,null);
            holder= new ViewHolder();
            //ánh xạ
            holder.tvName=view.findViewById(R.id.tvName);
            holder.tvMota=view.findViewById(R.id.tvMota);
            holder.imgHinh= view.findViewById(R.id.imgHinh);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }

        TraiCay traiCay= dsTraiCay.get(i);

        holder.tvName.setText(traiCay.getName());
        holder.tvMota.setText(traiCay.getMoTa());
        holder.imgHinh.setImageResource(traiCay.getHinh());
        return view;
    }
}
