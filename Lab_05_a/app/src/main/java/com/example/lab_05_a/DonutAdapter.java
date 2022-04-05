package com.example.lab_05_a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DonutAdapter extends BaseAdapter {
    ArrayList<Donut> donuts;
    int layout;
    Context context;

    public DonutAdapter(ArrayList<Donut> donuts, int layout, Context context) {
        this.donuts = donuts;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return donuts.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    class ViewHolder{
        ImageView imageView;
        TextView tvName,tvDes,tvPr;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view== null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder= new ViewHolder();
            holder.imageView= view.findViewById(R.id.imvItem);
            holder.tvDes= view.findViewById(R.id.tvDes);
            holder.tvPr= view.findViewById(R.id.tvPr);
            holder.tvName= view.findViewById(R.id.tvName);
            view.setTag(holder);

        }
        else{
            holder= (ViewHolder) view.getTag();
        }
        Donut donut= donuts.get(i);
        holder.tvName.setText(donut.getName());
        holder.tvPr.setText("$"+donut.getPrice());
        holder.tvDes.setText(donut.getDescription());
        holder.imageView.setImageResource(donut.getImage());

        return view;
    }
}
