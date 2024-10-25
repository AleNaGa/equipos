package com.vedruna.equipos.Persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedruna.equipos.Persistance.model.Equipo;

public interface EquipoRepositoryI extends JpaRepository<Equipo, Integer> {

    List<Equipo> findAll();
    List<Equipo> findByNombre(String nombre);
    Equipo findByIdEquipo(int idEquipo);
}
