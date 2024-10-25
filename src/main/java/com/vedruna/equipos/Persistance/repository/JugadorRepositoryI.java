package com.vedruna.equipos.Persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedruna.equipos.Persistance.model.Jugador;
import java.util.List;


public interface JugadorRepositoryI extends JpaRepository<Jugador, Integer> {

    public List<Jugador> findAll();
    public Jugador findByNombre(String nombre);
    public Jugador findByIdjugador(int idjugador);
    public List<Jugador> findByEquipo_idEquipo(int idEquipo);
}
