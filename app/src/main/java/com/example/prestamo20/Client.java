package com.example.prestamo20;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;

@Entity
public class Client implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    public String nombre;
    public String apellido;
    public String telefono;
    public String sexo;
    public String cedula;
    public String ocupacion;
    public String direccion;



    public Client(){

    }

//    public Client(int id, String nombre, String apellido, String telefono, String sexo, String cedula, String ocupacion, String direccion) {
//        this.id = id;
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.telefono = telefono;
//        this.sexo = sexo;
//        this.cedula = cedula;
//        this.ocupacion = ocupacion;
//        this.direccion = direccion;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
