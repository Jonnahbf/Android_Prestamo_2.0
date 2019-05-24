package com.example.prestamo20;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Registro_Prestamo extends AppCompatActivity {
    public static List<Client> lista_clientes = new ArrayList<>();
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro__prestamo);
        Bundle bundle= getIntent().getExtras();
        lista_clientes = (List<Client>) bundle.get("cliente");
        position = (int) bundle.get("numero");
        rellenar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_prestamo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(this, CalcularPrestamoActivity.class);
        startActivityForResult(i, 1234);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1234) { //El codigo que enviamos a la activity que registra los clientes
            if (resultCode != 0) { //Si el usuario da clic en Guardar
                Prestamo ptr = (Prestamo) data.getExtras().getSerializable("prestamo"); //Obtenemos los datos que nos envia la activity donde se registran los prestamos
                Intent intent = new Intent();
                intent.putExtra("prestamo", ptr);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void rellenar(){
        TextView tvnombre = findViewById(R.id.tv_nombre);
        TextView tvapellido = findViewById(R.id.tv_apellido);
        TextView tvsexo = findViewById(R.id.tv_sexo);
        TextView tvtelefono = findViewById(R.id.tv_telefono);
        TextView tvcedula = findViewById(R.id.tv_cedula);
        TextView tvocupacion = findViewById(R.id.tv_ocupacion);
        TextView tvdireccion = findViewById(R.id.tv_direccion);
        Client cl = lista_clientes.get(position);
        tvnombre.setText(cl.nombre);
        tvapellido.setText(cl.apellido);
        tvcedula.setText(cl.cedula);
        tvsexo.setText(cl.sexo);
        tvdireccion.setText(cl.direccion);
        tvtelefono.setText(cl.telefono);
        tvocupacion.setText(cl.ocupacion);
    }
}
