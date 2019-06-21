package com.example.prestamo20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adaptador_Pagos extends BaseAdapter {

    private Context context;
    List<Pagos> list_pagos = new ArrayList<>();

    public Adaptador_Pagos(List<Pagos> list_pagos, Context context){
        this.list_pagos = list_pagos;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list_pagos.size();
    }

    @Override
    public Object getItem(int position) {
        return list_pagos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = (View) LayoutInflater.from(context).inflate(R.layout.item_pagos, null);
        TextView pagos = convertView.findViewById(R.id.tv_pagos);
        pagos.setText(String.valueOf(list_pagos.get(position).getPagos()));
        return convertView;
    }
}
