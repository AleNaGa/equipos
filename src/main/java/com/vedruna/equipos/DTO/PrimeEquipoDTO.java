package com.vedruna.equipos.DTO;

import com.vedruna.equipos.Persistance.model.Equipo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PrimeEquipoDTO {
    
    private int id;
    private String nombre;
    private JugadorDTO jugador;

    public PrimeEquipoDTO(Equipo equipo) {
        this.id = equipo.getIdEquipo();
        this.nombre = equipo.getNombre();
    }
}
