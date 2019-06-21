package com.example.prestamo20;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PrestamoConPagos implements Serializable {

    @Embedded
    private Prestamo prestamo;

    @Relation(entity = Pagos.class,
    parentColumn = "id",
    entityColumn = "id_prestamo")
    List<Pagos> pagos = new ArrayList<>();

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public List<Pagos> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pagos> pagos) {
        this.pagos = pagos;
    }
}
