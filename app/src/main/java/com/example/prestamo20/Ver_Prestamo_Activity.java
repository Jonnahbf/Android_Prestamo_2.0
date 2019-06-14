package com.example.prestamo20;

import android.arch.persistence.room.Room;
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
    DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver__prestamo_);
        db= Room.databaseBuilder(getApplicationContext(),
                DataBase.class, "Prestamo").allowMainThreadQueries().build();
        lv = findViewById(R.id.lv);
        lista_prestamo = db.prestamoDao().ObtenerTodo();
        lista_cliente = db.clienteDao().ObtenerTodo();
        adapter = new Adaptador_Prestamo(lista_prestamo, lista_cliente, this);
        lv.setAdapter(adapter);
    }
}
