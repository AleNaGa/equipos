package com.vedruna.equipos.DTO;

import java.util.List;

import com.vedruna.equipos.Persistance.model.Equipo;
import com.vedruna.equipos.Persistance.model.Jugador;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PrimeEquipoDTO {
    
    private int id;
    private String nombre;
    private List<JugadorDTO> jugador;

    public PrimeEquipoDTO(Equipo equipo) {
        this.id = equipo.getIdEquipo();
        this.nombre = equipo.getNombre();
    }
}
