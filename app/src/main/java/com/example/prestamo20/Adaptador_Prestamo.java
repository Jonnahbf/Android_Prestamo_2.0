package com.example.prestamo20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adaptador_Prestamo extends BaseAdapter{

    private List<Prestamo> lista_prestamo = new ArrayList<>();
    private List<Client> lista_cliente = new ArrayList<>();
    private Context context;

    public Adaptador_Prestamo(List<Prestamo> lista_prestamo, List<Client> lista_cliente, Context context) {
        this.lista_prestamo = lista_prestamo;
        this.lista_cliente = lista_cliente;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista_prestamo.size();
    }

    @Override
    public Object getItem(int position) {
        return lista_prestamo.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Prestamo ptr = (Prestamo) getItem(position);
        convertView = (View) LayoutInflater.from(context).inflate(R.layout.item_prestamo, null);
        TextView nombre = convertView.findViewById(R.id.tv_nombre);
        TextView monto = convertView.findViewById(R.id.tv_monto);
        TextView plazo = convertView.findViewById(R.id.tv_plazo);
        monto.setText(ptr.monto);
        plazo.setText(ptr.plazo);

        return convertView;
    }
}
