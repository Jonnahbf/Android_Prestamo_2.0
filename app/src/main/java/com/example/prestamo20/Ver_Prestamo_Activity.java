package com.example.prestamo20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Ver_Prestamo_Activity extends AppCompatActivity {
    public List<Prestamo> lista_prestamo = new ArrayList<>();
    public List<Client> lista_cliente = new ArrayList<>();
    public Adaptador_Prestamo adapter;
    public ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver__prestamo_);
        lv = findViewById(R.id.lv);
        Bundle bundle= getIntent().getExtras();
        lista_prestamo = (List<Prestamo>) bundle.get("prestamos");
        lista_cliente = (List<Client>) bundle.get("cliente");
        adapter = new Adaptador_Prestamo(lista_prestamo, lista_cliente, this);
        lv.setAdapter(adapter);
    }
}
