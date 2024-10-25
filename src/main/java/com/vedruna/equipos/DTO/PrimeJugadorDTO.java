package com.vedruna.equipos.DTO;

import com.vedruna.equipos.Persistance.model.Jugador;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PrimeJugadorDTO {

    private int id;
    private String nombre;
    private int edad;
    private String equipo;

    public PrimeJugadorDTO(Jugador jugador){
        this.id = jugador.getIdjugador();
        this.nombre = jugador.getNombre();
        this.edad = jugador.getEdad();
        if(jugador.getEquipo() == null){
            this.equipo = "Sin Equipo";
        }else{
            this.equipo = jugador.getEquipo().getNombre();
        }
       
    }
}
