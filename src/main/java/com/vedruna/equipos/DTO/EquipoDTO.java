package com.vedruna.equipos.DTO;

import com.vedruna.equipos.Persistance.model.Equipo;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class EquipoDTO {

    private int id;
    private String nombre;

    public EquipoDTO(Equipo equipo) {
        this.id = equipo.getIdEquipo();
        this.nombre = equipo.getNombre();
    }
}
