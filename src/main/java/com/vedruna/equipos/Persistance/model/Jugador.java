package com.vedruna.equipos.Persistance.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "jugadores")
public class Jugador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjugador")
    private int idjugador;

    @Column(name="nombre", nullable=false, length = 45)
    private String nombre;

    @Column(name="edad", nullable=false)
    private int edad;

    @ManyToOne
    @JoinColumn(name = "equipos_idequipo", nullable=true)//Para cuando registremos un jugador sin equipo, no sé si es default que sea true nullable pero lo pongo para acordarme
    private Equipo equipo;

}
