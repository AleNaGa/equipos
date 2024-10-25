package com.vedruna.equipos.DTO;

import com.vedruna.equipos.Persistance.model.Jugador;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JugadorDTO {
    
    private int id;
    private String nombre;
    private int edad;

    public JugadorDTO(Jugador jugador){
        this.id = jugador.getIdjugador();
        this.nombre = jugador.getNombre();
        this.edad = jugador.getEdad();
    }
}
