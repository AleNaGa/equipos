package com.vedruna.equipos.services;

import java.util.List;

import com.vedruna.equipos.DTO.EquipoDTO;
import com.vedruna.equipos.DTO.PrimeEquipoDTO;

public interface EquipoServiceI {

    List<PrimeEquipoDTO> findAll();
    List<PrimeEquipoDTO> findByName(String name);

    void save(EquipoDTO equipo);
    void delete(int idEquipo);

    String test();

}
