package com.example.ontap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DonutAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Donut> donuts;

    public DonutAdapter(Context context, int layout, ArrayList<Donut> donuts) {
        this.context = context;
        this.layout = layout;
        this.donuts = donuts;
    }

    @Override
    public int getCount() {
        return donuts.size();
    }

    @Override
    public Object getItem(int i) {
        return donuts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public void updateListview(ArrayList donuts){
        this.donuts=donuts;
        notifyDataSetChanged();
    }
    class ViewHolder {
        TextView tvName, tvDescription, tvPrice;
        ImageView imv;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout, null);
            holder = new ViewHolder();
            holder.tvName = view.findViewById(R.id.tvName);
            holder.tvDescription = view.findViewById(R.id.tvDescription);
            holder.tvPrice = view.findViewById(R.id.tvPrice);
            holder.imv = view.findViewById(R.id.imv);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        Donut donut=donuts.get(i);
        holder.imv.setImageResource(donut.getImage());
        holder.tvPrice.setText(""+donut.getPrice());
        holder.tvDescription.setText(donut.getDescription());
        holder.tvName.setText(donut.getName());
        return view;
    }
}
