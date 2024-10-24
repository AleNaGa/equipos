package com.vedruna.equipos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.equipos.DTO.EquipoDTO;
import com.vedruna.equipos.DTO.PrimeEquipoDTO;
import com.vedruna.equipos.services.EquipoServiceI;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/equipos")
public class EquipoController {
    @Autowired
    private EquipoServiceI equipoService;

    @GetMapping("/test")
    public String hello() {
        return "Hello World";
    }

    @GetMapping
    public List<PrimeEquipoDTO> getAllEquipos() {
        return equipoService.findAll();
    }

    @GetMapping("/nombre/{name}")
    public List<PrimeEquipoDTO> getEquipoByName(@PathVariable String name) {
        return equipoService.findByName(name);
    }

    @PostMapping("/insert")
    public String insertEquipo(@RequestBody EquipoDTO equipo) {
        equipoService.save(equipo);
        return "Equipo insertado correctamente";
    }

    @DeleteMapping("/delete/{idEquipo}")
    public String deleteEquipo(@PathVariable int idEquipo) {
        equipoService.delete(idEquipo);
        return "Equipo eliminado correctamente";
    }
    
}
