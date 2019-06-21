package com.example.prestamo20;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;
import static android.arch.persistence.room.ForeignKey.RESTRICT;

@Entity
public class Pagos {

    @PrimaryKey(autoGenerate = true)
    private int id_pagos;

    @ForeignKey(entity = Prestamo.class, parentColumns = "id_pagos", childColumns = "id_prestamo",
            onDelete = CASCADE,
            onUpdate = RESTRICT)
    private int id_prestamo;
    private int pagos;

    public Pagos(int id_pagos, int id_prestamo, int pagos) {
        this.id_pagos = id_pagos;
        this.id_prestamo = id_prestamo;
        this.pagos = pagos;
    }

    public Pagos(){

    }

    public int getId_pagos() {
        return id_pagos;
    }

    public void setId_pagos(int id_pagos) {
        this.id_pagos = id_pagos;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getPagos() {
        return pagos;
    }

    public void setPagos(int pagos) {
        this.pagos = pagos;
    }
}
