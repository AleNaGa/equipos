package com.vedruna.equipos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.equipos.DTO.JugadorDTO;
import com.vedruna.equipos.DTO.PrimeJugadorDTO;
import com.vedruna.equipos.Persistance.model.Equipo;
import com.vedruna.equipos.Persistance.model.Jugador;
import com.vedruna.equipos.Persistance.repository.EquipoRepositoryI;
import com.vedruna.equipos.Persistance.repository.JugadorRepositoryI;

@Service
public class JugadorServiceImpl implements JugadorServiceI {

    @Autowired
    private JugadorRepositoryI jugadorRepo;
    @Autowired 
    private EquipoRepositoryI equipoRepo;
    @Override
    public List<PrimeJugadorDTO> findAll() {
       List<Jugador> jugadores = jugadorRepo.findAll();
       List<PrimeJugadorDTO> primeJugadores = new ArrayList<>();
       for (Jugador jugador : jugadores) {
           primeJugadores.add(new PrimeJugadorDTO(jugador));
       }
       return primeJugadores;
    }

    @Override
    public PrimeJugadorDTO findByName(String name) {
       try{
           return new PrimeJugadorDTO(jugadorRepo.findByNombre(name));
       }catch(Exception e){
           System.out.println(e.getMessage());
           return null;
       }
    }

    @Override
    public void save(JugadorDTO jugador) {
        Jugador newJugador = new Jugador();
        newJugador.setEdad(jugador.getEdad());
        newJugador.setNombre(jugador.getNombre());
        try{
            jugadorRepo.save(newJugador);
        }catch(Exception e){
            e.getMessage();
        }
    }

    @Override
    public void delete(int idJugador) {
       try{
           jugadorRepo.deleteByIdjugador(idJugador);
       }catch(Exception e){
           e.getMessage();
       }
    }

    @Override
    public void inscribirEnEquipo(int idJugador, int idEquipo) {
        try{
            Jugador jugador = jugadorRepo.findByIdjugador(idJugador);
            Equipo equipo = equipoRepo.findByIdEquipo(idEquipo);
            jugador.setEquipo(equipo);
            jugadorRepo.save(jugador);
        }catch(Exception e){
            e.getMessage();
        }
    }

    @Override
    public void eliminarDelEquipo(String nombreJugador) {
        try{
            Jugador jugador = jugadorRepo.findByNombre(nombreJugador);
            jugador.setEquipo(null);
            jugadorRepo.save(jugador);
        }catch(Exception e){
            e.getMessage();
        }
    }


    public String test(){
        return "Hello World";
    }

    
}
