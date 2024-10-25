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
        try{
       List<Equipo> equipos = equipoRepo.findAll();

       List<PrimeEquipoDTO> primeEquipos = new ArrayList<>();
       List<JugadorDTO> jugadoresDTO = new ArrayList<>();

       for (Equipo equipo : equipos) {
           primeEquipos.add(new PrimeEquipoDTO(equipo));
           List<Jugador> jugadores = jugadorRepo.findByEquipo_idEquipo(equipo.getIdEquipo());
           if(jugadores != null){
            for (Jugador j : jugadores) {
                jugadoresDTO.add(new JugadorDTO(j));
            }}
            else{
                jugadoresDTO.add(new JugadorDTO());
            }
           primeEquipos.get(primeEquipos.size()-1).setJugador(jugadoresDTO);
           jugadoresDTO = new ArrayList<>();
       }
       return primeEquipos;

        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List<PrimeEquipoDTO> findByName(String name) {
        try{
            List<Equipo> equipos = equipoRepo.findByNombre(name);
            List<PrimeEquipoDTO> primeEquipos = new ArrayList<>();
            List<JugadorDTO> jugadoresDTO = new ArrayList<>();
            for (Equipo equipo : equipos) {
                primeEquipos.add(new PrimeEquipoDTO(equipo));
                List<Jugador> jugadores = jugadorRepo.findByEquipo_idEquipo(equipo.getIdEquipo());
                if(jugadores != null){
                 for (Jugador j : jugadores) {
                     jugadoresDTO.add(new JugadorDTO(j));
                 }}
                 else{
                     jugadoresDTO.add(null);
                 }
                primeEquipos.get(primeEquipos.size()-1).setJugador(jugadoresDTO);
                jugadoresDTO = new ArrayList<>();
            }
            return primeEquipos;
     
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
        equipoRepo.deleteById(idEquipo);
    }

    public String test(){
        return "Working";
    }
    
}
