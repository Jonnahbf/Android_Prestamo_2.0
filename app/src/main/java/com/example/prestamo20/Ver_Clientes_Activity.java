package com.example.prestamo20;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ver_Clientes_Activity extends AppCompatActivity {
    RecyclerView rv;
    public static List<Client> lista_clientes = new ArrayList<>();
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver__clientes_);
        rv = (RecyclerView)findViewById(R.id.rv);
        Bundle bundle= getIntent().getExtras();
        lista_clientes = (List<Client>) bundle.get("clientes");
        final RvAdapter adapter = new RvAdapter(lista_clientes);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = rv.getChildAdapterPosition(v);
                llamada(position);

            }
        });
        GridLayoutManager llm = new GridLayoutManager(this,1);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);

    }

    public void onClick_borrar(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Borrar");
        builder.setMessage("Desea borrar?");
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Ver_Clientes_Activity.this, "Borrado", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onClick_editar(View view){
        Toast.makeText(this, "Editar", Toast.LENGTH_SHORT).show();
    }

    public void llamada(int position){
        Intent intent = new Intent(this, Registro_Prestamo.class);
        intent.putExtra("cliente", (Serializable) lista_clientes);
        intent.putExtra("numero", position);
        startActivityForResult(intent, 9999);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==9999 && resultCode!=0){
            Prestamo nuevo = (Prestamo) data.getExtras().getSerializable("prestamo");
            Intent intent = new Intent();
            intent.putExtra("prestamo", nuevo);
            setResult(RESULT_OK, intent);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
