package com.example.prestamo20;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface PagosDao{

    @Insert
    long insertar(Pagos pagos);

    @Query("Select * FROM Pagos where id_prestamo = :id")
    List<Pagos> obtenerporId(int id);
}
