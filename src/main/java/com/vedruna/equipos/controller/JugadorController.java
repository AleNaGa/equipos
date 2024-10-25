package com.vedruna.equipos.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.equipos.DTO.JugadorDTO;
import com.vedruna.equipos.DTO.PrimeJugadorDTO;
import com.vedruna.equipos.services.JugadorServiceI;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/jugadores")
public class JugadorController {

    @Autowired
    private JugadorServiceI jugadorService;
    @GetMapping("/test")
    public String hello() {
        return jugadorService.test();
    }

   @GetMapping
    public List<PrimeJugadorDTO> getAllJugadores() {
        try{
            return jugadorService.findAll();
        }catch(Exception e){
            return Collections.emptyList();
        }
    }

    @GetMapping("/nombre/{name}")
    public PrimeJugadorDTO getJugadorByName(@PathVariable String name) {
        try{
            return jugadorService.findByName(name);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/insert")
    public String insertJugador(@RequestBody JugadorDTO jugador) {
        try{
            jugadorService.save(jugador);
            return "Jugador insertado correctamente";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    @PutMapping("/inscribir/{jugador}/{equipo}")
    public String inscribirEnEquipo(@PathVariable String jugador, @PathVariable String equipo) {
        try{
            jugadorService.inscribirEnEquipo(jugador, equipo);
            return "Jugador inscrito en equipo correctamente";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    @PutMapping("/echar/{nombreJugador}")
    public String echarJugador(@PathVariable String nombreJugador) {
        try{
            jugadorService.eliminarDelEquipo(nombreJugador);
            return "Jugador echado correctamente";
        }catch(Exception e){
            return e.getMessage();
        }
    }
    @DeleteMapping("/delete/{idJugador}")
    public String deleteJugador(@PathVariable int idJugador) {
        try{
            jugadorService.delete(idJugador);
            return "Jugador eliminado correctamente";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    
}
