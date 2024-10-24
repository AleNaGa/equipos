package com.vedruna.equipos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.equipos.DTO.EquipoDTO;
import com.vedruna.equipos.DTO.JugadorDTO;
import com.vedruna.equipos.DTO.PrimeEquipoDTO;
import com.vedruna.equipos.Persistance.model.Equipo;
import com.vedruna.equipos.Persistance.model.Jugador;
import com.vedruna.equipos.Persistance.repository.EquipoRepositoryI;
import com.vedruna.equipos.Persistance.repository.JugadorRepositoryI;

@Service
public class EquipoServiceImpl implements EquipoServiceI {

    @Autowired
    private EquipoRepositoryI equipoRepo;
    @Autowired
    private JugadorRepositoryI jugadorRepo;

    @Override
    public List<PrimeEquipoDTO> findAll() {
       List<Equipo> equipos = equipoRepo.findAll();
       List<PrimeEquipoDTO> primeEquipos = new ArrayList<>();
       for (Equipo equipo : equipos) {
            PrimeEquipoDTO equipoDTO = new PrimeEquipoDTO(equipo);
            List<Jugador> jugadores = jugadorRepo.findByEquipo_idEquipo(equipoDTO.getId());
            List<JugadorDTO> jugadoresDTO = jugadores.stream().map(j -> new JugadorDTO(j)).toList();
                for (JugadorDTO jug : jugadoresDTO) {
                    equipoDTO.getJugador().add(jug);
                }
            primeEquipos.add(equipoDTO);
       }
       return primeEquipos;
    }

    @Override
    public PrimeEquipoDTO findByName(String name) {
        try{
            PrimeEquipoDTO equipo = new PrimeEquipoDTO(equipoRepo.findByNombre(name));
            List<Jugador> jugadores = jugadorRepo.findByEquipo_idEquipo(equipo.getId());
            List<JugadorDTO> jugadoresDTO = jugadores.stream().map(j -> new JugadorDTO(j)).toList();
            for (JugadorDTO jug : jugadoresDTO) {
                equipo.getJugador().add(jug);
            }
            return equipo;

        }catch(Exception e){
            return null;
        }
    }

    @Override
    public void save(EquipoDTO equipo) {
        Equipo newEquipo = new Equipo();
        newEquipo.setNombre(equipo.getNombre());
        equipoRepo.save(newEquipo);
    }

    @Override
    public void delete(int idEquipo) {
        equipoRepo.deleteByIdEquipo(idEquipo);
    }

    public String test(){
        return "Working";
    }
    
}
