package com.example.prestamo20;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteConstraintException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.prestamo20.R.id.mn_pago_prestamo;

public class PagosActivity extends AppCompatActivity {

    PrestamoConCliente prestamoConCliente;
    int pago_inicial = 0;
    DataBase db;
    TextView cliente, monto, interes, plazo, fecha, fecha_fin, monto_a_pagar, monto_pagado;
    ListView lv;
    Adaptador_Pagos adaptador_pagos;
    List<Pagos> list_pagos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagos);

        db= Room.databaseBuilder(getApplicationContext(),
                DataBase.class, "Prestamo").allowMainThreadQueries().build();
        Bundle bundle = getIntent().getExtras();
        lv = findViewById(R.id.lv_pagos);
        prestamoConCliente = (PrestamoConCliente) bundle.getSerializable("ID");
        list_pagos.addAll(db.pagosDao().obtenerporId(prestamoConCliente.getPrestamo().getId()));

        adaptador_pagos = new Adaptador_Pagos(list_pagos, this);
        lv.setAdapter(adaptador_pagos);
        CargarDatos();
        CalcularPagos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pago_prestamo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case mn_pago_prestamo:
                AlertDialog.Builder builder = new AlertDialog.Builder(PagosActivity.this);
                builder.setTitle("Pago");
                final EditText etPago= new EditText(PagosActivity.this);
                etPago.setInputType(InputType.TYPE_CLASS_NUMBER);
                builder.setView(etPago);
                builder.setNegativeButton("Cancelar", null);
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        pago_inicial +=  Integer.parseInt(etPago.getText().toString());
                        monto_pagado.setText(String.valueOf(pago_inicial));
                        ActualizarListView(etPago);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void CargarDatos(){
        cliente = findViewById(R.id.tv_cliente);
        monto = findViewById(R.id.tv_monto);
        interes = findViewById(R.id.tv_interes);
        plazo = findViewById(R.id.tv_plazo);
        fecha = findViewById(R.id.tv_fecha);
        fecha_fin = findViewById(R.id.tv_fecha_fin);
        monto_a_pagar = findViewById(R.id.tv_monto_a_pagar);
        monto_pagado = findViewById(R.id.tv_monto_pagado);

        cliente.setText(prestamoConCliente.getClient().getNombre());
        monto.setText(prestamoConCliente.getPrestamo().getMonto());
        interes.setText(prestamoConCliente.getPrestamo().getInteres());
        plazo.setText(prestamoConCliente.getPrestamo().getPlazo());
        fecha.setText(prestamoConCliente.getPrestamo().getFecha_inicio());
        fecha_fin.setText(prestamoConCliente.getPrestamo().getFecha_fin());
        monto_a_pagar.setText(prestamoConCliente.getPrestamo().getMonto_pagar());
    }

    public void ActualizarListView(EditText editText){
        Pagos pagos = new Pagos();
        pagos.setPagos(Integer.parseInt(editText.getText().toString()));
        pagos.setId_prestamo(prestamoConCliente.getPrestamo().getId());
        try {
            long id = db.pagosDao().insertar(pagos);
            Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();

        list_pagos.add(pagos);
        adaptador_pagos.notifyDataSetChanged();
        }
        catch (SQLiteConstraintException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void CalcularPagos(){
        for(int i = 0; i< list_pagos.size(); i++){
            pago_inicial+=list_pagos.get(i).getPagos();
        }
        monto_pagado.setText(String.valueOf(pago_inicial));
    }
}
