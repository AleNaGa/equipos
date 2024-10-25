package com.vedruna.equipos.services;

import java.util.List;

import com.vedruna.equipos.DTO.JugadorDTO;
import com.vedruna.equipos.DTO.PrimeJugadorDTO;

public interface JugadorServiceI {
    List<PrimeJugadorDTO> findAll();

    PrimeJugadorDTO findByName(String name);
    void save(JugadorDTO jugador); //un jugador simple sin equipo Equipo = null
    void delete(int idJugador);
    void inscribirEnEquipo(String jugador, String equipo);
    void eliminarDelEquipo(String nombre);
    String test();
}
