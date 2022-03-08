package com.example.demolistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class TraiCayAdapter extends BaseAdapter {
    private int layout;
    private Context context;
    private String[] dsTraiCay;

    public TraiCayAdapter(Context context,int layout,  String[] dsTraiCay) {
        this.layout = layout;
        this.context = context;
        this.dsTraiCay = dsTraiCay;
    }

    @Override
    public int getCount() {
        return dsTraiCay.length;
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

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
