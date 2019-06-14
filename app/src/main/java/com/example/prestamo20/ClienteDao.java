package com.example.prestamo20;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ClienteDao {

    @Insert
    long Insertar(Client client);

    @Delete
    void Borrar(Client client);

    @Update
    void Actualizar(Client client);

    @Query("SELECT * FROM Client")
    List<Client> ObtenerTodo();

   @Query("SELECT * from Client where id=:id")
    Client ObtenerCLiente(int id);


}
